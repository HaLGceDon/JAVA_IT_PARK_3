package ru.itpark.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.forms.PasswordForm;
import ru.itpark.forms.PasswordRecoveryForm;
import ru.itpark.forms.RegistrationForm;
import ru.itpark.models.User.Role;
import ru.itpark.models.User.State;
import ru.itpark.models.User.User;
import ru.itpark.repositories.UsersRepository;

import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {


  @Autowired
  private UsersRepository usersRepository;


  @Autowired
  private JavaMailSender javaMailSender;

  private PasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  @SneakyThrows
  public String registration(RegistrationForm form) {
    String hashPassword = encoder.encode(form.getPassword());
    LocalDateTime registrationTime = LocalDateTime.now();
    String confirmString = UUID.randomUUID().toString().replace("-","");

    Optional<User> userCheckLogin = usersRepository.findByLogin(form.getLogin());
    if (userCheckLogin.isPresent()) {
      return "bad_login";
     // throw new IllegalArgumentException("This login is busy.");
    }
    Optional<User> userCheckEmail = usersRepository.findByEmail(form.getEmail());
    if (userCheckEmail.isPresent()) {
      return "bad_email";
      //throw new IllegalArgumentException("This Email is busy.");
    }

    User newUser = User.builder()
            .name(form.getName())
            .confirmCode(confirmString)
            .age(form.getAge())
            .email(form.getEmail())
            .login(form.getLogin())
            .surname(form.getSurname())
            .hashPassword(hashPassword)
            .registrationTime(registrationTime)
            .state(State.NOT_CONFIRMED)
            .role(Role.USER)
            .build();

    usersRepository.save(newUser);

    String text = "<p>Вы успешно зарегестрировались на сайте Zoo, для подтверждения регистрации пройдите по ссылке:</p>" +
                  "<br> <a href=\"http://localhost/confirm/" +newUser.getConfirmCode()+ "\">Подтвердить</a>";

    MimeMessage message = javaMailSender.createMimeMessage();
    message.setContent(text, "text/html");
    MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
    messageHelper.setTo(newUser.getEmail());
    messageHelper.setSubject("Подтверждение регистрации");
    messageHelper.setText(text, true);

    javaMailSender.send(message);

    return newUser.getEmail();
  }

  @Override
  public boolean confirm(String confirmString) {
    Optional <User> userOptional
            = usersRepository.findByConfirmCode(confirmString);
    if (userOptional.isPresent()) {
      User user = userOptional.get();

      user.setConfirmCode(null);
      user.setState(State.CONFIRMED);
      usersRepository.save(user);

      return true;
    }
    return false;
  }

  @SneakyThrows
  @Override
  public String passwordRecovery(PasswordRecoveryForm form) {
    Optional<User> userCheckEmail = usersRepository.findByEmail(form.getEmail());
    if (!userCheckEmail.isPresent()) {
      return "bad_email";
    }
      String passwordRecoveryCode = UUID.randomUUID().toString().replace("-","");


      User user = userCheckEmail.get();
      user.setPasswordRecoveryCode(passwordRecoveryCode);
      usersRepository.save(user);

      String text = "<p>Ваш логин на сайте Zoo - '" + user.getLogin() + "'.<br> Для восстановления пароля пройдите по ссылке:</p>" +
              " <a href=\"http://localhost/password_confirm/" +user.getPasswordRecoveryCode()+ "\">Изменить пароль</a>";

      MimeMessage message = javaMailSender.createMimeMessage();
      message.setContent(text, "text/html");
      MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
      messageHelper.setTo(user.getEmail());
      messageHelper.setSubject("Восстановление пароля");
      messageHelper.setText(text, true);

      javaMailSender.send(message);

      return user.getEmail();
  }

  @Override
  public boolean confirmPasswordRecovery(String passwordRecoveryCode) {
    Optional <User> userOptional
            = usersRepository.findByPasswordRecoveryCode(passwordRecoveryCode);
    return userOptional.isPresent();
  }

  @Override
  public String changePassword(PasswordForm form, String passwordRecoveryCode) {
    Optional <User> userOptional
            = usersRepository.findByPasswordRecoveryCode(passwordRecoveryCode);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      String hashPassword = encoder.encode(form.getPassword());
      user.setPasswordRecoveryCode(null);
      user.setHashPassword(hashPassword);
      usersRepository.save(user);

      return user.getLogin();
    } else return "error";
  }


}

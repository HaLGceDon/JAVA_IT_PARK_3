package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.forms.RegistrationForm;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;

import java.time.LocalDateTime;

@Service
public class RegistrationServiceImpl implements RegistrationService <RegistrationForm> {

  @Autowired
  private UsersRepository usersRepository;

  private PasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public Long registration(RegistrationForm form) {
    String hashPassword = encoder.encode(form.getPassword());
    LocalDateTime registrationTime = LocalDateTime.now();

    User newUser = User.builder()
        .name(form.getName())
        .email(form.getEmail())
            .login(form.getLogin())
        .surname(form.getSurname())
            .age(form.getAge())
        .hashPassword(hashPassword)
        .registrationTime(registrationTime)
        .build();

    usersRepository.save(newUser);
    return newUser.getId();
  }
}

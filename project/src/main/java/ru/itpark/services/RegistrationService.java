package ru.itpark.services;


import lombok.SneakyThrows;
import ru.itpark.forms.RegistrationForm;

public interface RegistrationService {

    String registration(RegistrationForm form);

    boolean confirm(String confirmString);

    @SneakyThrows
    String passwordRecovery(RegistrationForm form);

    boolean confirmPasswordRecovery(String passwordRecoveryCode);


    String changePassword(RegistrationForm form, String passwordRecoveryCode);
}
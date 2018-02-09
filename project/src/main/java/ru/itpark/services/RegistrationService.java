package ru.itpark.services;


import ru.itpark.forms.PasswordForm;
import ru.itpark.forms.PasswordRecoveryForm;
import ru.itpark.forms.RegistrationForm;

public interface RegistrationService {

    String registration(RegistrationForm form);

    boolean confirm(String confirmString);

    String passwordRecovery (PasswordRecoveryForm form);

    boolean confirmPasswordRecovery(String passwordRecoveryCode);

    String changePassword(PasswordForm form, String passwordRecoveryCode);
}
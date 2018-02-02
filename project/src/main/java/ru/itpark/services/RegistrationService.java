package ru.itpark.services;


import ru.itpark.forms.RegistrationForm;

public interface RegistrationService {

    String registration(RegistrationForm form);

    boolean confirm(String confirmString);
}
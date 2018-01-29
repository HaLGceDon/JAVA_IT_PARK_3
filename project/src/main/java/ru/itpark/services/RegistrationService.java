package ru.itpark.services;


public interface RegistrationService <T> {

  String registration(T form);

    boolean confirm(String confirmString);
}
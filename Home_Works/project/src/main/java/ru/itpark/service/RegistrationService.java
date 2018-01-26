package ru.itpark.service;


public interface RegistrationService <T> {

  Long registration(T form);
}
package ru.itpark.services;


import org.springframework.security.core.Authentication;
import ru.itpark.models.user.User;

public interface AuthenticationService {
  User getUserByAuthentication(Authentication authentication);
}
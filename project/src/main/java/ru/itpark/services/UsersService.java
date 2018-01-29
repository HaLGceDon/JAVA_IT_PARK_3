package ru.itpark.services;

import ru.itpark.models.User;

import java.util.List;

public interface UsersService {
  List<User> getUsers(String orderBy);
    User getUser(Long userId);
}
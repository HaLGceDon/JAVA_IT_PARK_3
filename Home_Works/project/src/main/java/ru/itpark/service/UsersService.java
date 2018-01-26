package ru.itpark.service;

import ru.itpark.models.User;

import java.util.List;

public interface UsersService {
  List<User> getUsers(String orderBy);
}
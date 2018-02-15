package ru.itpark.services;

import ru.itpark.forms.NamesForm;
import ru.itpark.models.user.User;

import java.util.List;

public interface UsersService {
  List<User> getUsers(String orderBy);
    User getUser(Long userId);

    void update(Long userId, NamesForm form);

  boolean deleteUser(String login);
}
package ru.itpark.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/users")
    public String getUsers(@ModelAttribute("model")ModelMap model) {
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
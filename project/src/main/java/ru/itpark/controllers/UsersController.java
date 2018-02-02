package ru.itpark.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;
import ru.itpark.services.AuthenticationService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/users")
    public String getUsers(@ModelAttribute("model")ModelMap model) {
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/profile")
    public String getProfilePage(
            @ModelAttribute("model") ModelMap model,
            Authentication authentication) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        return "profile";
    }
}
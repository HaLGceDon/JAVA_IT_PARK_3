package ru.itpark.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.NamesForm;
import ru.itpark.models.User.User;
import ru.itpark.repositories.UsersRepository;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.TicketsService;
import ru.itpark.services.UsersService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private UsersService usersService;


    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/users")
    public String getUsers(@ModelAttribute("model")ModelMap model) {
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/profile")
    public String getProfilePage(@ModelAttribute("model") ModelMap model,
                                 Authentication authentication) {


        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        model.addAttribute("select", "profile");
        return "profile";
    }

    @GetMapping("/profile_info_edit")
    public String getUserPage(@ModelAttribute("model") ModelMap model,
                              Authentication authentication) {

        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        model.addAttribute("select", "profile");
        return "profile_info_edit";
    }

    @PostMapping("/profile_info_edit")
    public String updateUser(NamesForm form,
                             Authentication authentication,
                             @ModelAttribute("model") ModelMap model) {
        usersService.update(authenticationService.getUserByAuthentication(authentication).getId(), form);
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        model.addAttribute("select", "profile");
        return "profile";
    }

}
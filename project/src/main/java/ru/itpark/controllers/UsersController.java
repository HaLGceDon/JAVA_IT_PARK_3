package ru.itpark.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.NamesForm;
import ru.itpark.forms.RegistrationForm;
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
        User user = authenticationService.getUserByAuthentication(authentication);
        if (form.getAge() < 1 || form.getAge() > 120) {
            form.setAge(usersService.getUser(user.getId()).getAge());
        }
        if (form.getName().length() < 3) {
            form.setName(usersService.getUser(user.getId()).getName());
        }
        if (form.getSurname().length() < 3) {
            form.setSurname(usersService.getUser(user.getId()).getSurname());
        }
        usersService.update(authenticationService.getUserByAuthentication(authentication).getId(), form);
        model.addAttribute("user", user);
        model.addAttribute("select", "profile");
        return "profile";
    }

    @PostMapping("/delete_user")
    public String deleteUser(@ModelAttribute("model") ModelMap model,
                             @ModelAttribute RegistrationForm form) {

        boolean result = usersService.deleteUser(form.getLogin());
        model.addAttribute("result", result);
        return "users_delete_success";
    }

}
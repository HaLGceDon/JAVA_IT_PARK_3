package ru.itpark.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itpark.models.user.User;
import ru.itpark.services.AuthenticationService;

@Controller
public class Index {

    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping ("/")
    public String getIndex(@ModelAttribute("model") ModelMap model,
                           Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        return "index";
    }



}

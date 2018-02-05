package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.RegistrationForm;
import ru.itpark.models.User.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.RegistrationService;
import ru.itpark.services.RegistrationServiceImpl;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@Controller
public class RegistrationController {

  @Autowired
  private RegistrationService service;

  @Autowired
  private AuthenticationService authenticationService;


  @PostMapping("/registration")
  public String registrationUser(@ModelAttribute RegistrationForm form,
                                 @ModelAttribute("model") ModelMap model,
                                 Authentication authentication) {

    String email = service.registration(form);

    if (email.equals("bad_login")) {
      model.addAttribute("errorLogin", true);
      model.addAttribute("errorEmail", false);
      if (authentication != null) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
      }
      model.addAttribute("select", "registration");
      return "registration_error";
    }
    if (email.equals("bad_email")) {
      model.addAttribute("errorEmail", true);
      model.addAttribute("errorLogin", false);
      if (authentication != null) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
      }
      model.addAttribute("select", "registration");
      return "registration_error";
    }

    model.addAttribute("email", email);
    return "success_page";
  }


  @GetMapping("/registration")
  public String getRegistrationPage(@ModelAttribute("model") ModelMap model,
                                    Authentication authentication) {
    if (authentication != null) {
      User user = authenticationService.getUserByAuthentication(authentication);
      model.addAttribute("user", user);
    }
    model.addAttribute("select", "registration");

    return "registration";
  }


  @GetMapping("/confirm/{confirm-string}")
  public String getConfirmPage(
          @ModelAttribute("model") ModelMap model,
          @PathVariable("confirm-string") String confirmString) {
    boolean result = service.confirm(confirmString);
    model.addAttribute("result", result);
    return "confirm_result_page";
  }


  @GetMapping("/login")
  public String login(
          @ModelAttribute("model") ModelMap model,
          @RequestParam(value = "error", required = false) Boolean error) {
    model.addAttribute("select", "login");
    if (error != null) {
      model.addAttribute("error", true);
    } else {
      model.addAttribute("error", false);
    }
    return "login";
  }
}
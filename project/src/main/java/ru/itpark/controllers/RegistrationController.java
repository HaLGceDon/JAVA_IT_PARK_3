package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.forms.PasswordForm;
import ru.itpark.forms.PasswordRecoveryForm;
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

  private User userPassRecovery;


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
      return "registration";
    }
    if (email.equals("bad_email")) {
      model.addAttribute("errorEmail", true);
      model.addAttribute("errorLogin", false);
      if (authentication != null) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
      }
      model.addAttribute("select", "registration");
      return "registration";
    }

    model.addAttribute("email", email);
    return "success_page";
  }


  @GetMapping("/registration")
  public String getRegistrationPage(@ModelAttribute("model") ModelMap model,
                                    Authentication authentication) {
    model.addAttribute("errorLogin", false);
    model.addAttribute("errorEmail", false);
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

  @GetMapping("/password_recovery")
  public String getPasswordRecovery( @ModelAttribute("model") ModelMap model) {
    model.addAttribute("select", "login");
    model.addAttribute("error", false);
    return "password_recovery";
  }

  @PostMapping("/password_recovery")
  public String passwordRecovery (@ModelAttribute("model") ModelMap model,
                                  @ModelAttribute PasswordRecoveryForm form) {

    model.addAttribute("select", "login");
    String email = service.passwordRecovery(form);
    if (email.equals("bad_email")) {
      model.addAttribute("error", true);
      return "password_recovery";
    }
    model.addAttribute("email", email);
    return "password_success_recovery";

  }

  @GetMapping("/password_confirm/{confirm-string}")
  public String getConfirmPasswordRecovery(
          @ModelAttribute("model") ModelMap model,
          @PathVariable("confirm-string") String confirmString) {
    model.addAttribute("select", "login");
    boolean result = service.confirmPasswordRecovery(confirmString);
    model.addAttribute("result", result);
    if (result) {

      userPassRecovery = User.builder().passwordRecoveryCode(confirmString).build();
    }
    return "/password_recovery_confirm";
  }

  @GetMapping("/password_change")
  public String getPasswordChange(@ModelAttribute("model") ModelMap model) {
    model.addAttribute("select", "login");
    return "password_change";
  }

  @PostMapping("/password_change")
  public String changePassword (@ModelAttribute("model") ModelMap model,
                                @ModelAttribute PasswordForm form) {

    model.addAttribute("select", "login");
    String login = service.changePassword(form, userPassRecovery.getPasswordRecoveryCode());
    model.addAttribute("login", login);
    return "success_password_change";

  }


}
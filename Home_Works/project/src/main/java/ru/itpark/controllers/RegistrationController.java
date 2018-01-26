package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.RegistrationForm;
import ru.itpark.service.RegistrationServiceImpl;

@Controller
public class RegistrationController {

  @Autowired
  private RegistrationServiceImpl service;

  @PostMapping("/registration")
  public String registrationUser(@ModelAttribute RegistrationForm form,
                                 @ModelAttribute("model") ModelMap model) {
    Long newUserId = service.registration(form);
    model.addAttribute("id", newUserId);
    return "success";
  }

  @GetMapping("/registration")
  public String getRegistrationPage() {
    return "registration_page";
  }
}
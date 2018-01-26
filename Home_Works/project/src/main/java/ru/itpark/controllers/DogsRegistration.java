package ru.itpark.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.DogsForm;
import ru.itpark.service.DogsRegistrationImpl;

@Controller
public class DogsRegistration {


    @Autowired
    private DogsRegistrationImpl dogsRegistration;

    @PostMapping(value = "/dogsRegistration")
    public String dogsRegistration (@ModelAttribute DogsForm form,
                                    @ModelAttribute("model") ModelMap model) {
        Long newDogId = dogsRegistration.registration(form);
        model.addAttribute("id", newDogId);
        return "success_dogs_registration";
    }

    @GetMapping(value = "/dogsRegistration")
    public String getDogRegistrationPage () {
        return "dogsRegistration";
    }
}

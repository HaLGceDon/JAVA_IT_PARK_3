package ru.itpark.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.DogsForm;
import ru.itpark.models.Dog;
import ru.itpark.repositories.DogsRepository;
import ru.itpark.service.DogsRegistrationImpl;

import java.util.List;

@Controller
public class DogsController {

    @Autowired
    private DogsRepository dogsRepository;


    @GetMapping(value = "/dogs")
    public String getDogs (@ModelAttribute("model") ModelMap modelMap) {
        List<Dog> dogs = dogsRepository.findAll();
        modelMap.addAttribute("dogs", dogs);
        return "dogs";
    }




}

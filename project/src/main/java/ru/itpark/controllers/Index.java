package ru.itpark.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping ("/")
    public String getIndex() {
        return "index";
    }


    @GetMapping ("/contact")
    public String getContact() {
        return "contact";
    }

    @GetMapping ("/events")
    public String getEvents() {
        return "events";
    }

    @GetMapping ("/gallery")
    public String getGallery() { return "gallery";
    }

    @GetMapping ("/zoo")
    public String getZoo() {
        return "zoo";
    }

    @GetMapping("1")
    public String test() { return "1";
    }



}

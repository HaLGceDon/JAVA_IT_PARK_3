package ru.itpark.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping ("/")
    public String index() {
        return "index";
    }

    @GetMapping ("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping ("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping ("/events")
    public String events() {
        return "events";
    }

    @GetMapping ("/gallery")
    public String gallery() { return "gallery";
    }

    @GetMapping ("/info")
    public String info() {
        return "info";
    }

    @GetMapping ("/live")
    public String live() {
        return "live";
    }

    @GetMapping ("/tickets")
    public String tickets() {
        return "tickets";
    }

    @GetMapping ("/zoo")
    public String zoo() {
        return "zoo";
    }

    @GetMapping("1")
    public String test() { return "1";
    }

}

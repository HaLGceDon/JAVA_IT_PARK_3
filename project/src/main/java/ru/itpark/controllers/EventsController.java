package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.EventsForm;
import ru.itpark.models.event.Event;
import ru.itpark.models.user.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.EventsService;

import java.util.List;

@Controller
public class EventsController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EventsService eventsService;

    @GetMapping("/events")
    public String getEvents(@ModelAttribute("model") ModelMap model,
                            Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        List<Event> events = eventsService.getEvents();
        model.addAttribute("events", events);
        model.addAttribute("select", "events");
        return "eventsPages/events";
    }

    @PostMapping("/new_event")
    public String newEvent(@ModelAttribute("model") ModelMap model,
                           Authentication authentication,
                           EventsForm eventsForm) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);

        model.addAttribute("select", "events");
        String newEventName = eventsService.newEvent(eventsForm);
        model.addAttribute("newEventName", newEventName);
        }
        List<Event> events = eventsService.getEvents();
        model.addAttribute("events", events);
        return "eventsPages/events";
    }

    @PostMapping("/delete_event")
    public String deleteEvent(@ModelAttribute("model") ModelMap model,
                              Authentication authentication,
                              EventsForm eventDeleteForm) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }

        model.addAttribute("select", "events");
        String deleteEvent = eventsService.deleteEvent(eventDeleteForm.getId());
        model.addAttribute("deleteEvent", deleteEvent);
        List<Event> events = eventsService.getEvents();
        model.addAttribute("events", events);
        return "eventsPages/events";
    }

}

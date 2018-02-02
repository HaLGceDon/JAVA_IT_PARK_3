package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.BuyForm;
import ru.itpark.forms.PayForm;
import ru.itpark.services.TicketsService;

@Controller
public class TicketsController {

    @Autowired
    private TicketsService service;

    @GetMapping ("/tickets")
    public String getTickets() {
        return "tickets";
    }

    @GetMapping("/buy_tickets")
    public String getBuyTickets () {
       return "buy_tickets";
    }

    @PostMapping("/buy_tickets")
    public String buyTickets (@ModelAttribute BuyForm form,
                              @ModelAttribute("model") ModelMap model){

        if (form.getQuantityAdult() > 0) {
            model.addAttribute("quantityAdult", form.getQuantityAdult());
        } else model.addAttribute("quantityAdult", 0);

        if (form.getQuantityKids() > 0) {
            model.addAttribute("quantityKids", form.getQuantityKids());
        } else  model.addAttribute("quantityKids", 0);


        if (form.getQuantityAdult() == 0 & form.getQuantityKids() == 0) {
            model.addAttribute("quantity", 0);
        } else model.addAttribute("quantity", 1);
        return  "buy_tickets_confirm";
    }

    @PostMapping ("/buy_tickets_confirm")
    public String buyTicketsConfirm (@ModelAttribute BuyForm form,
                                     @ModelAttribute("model") ModelMap model) {
        int price = service.buyTickets(form);
        model.addAttribute("price", price);
        return "buy_tickets_pay";
    }


    @GetMapping ("/buy_tickets_pay")
    public String getBuyTicketsPay (@ModelAttribute BuyForm form,
                                 @ModelAttribute("model") ModelMap model) {

        return "buy_tickets_pay";
    }

    @PostMapping("/buy_tickets_pay")
    public String payTickets (@ModelAttribute PayForm form,
                              @ModelAttribute("model") ModelMap model){

        boolean result = service.payTickets(form);
        model.addAttribute("result", result);
        return "buy_tickets_confirm_and";
    }
}


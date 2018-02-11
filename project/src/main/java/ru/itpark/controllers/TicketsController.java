package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.PayForm;
import ru.itpark.models.ticket.BuyTicket;
import ru.itpark.models.user.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.TicketsService;

import java.util.List;

@Controller
public class TicketsController {

    @Autowired
    private TicketsService service;

    @Autowired
    private AuthenticationService authenticationService;

    private BuyTicket buyTicket;

    @GetMapping ("/tickets")
    public String getTickets(@ModelAttribute("model") ModelMap model,
                             Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "tickets");
        model.addAttribute("adultPrice", service.getAdultBuyPrice());
        model.addAttribute("kidsPrice", service.getKidsBuyPrice());
        return "tickets";
    }

    @GetMapping("/buy_tickets")
    public String getBuyTickets ( @ModelAttribute("model") ModelMap model) {
        model.addAttribute("select", "tickets");
        model.addAttribute("adultPrice", service.getAdultBuyPrice());
        model.addAttribute("kidsPrice", service.getKidsBuyPrice());
       return "buy_tickets";
    }

    @PostMapping("/buy_tickets")
    public String buyTickets (@ModelAttribute PayForm form,
                              @ModelAttribute("model") ModelMap model){

        if (form.getQuantityAdult() > 0) {
            model.addAttribute("quantityAdult", form.getQuantityAdult());
        } else {
            model.addAttribute("quantityAdult", 0);
        }

        if (form.getQuantityKids() > 0) {
            model.addAttribute("quantityKids", form.getQuantityKids());
        } else  {
            model.addAttribute("quantityKids", 0);
        }


        if (form.getQuantityAdult() == 0 & form.getQuantityKids() == 0) {
            model.addAttribute("quantity", 0);
        } else model.addAttribute("quantity", 1);

        model.addAttribute("buySum", service.getBuyTickets(form).getPrice());
        model.addAttribute("adultBuySum", service.buyAdultTicketsSum(form));
        model.addAttribute("kidsBuySum", service.buyKidsTicketsSum(form));
        buyTicket = service.getBuyTickets(form);
        return  "buy_tickets_confirm";
    }

    @GetMapping ("/buy_tickets_pay")
    public String buyTicketsConfirm (@ModelAttribute("model") ModelMap model) {
        model.addAttribute("error", false);
        model.addAttribute("price",buyTicket.getPrice());
        model.addAttribute("quantityAdult", buyTicket.getQuantityAdult());
        model.addAttribute("quantityKids", buyTicket.getQuantityKids());
        return "buy_tickets_pay";
    }



    @PostMapping("/buy_tickets_pay")
    public String payTickets (@ModelAttribute PayForm payForm,
                              @ModelAttribute("model") ModelMap model,
                              Authentication authentication){

        payForm.setQuantityKids(buyTicket.getQuantityKids());
        payForm.setQuantityAdult(buyTicket.getQuantityAdult());
        payForm.setPrice(buyTicket.getPrice());
        User user = service.payTickets(payForm, authentication).getUser();
        if (user != null) {
            String email = user.getEmail();
            model.addAttribute("email", email);
            return "buy_tickets_pay_confirm";
        }else {
            model.addAttribute("error", true);
            model.addAttribute("price",buyTicket.getPrice());
            model.addAttribute("quantityAdult", buyTicket.getQuantityAdult());
            model.addAttribute("quantityKids", buyTicket.getQuantityKids());
            return "buy_tickets_pay";
        }
    }

    @GetMapping("/profile_buy_list")
    public String getBuyList(@ModelAttribute("model") ModelMap model,
                             Authentication authentication) {

        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        model.addAttribute("select", "profile");
        List<BuyTicket> tickets = service.getBuyTicketsByUser(authentication);
        model.addAttribute("tickets", tickets);
        if (tickets.size() > 0) {
            model.addAttribute("noTickets", false);
        } else  model.addAttribute("noTickets", true);
        return "profile_buy_list";
    }



}


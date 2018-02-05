package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.BuyForm;
import ru.itpark.forms.PayForm;
import ru.itpark.models.Ticket.BuyTicket;
import ru.itpark.models.User.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.TicketsService;

import java.util.List;

@Controller
public class TicketsController {

    @Autowired
    private TicketsService service;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping ("/tickets")
    public String getTickets(@ModelAttribute("model") ModelMap model,
                             Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "tickets");
        model.addAttribute("adultPrice", service.getAdultBuyPriceZooMain());
        model.addAttribute("kidsPrice", service.getKidsBuyPriceZooMain());
        return "tickets";
    }

    @GetMapping("/buy_tickets")
    public String getBuyTickets ( @ModelAttribute("model") ModelMap model) {
        model.addAttribute("select", "tickets");
        model.addAttribute("adultPrice", service.getAdultBuyPriceZooMain());
        model.addAttribute("kidsPrice", service.getKidsBuyPriceZooMain());
       return "buy_tickets";
    }

    @PostMapping("/buy_tickets")
    public String buyTickets (@ModelAttribute BuyForm buyForm,
                              @ModelAttribute("model") ModelMap model){

        if (buyForm.getQuantityAdult() > 0) {
            model.addAttribute("quantityAdult", buyForm.getQuantityAdult());
        } else model.addAttribute("quantityAdult", 0);

        if (buyForm.getQuantityKids() > 0) {
            model.addAttribute("quantityKids", buyForm.getQuantityKids());
        } else  model.addAttribute("quantityKids", 0);


        if (buyForm.getQuantityAdult() == 0 & buyForm.getQuantityKids() == 0) {
            model.addAttribute("quantity", 0);
        } else model.addAttribute("quantity", 1);

        model.addAttribute("buySum", service.getBuyTicketsZooMain(buyForm).getPrice());
        model.addAttribute("adultBuySum", service.buyAdultTicketsSumZooMain(buyForm));
        model.addAttribute("kidsBuySum", service.buyKidsTicketsSumZooMain(buyForm));
        return  "buy_tickets_confirm";
    }

    @PostMapping ("/buy_tickets_confirm")
    public String buyTicketsConfirm (@ModelAttribute BuyForm form,
                                     @ModelAttribute("model") ModelMap model) {
        model.addAttribute("price",service.getBuyTicketsZooMain(form).getPrice());
        model.addAttribute("quantityAdult", service.getBuyTicketsZooMain(form).getQuantityAdult());
        model.addAttribute("quantityKids", service.getBuyTicketsZooMain(form).getQuantityKids());
        return "buy_tickets_pay";
    }



    @PostMapping("/buy_tickets_pay")
    public String payTickets (@ModelAttribute PayForm payForm,
                              @ModelAttribute("model") ModelMap model,
                              Authentication authentication){

        User user = service.payTickets(payForm, authentication).getUser();

        if (user != null) {
            String email = user.getEmail();
            model.addAttribute("email", email);
            return "buy_tickets_pay_confirm";
        }else {
            model.addAttribute("price",service.payTickets(payForm, authentication).getPrice());
            model.addAttribute("quantityAdult", service.payTickets(payForm, authentication).getQuantityAdult());
            model.addAttribute("quantityKids", service.payTickets(payForm, authentication).getQuantityKids());
            return "buy_tickets_pay_error";
        }
    }

    @GetMapping("/profile_buy_list")
    public String getBuyList(@ModelAttribute("model") ModelMap model,
                             Authentication authentication) {

        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        model.addAttribute("select", "profile");

        List<BuyTicket> tickets = service.getBuyTicketByUser(authentication);
        model.addAttribute("tickets", tickets);
        return "profile_buy_list";
    }



}


package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.forms.GalleryForm;
import ru.itpark.forms.PayForm;
import ru.itpark.forms.TicketForm;
import ru.itpark.models.ticket.BuyTicket;
import ru.itpark.models.ticket.Tickets;
import ru.itpark.models.user.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.FilesService;
import ru.itpark.services.TicketsService;

import java.util.List;

@Controller
public class TicketsController {

    @Autowired
    private TicketsService service;

    @Autowired
    private AuthenticationService authenticationService;

    private BuyTicket buyTicket;

    @Autowired
    private FilesService filesService;

    @GetMapping ("/tickets")
    public String getTickets(@ModelAttribute("model") ModelMap model,
                             Authentication authentication) {

        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "ticket");
        List<Tickets> tickets = service.getTickets();
        model.addAttribute("ticket", tickets);
        return "ticketsPages/ticket";
    }



    @GetMapping("/buy_tickets/{ticket_name}")
    public String getBuyTickets ( @ModelAttribute("model") ModelMap model,
                                  @PathVariable("ticket_name") String ticketName) {

        model.addAttribute("select", "ticket");
        Tickets ticket = service.getTicketByName(ticketName);
        buyTicket = BuyTicket.builder().name(ticketName).build();
        model.addAttribute("ticket", ticket);
       return "ticketsPages/buy_tickets";
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
        form.setName(buyTicket.getName());
        buyTicket = service.getBuyTickets(form);
        model.addAttribute("buySum", service.getBuyTickets(form).getPrice());
        model.addAttribute("adultBuySum", service.buyAdultTicketsSum(form));
        model.addAttribute("kidsBuySum", service.buyKidsTicketsSum(form));

        return  "ticketsPages/buy_tickets_confirm";
    }

    @GetMapping ("/buy_tickets_pay")
    public String buyTicketsConfirm (@ModelAttribute("model") ModelMap model) {
        model.addAttribute("error", false);
        model.addAttribute("price",buyTicket.getPrice());
        model.addAttribute("quantityAdult", buyTicket.getQuantityAdult());
        model.addAttribute("quantityKids", buyTicket.getQuantityKids());
        return "ticketsPages/buy_tickets_pay";
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
            return "ticketsPages/buy_tickets_pay";
        }
    }

    @GetMapping("/profile_buy_list")
    public String getBuyList(@ModelAttribute("model") ModelMap model,
                             Authentication authentication) {

        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        model.addAttribute("select", "profile");
        List<BuyTicket> tickets = service.getBuyTicketsByUser(authentication);
        model.addAttribute("buyTickets", tickets);
        return "ticketsPages/profile_buy_list";
    }

    @PostMapping("/add_ticket")
    public String newTicket(@ModelAttribute("model") ModelMap model,
                            TicketForm ticketForm,
                            Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        String newTicket = service.newTicket(ticketForm);
        model.addAttribute("newTicket", newTicket);
        model.addAttribute("select", "ticket");
        List<Tickets> tickets = service.getTickets();
        model.addAttribute("ticket", tickets);
        return "ticketsPages/tickets_new_ticket";
    }


    @GetMapping ("/tickets_redaction")
    public String getTicketsRedaction(@ModelAttribute("model") ModelMap model,
                                      Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "ticket");
        List<Tickets> tickets = service.getTickets();
        model.addAttribute("ticket", tickets);
        return "ticketsPages/tickets_redaction";
    }


    @GetMapping ("/tickets_new_ticket")
    public String getTicketsAdd(@ModelAttribute("model") ModelMap model,
                                      Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "ticket");
        return "ticketsPages/tickets_new_ticket";
    }

    @PostMapping("/delete_ticket")
    public String deleteTicket (@ModelAttribute("model") ModelMap model,
                                TicketForm ticketForm,
                                Authentication authentication) {

        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "ticket");
        String deleteTicked = service.deleteTicket(ticketForm.getName());
        model.addAttribute("deleteTicked", deleteTicked);
        List<Tickets> tickets = service.getTickets();
        model.addAttribute("ticket", tickets);
        return "ticketsPages/tickets_redaction";
    }

    @PostMapping("/update_ticket")
    public String updateTicket(@ModelAttribute("model") ModelMap model,
                               TicketForm ticketForm,
                               Authentication authentication) {

        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "ticket");
        service.updateTicket(ticketForm);
        List<Tickets> tickets = service.getTickets();
        model.addAttribute("ticket", tickets);
        return "ticketsPages/tickets_redaction";
    }


    @PostMapping("/delete_ticket_image")
    public String deleteTicketImage(@ModelAttribute("model") ModelMap model,
                                    GalleryForm galleryForm,
                                    Authentication authentication) {
        filesService.deleteImage(galleryForm);
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
        }
        model.addAttribute("select", "ticket");
        List<Tickets> tickets = service.getTickets();
        model.addAttribute("ticket", tickets);
        return "ticketsPages/tickets_redaction";
    }




}


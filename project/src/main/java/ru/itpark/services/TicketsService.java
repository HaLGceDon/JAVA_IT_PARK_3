package ru.itpark.services;

import org.springframework.security.core.Authentication;
import ru.itpark.forms.PayForm;
import ru.itpark.forms.TicketForm;
import ru.itpark.models.tickets.BuyTicket;
import ru.itpark.models.tickets.Tickets;

import java.util.List;

public interface TicketsService {

    BuyTicket getBuyTickets(PayForm form);

    List<BuyTicket> getBuyTicketsByUser(Authentication authentication);

    int buyAdultTicketsSum(PayForm buyForm);

    int buyKidsTicketsSum(PayForm buyForm);


    BuyTicket payTickets(PayForm payForm,
                         Authentication authentication);

    List<Tickets> getTickets();

    Tickets getTicketByName(String name);

    String newTicket(TicketForm ticketForm);

    String deleteTicket(String name);

    void updateTicket(TicketForm ticketForm);
}

package ru.itpark.services;

import org.springframework.security.core.Authentication;
import ru.itpark.forms.PayForm;
import ru.itpark.models.ticket.BuyTicket;

import java.util.List;

public interface TicketsService {

    BuyTicket getBuyTickets(PayForm form);

    List<BuyTicket> getBuyTicketsByUser(Authentication authentication);

    int buyAdultTicketsSum(PayForm buyForm);

    int buyKidsTicketsSum(PayForm buyForm);

    int getAdultBuyPrice();

    int getKidsBuyPrice();


    BuyTicket payTickets(PayForm payForm,
                         Authentication authentication);
}

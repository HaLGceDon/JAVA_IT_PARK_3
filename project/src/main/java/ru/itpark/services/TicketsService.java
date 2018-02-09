package ru.itpark.services;

import org.springframework.security.core.Authentication;
import ru.itpark.forms.BuyForm;
import ru.itpark.forms.PayForm;
import ru.itpark.models.Ticket.BuyTicket;

import java.util.List;

public interface TicketsService {
    BuyTicket getBuyTickets(BuyForm form);

    List<BuyTicket> getBuyTicketsByUser(Authentication authentication);

    int buyAdultTicketsSum(BuyForm buyForm);

    int buyKidsTicketsSum(BuyForm buyForm);

    int getAdultBuyPrice();

    int getKidsBuyPrice();


    BuyTicket payTickets(PayForm payForm,
                         Authentication authentication);
}

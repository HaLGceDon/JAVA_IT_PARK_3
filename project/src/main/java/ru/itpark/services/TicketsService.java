package ru.itpark.services;

import org.springframework.security.core.Authentication;
import ru.itpark.forms.BuyForm;
import ru.itpark.forms.PayForm;
import ru.itpark.models.Ticket.BuyTicket;

import java.util.List;

public interface TicketsService {
    BuyTicket getBuyTicketsZooMain(BuyForm form);

    List<BuyTicket> getBuyTicketByUser(Authentication authentication);

    int buyAdultTicketsSumZooMain(BuyForm buyForm);

    int buyKidsTicketsSumZooMain(BuyForm buyForm);

    int getAdultBuyPriceZooMain();

    int getKidsBuyPriceZooMain();


    BuyTicket payTickets(PayForm payForm,
                         Authentication authentication);
}

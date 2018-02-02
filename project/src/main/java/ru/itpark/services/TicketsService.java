package ru.itpark.services;

import org.springframework.security.core.Authentication;
import ru.itpark.forms.BuyForm;
import ru.itpark.forms.PayForm;

public interface TicketsService {
    int buyTickets(BuyForm form);

    boolean payTickets(PayForm form);
}

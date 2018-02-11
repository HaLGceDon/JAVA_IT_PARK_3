package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.ticket.BuyTicket;
import ru.itpark.models.user.User;

import java.util.List;

public interface BuyTicketRepository extends JpaRepository<BuyTicket, Long> {

    List<BuyTicket> findBuyTicketByUser(User user);
}

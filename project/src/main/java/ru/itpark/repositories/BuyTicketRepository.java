package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.tickets.BuyTicket;
import ru.itpark.models.users.User;

import java.util.List;

public interface BuyTicketRepository extends JpaRepository<BuyTicket, Long> {

    List<BuyTicket> findBuyTicketByUser(User user);
}

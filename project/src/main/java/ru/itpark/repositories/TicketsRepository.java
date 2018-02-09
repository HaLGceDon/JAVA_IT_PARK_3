package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Ticket.Tickets;


public interface TicketsRepository extends JpaRepository <Tickets, Long> {

   Tickets findTicketsByName(String name);
}
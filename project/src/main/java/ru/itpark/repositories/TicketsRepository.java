package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.file.FileInfo;
import ru.itpark.models.tickets.Tickets;


public interface TicketsRepository extends JpaRepository <Tickets, Long> {

   Tickets findTicketsByName(String name);
   Tickets findTicketsByImage(FileInfo image);
}

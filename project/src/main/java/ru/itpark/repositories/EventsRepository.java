package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.event.Event;
import ru.itpark.models.event.EventState;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByEventState(EventState eventState);
}

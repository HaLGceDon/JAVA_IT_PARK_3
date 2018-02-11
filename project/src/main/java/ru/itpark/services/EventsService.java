package ru.itpark.services;

import ru.itpark.forms.EventsForm;
import ru.itpark.models.event.Event;

import java.util.List;

public interface EventsService {
    List<Event> getEvents();

    String deleteEvent(Long id);

    String newEvent(EventsForm eventsForm);
}

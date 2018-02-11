package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.forms.EventsForm;
import ru.itpark.models.event.Event;
import ru.itpark.models.event.EventState;
import ru.itpark.repositories.EventsRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<Event> getEvents() {
       List<Event> events = eventsRepository.findAllByEventState(EventState.PUBLISHED);
       events.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        return  events;
    }


    @Override
    public String deleteEvent(Long id) {
        Event newEvent = eventsRepository.findOne(id);
        if (!newEvent.getEventState().equals(EventState.DELETED)){
            newEvent.setEventState(EventState.DELETED);
            eventsRepository.save(newEvent);
        }
        return newEvent.getName();

    }

    @Override
    public String newEvent(EventsForm eventsForm) {
        Event newEvent = Event.builder()
                .date(LocalDate.parse(eventsForm.getDate()))
                .name(eventsForm.getName())
                .text(eventsForm.getText())
                .eventState(EventState.PUBLISHED)
                .build();
        eventsRepository.save(newEvent);
       return newEvent.getName();
    }

}

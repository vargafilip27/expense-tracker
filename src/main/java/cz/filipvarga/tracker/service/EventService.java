package cz.filipvarga.tracker.service;

import cz.filipvarga.tracker.domain.Event;
import cz.filipvarga.tracker.persistent.JPAEventRepository;
import cz.filipvarga.tracker.persistent.JPAPersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements EventServiceInterface{

    private final JPAEventRepository eventRepository;

    public EventService(JPAEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // CREATE
    @Override
    public Event createEvent(Event event) throws IllegalArgumentException {
        if (eventRepository.existsById(event.getId())) {
            throw new IllegalArgumentException("Event with id " + event.getId() + " already exists");
        }
        else return eventRepository.save(event);
    }

    //READ
    @Override
    public Event getEventById(Long id) throws EntityNotFoundException {
        if (eventRepository.existsById(id)) {
            return eventRepository.findById(id).get();
        }
        else throw new EntityNotFoundException("Event with id " + id + " not found");
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // UPDATE
    @Override
    public Event updateEvent(Event event) throws IllegalArgumentException {
        if (eventRepository.existsById(event.getId())) {
            return eventRepository.save(event);
        }
        else throw new IllegalArgumentException("Event with id " + event.getId() + " does not exist");
    }

    // DELETE
    @Override
    public void deleteEvent(Long id) throws EntityNotFoundException {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        }
        else throw new EntityNotFoundException("Event with id " + id + " not found");
    }


    @Override
    public void addPersonToEvent(Long eventId, Long personId) throws EntityNotFoundException {
        if (!eventRepository.existsById(eventId)) {
            throw new EntityNotFoundException("Event with id " + eventId + " does not exist");
        }

        if (!eventRepository.existsById(personId)) {
            throw new EntityNotFoundException("Person with id " + personId + " does not exist");
        }

        Event event = getEventById(eventId);
        event.
    }
}

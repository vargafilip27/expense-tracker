package cz.filipvarga.tracker.service;

import cz.filipvarga.tracker.domain.Event;
import cz.filipvarga.tracker.domain.Person;
import cz.filipvarga.tracker.persistent.JPAEventRepository;
import cz.filipvarga.tracker.persistent.JPAPersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements EventServiceInterface{

    private final JPAEventRepository eventRepository;
    private final JPAPersonRepository personRepository;

    public EventService(JPAEventRepository eventRepository, JPAPersonRepository personRepository) {
        this.eventRepository = eventRepository;
        this.personRepository = personRepository;
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


    @Transactional
    @Override
    public Event addPersonToEvent(Long eventId, Long personId) throws EntityNotFoundException {
        if (!eventRepository.existsById(eventId)) {
            throw new EntityNotFoundException("Event with id " + eventId + " does not exist");
        }

        if (!eventRepository.existsById(personId)) {
            throw new EntityNotFoundException("Person with id " + personId + " does not exist");
        }

        Event event = eventRepository.findById(eventId).get();
        Person person = personRepository.findById(personId).get();

        if (!event.getPersons().contains(person)) {
            event.getPersons().add(person);
            person.getEvents().add(event);
        }

        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEventsByPersonId(Long personId) throws EntityNotFoundException {
        if (personRepository.existsById(personId)) {
            return eventRepository.findAllByPersonId(personId);
        }
        else throw new EntityNotFoundException("Person with id " + personId + " does not exist");
    }
}

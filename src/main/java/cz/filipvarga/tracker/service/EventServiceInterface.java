package cz.filipvarga.tracker.service;

import cz.filipvarga.tracker.domain.Event;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface EventServiceInterface {

    Event createEvent(Event event) throws IllegalArgumentException; // CREATE
    Event getEventById(Long id) throws EntityNotFoundException;    // READ
    List<Event> getAllEvents();
    Event updateEvent(Event event); // UPDATE
    void deleteEvent(Long id) throws EntityNotFoundException;             // DELETE

    Event addPersonToEvent(Long eventId, Long personId);
    List<Event> getAllEventsByPersonId(Long personId);
}

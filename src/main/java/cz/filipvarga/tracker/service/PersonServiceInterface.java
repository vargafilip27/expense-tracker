package cz.filipvarga.tracker.service;

import cz.filipvarga.tracker.domain.Expense;
import cz.filipvarga.tracker.domain.Person;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface PersonServiceInterface {

    Person createPerson(Person person) throws IllegalArgumentException; // CREATE
    Person getPersonById(Long id) throws EntityNotFoundException;       // READ
    List<Person> getAllPersons();
    Person updatePerson(Person person) throws IllegalArgumentException; // UPDATE
    void deletePerson(Long id) throws EntityNotFoundException;          // DELETE
}

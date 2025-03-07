package cz.filipvarga.tracker.service;

import cz.filipvarga.tracker.domain.Person;
import cz.filipvarga.tracker.persistent.JPAPersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements PersonServiceInterface {

    private final JPAPersonRepository personRepository;

    public PersonService(JPAPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) throws IllegalArgumentException {
        if (personRepository.existsById(person.getId())) {
            throw new IllegalArgumentException("Person with id " + person.getId() + " already exists");
        }
        else return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) throws EntityNotFoundException {
        if (personRepository.existsById(id)) {
            return personRepository.findById(id).get();
        }
        else throw new EntityNotFoundException("Person with id " + id + " not found");
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePerson(Person person) throws IllegalArgumentException {
        if (personRepository.existsById(person.getId())) {
            return personRepository.save(person);
        }
        else throw new IllegalArgumentException("Person with id " + person.getId() + " not found");
    }

    @Override
    public void deletePerson(Long id) throws EntityNotFoundException {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        }
        else throw new EntityNotFoundException("Person with id " + id + " not found");
    }
}

package cz.filipvarga.tracker.controller.converter;

import cz.filipvarga.tracker.controller.dto.PersonDTO;
import cz.filipvarga.tracker.domain.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDTOConverter implements DTOConverter<PersonDTO, Person> {
}

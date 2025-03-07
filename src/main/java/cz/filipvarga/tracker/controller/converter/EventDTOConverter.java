package cz.filipvarga.tracker.controller.converter;

import cz.filipvarga.tracker.controller.dto.EventDTO;
import cz.filipvarga.tracker.domain.Event;
import org.springframework.stereotype.Component;

@Component
public class EventDTOConverter implements DTOConverter<EventDTO, Event>{
}

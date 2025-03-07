package cz.filipvarga.tracker.controller;

import cz.filipvarga.tracker.controller.converter.DTOConverter;
import cz.filipvarga.tracker.controller.dto.EventDTO;
import cz.filipvarga.tracker.domain.Event;
import cz.filipvarga.tracker.service.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/event")
public class EventController {

    private final EventService eventService;
    private final DTOConverter<EventDTO, Event> eventDTOConverter;

    public EventController(EventService eventService, DTOConverter<EventDTO, Event> eventDTOConverter) {
        this.eventService = eventService;
        this.eventDTOConverter = eventDTOConverter;
    }
}

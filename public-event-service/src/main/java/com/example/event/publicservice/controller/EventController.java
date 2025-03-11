package com.example.event.publicservice.controller;

import com.example.event.publicservice.dto.EventResponse;
import com.example.event.publicservice.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        List<EventResponse> responses = eventService.getAllEventResponses();
        return ResponseEntity.ok(responses);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        Optional<EventResponse> eventResponseOpt = eventService.getEventResponseById(id);
        return eventResponseOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

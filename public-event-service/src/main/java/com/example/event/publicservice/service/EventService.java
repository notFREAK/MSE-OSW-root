package com.example.event.publicservice.service;

import com.example.event.publicservice.client.ContentServiceClient;
import com.example.event.publicservice.dto.EventResponse;
import com.example.event.publicservice.model.Event;
import com.example.event.publicservice.repository.EventRepository;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ContentServiceClient contentServiceClient;

    public EventService(EventRepository eventRepository, ContentServiceClient contentServiceClient) {
        this.eventRepository = eventRepository;
        this.contentServiceClient = contentServiceClient;
    }

    public List<EventResponse> getAllEventResponses() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> {
            // Получаем контент из Content Service по идентификатору события
            Map<String, Object> contentMap = contentServiceClient.getSeatingPlanAndMultimedia(String.valueOf(event.getId()));
            // Собираем данные в DTO
            EventResponse response = new EventResponse();
            response.setId(event.getId());
            response.setTitle(event.getTitle());
            response.setDescription(event.getDescription());
            response.setEventDate(event.getEventDate());
            response.setLocation(event.getLocation());
            response.setStatus(event.getStatus());
            response.setCreatedAt(event.getCreatedAt());
            response.setUpdatedAt(event.getUpdatedAt());
            if (contentMap != null) {
                response.setSeatingPlan((Map<String, Object>) contentMap.get("seatingPlan"));
                response.setMultimedia((List<String>) contentMap.get("multimedia"));
            }
            return response;
        }).collect(Collectors.toList());
    }
    
    public Optional<EventResponse> getEventResponseById(Long id) {
        Optional<Event> eventOpt = eventRepository.findById(id);
        if (!eventOpt.isPresent()) {
            return Optional.empty();
        }
        Event event = eventOpt.get();
        Map<String, Object> contentMap = contentServiceClient.getSeatingPlanAndMultimedia(String.valueOf(event.getId()));
        EventResponse response = new EventResponse();
        response.setId(event.getId());
        response.setTitle(event.getTitle());
        response.setDescription(event.getDescription());
        response.setEventDate(event.getEventDate());
        response.setLocation(event.getLocation());
        response.setStatus(event.getStatus());
        response.setCreatedAt(event.getCreatedAt());
        response.setUpdatedAt(event.getUpdatedAt());
        if (contentMap != null) {
            response.setSeatingPlan((Map<String, Object>) contentMap.get("seatingPlan"));
            response.setMultimedia((java.util.List<String>) contentMap.get("multimedia"));
        }
        return Optional.of(response);
    }
}

package com.example.event.adminservice.controller;

import com.example.event.adminservice.model.Event;
import com.example.event.adminservice.service.AdminEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/events")
public class AdminEventController {

    private final AdminEventService adminEventService;

    public AdminEventController(AdminEventService adminEventService) {
        this.adminEventService = adminEventService;
    }

    // Получение списка всех мероприятий (административный доступ)
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = adminEventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    // Получение детальной информации о мероприятии по ID
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return adminEventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создание нового мероприятия
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = adminEventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    // Обновление мероприятия
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        try {
            Event updatedEvent = adminEventService.updateEvent(id, event);
            return ResponseEntity.ok(updatedEvent);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Удаление мероприятия
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        adminEventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

    // Отмена мероприятия (смена статуса на "canceled")
    @PostMapping("/{id}/cancel")
    public ResponseEntity<Event> cancelEvent(@PathVariable Long id) {
        try {
            Event canceledEvent = adminEventService.cancelEvent(id);
            return ResponseEntity.ok(canceledEvent);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}

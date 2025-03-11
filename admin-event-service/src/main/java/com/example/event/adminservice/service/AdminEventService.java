package com.example.event.adminservice.service;

import com.example.event.adminservice.model.Event;
import com.example.event.adminservice.repository.EventRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminEventService {

    private final EventRepository eventRepository;

    public AdminEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Получение всех мероприятий
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Получение мероприятия по ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Создание нового мероприятия
    public Event createEvent(Event event) {
        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());
        event.setStatus("active"); // По умолчанию мероприятие активно
        return eventRepository.save(event);
    }

    // Обновление мероприятия
    @Transactional
    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setTitle(updatedEvent.getTitle());
                    event.setDescription(updatedEvent.getDescription());
                    event.setEventDate(updatedEvent.getEventDate());
                    event.setLocation(updatedEvent.getLocation());
                    event.setUpdatedAt(LocalDateTime.now());
                    // Обновляем статус, если он передан
                    if (updatedEvent.getStatus() != null) {
                        event.setStatus(updatedEvent.getStatus());
                    }
                    return eventRepository.save(event);
                }).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // Удаление мероприятия
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // Отмена мероприятия (смена статуса на "canceled")
    @Transactional
    public Event cancelEvent(Long id) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setStatus("canceled");
                    event.setUpdatedAt(LocalDateTime.now());
                    return eventRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }
}

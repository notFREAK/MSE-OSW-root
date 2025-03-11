package com.example.event.publicservice.dto;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

public class EventResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime eventDate;
    private String location;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Данные из Content Service
    private Map<String, Object> seatingPlan;
    private List<String> multimedia;

    public EventResponse() {
    }

    // Геттеры и сеттеры

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getEventDate() { return eventDate; }
    public void setEventDate(LocalDateTime eventDate) { this.eventDate = eventDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Map<String, Object> getSeatingPlan() { return seatingPlan; }
    public void setSeatingPlan(Map<String, Object> seatingPlan) { this.seatingPlan = seatingPlan; }

    public List<String> getMultimedia() { return multimedia; }
    public void setMultimedia(List<String> multimedia) { this.multimedia = multimedia; }
}

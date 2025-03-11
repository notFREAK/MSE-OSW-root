package com.example.content.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "contents")
public class ContentItem {

    @Id
    private String id;
    private String eventId; // Ссылка на событие (из SQL)
    private SeatingPlan seatingPlan;
    private List<String> multimedia; 
    private Date createdAt;
    private Date updatedAt;

    public ContentItem() {
    }

    public ContentItem(String eventId, SeatingPlan seatingPlan, List<String> multimedia, Date createdAt, Date updatedAt) {
        this.eventId = eventId;
        this.seatingPlan = seatingPlan;
        this.multimedia = multimedia;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }
    public void setSeatingPlan(SeatingPlan seatingPlan) {
        this.seatingPlan = seatingPlan;
    }

    public List<String> getMultimedia() {
        return multimedia;
    }
    public void setMultimedia(List<String> multimedia) {
        this.multimedia = multimedia;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

package com.example.notification.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Идентификатор пользователя, которому предназначено уведомление
    @Column(nullable = false)
    private Long userId;

    // Сообщение уведомления
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    // Дата создания уведомления
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Флаг, указывающий, прочитано ли уведомление
    @Column(nullable = false)
    private Boolean read;

    public Notification() {
    }

    public Notification(Long userId, String message, LocalDateTime createdAt, Boolean read) {
        this.userId = userId;
        this.message = message;
        this.createdAt = createdAt;
        this.read = read;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}

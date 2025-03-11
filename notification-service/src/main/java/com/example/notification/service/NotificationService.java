package com.example.notification.service;

import com.example.notification.model.Notification;
import com.example.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Получение всех уведомлений для конкретного пользователя
    public List<Notification> getNotificationsForUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Создание нового уведомления
    public Notification createNotification(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);
        return notificationRepository.save(notification);
    }

    // Обновление уведомления (например, маркировка как прочитанного)
    @Transactional
    public Optional<Notification> markAsRead(Long id) {
        Optional<Notification> optional = notificationRepository.findById(id);
        optional.ifPresent(notification -> {
            notification.setRead(true);
            notificationRepository.save(notification);
        });
        return optional;
    }

    // Удаление уведомления
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}

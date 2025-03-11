package com.example.analytics.consumer;

import com.example.analytics.service.AnalyticsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    private final AnalyticsService analyticsService;

    public EventConsumer(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    // Подписка на топик бронирований
    @KafkaListener(topics = "booking-events", groupId = "analytics-group")
    public void consumeBookingEvent(String message) {
        // Обработка события бронирования
        analyticsService.processBookingEvent(message);
    }

    // Можно добавить дополнительные методы для других топиков:
    @KafkaListener(topics = "ticket-events", groupId = "analytics-group")
    public void consumeTicketEvent(String message) {
        analyticsService.processTicketEvent(message);
    }

    @KafkaListener(topics = "payment-events", groupId = "analytics-group")
    public void consumePaymentEvent(String message) {
        analyticsService.processPaymentEvent(message);
    }
}

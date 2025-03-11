package com.example.analytics.service;

import com.example.analytics.model.Report;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    // В реальной реализации необходимо использовать базу данных или in-memory хранилище для агрегированных данных.
    // Здесь для простоты используем переменные, чтобы продемонстрировать логику.

    private int totalBookings = 0;
    private int totalTickets = 0;
    private double totalPayments = 0.0;

    // Метод для обработки событий бронирования
    public void processBookingEvent(String eventMessage) {
        // Пример: увеличить общее число бронирований на 1
        System.out.println("Processing booking event: " + eventMessage);
        totalBookings++;
    }

    // Метод для обработки событий билетов
    public void processTicketEvent(String eventMessage) {
        System.out.println("Processing ticket event: " + eventMessage);
        totalTickets++;
    }

    // Метод для обработки событий платежей
    public void processPaymentEvent(String eventMessage) {
        System.out.println("Processing payment event: " + eventMessage);
        try {
            double payment = Double.parseDouble(eventMessage);
            totalPayments += payment;
        } catch (NumberFormatException ex) {
            System.err.println("Failed to parse payment amount from event: " + eventMessage);
        }
    }

    // Метод для получения агрегированного отчёта
    public Report getAggregatedReport() {
        return new Report(totalBookings, totalTickets, totalPayments);
    }
}

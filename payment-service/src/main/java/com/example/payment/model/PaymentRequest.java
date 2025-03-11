package com.example.payment.model;

public class PaymentRequest {
    private Long bookingId;
    private double amount;
    // Дополнительные поля (например, валюта) можно добавить по необходимости

    public PaymentRequest() {
    }

    public PaymentRequest(Long bookingId, double amount) {
        this.bookingId = bookingId;
        this.amount = amount;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

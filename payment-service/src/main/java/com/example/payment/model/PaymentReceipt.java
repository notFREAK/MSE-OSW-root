package com.example.payment.model;

import java.time.LocalDateTime;

public class PaymentReceipt {
    private String receiptId;
    private Long bookingId;
    private double amount;
    private String status; // Например, "PAID"
    private LocalDateTime paymentDate;

    public PaymentReceipt() {
    }

    public PaymentReceipt(String receiptId, Long bookingId, double amount, String status, LocalDateTime paymentDate) {
        this.receiptId = receiptId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}

package com.example.ticketing.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Идентификатор бронирования, по которому создан билет
    @Column(nullable = false)
    private Long bookingId;

    // Уникальный код билета (например, QR-код)
    @Column(nullable = false, unique = true)
    private String ticketCode;

    @Column(nullable = false)
    private LocalDateTime issueDate;

    public Ticket() {
    }

    public Ticket(Long bookingId, String ticketCode, LocalDateTime issueDate) {
        this.bookingId = bookingId;
        this.ticketCode = ticketCode;
        this.issueDate = issueDate;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getTicketCode() {
        return ticketCode;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }
}

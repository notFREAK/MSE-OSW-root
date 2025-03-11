package com.example.analytics.model;

public class Report {
    private int totalBookings;
    private int totalTickets;
    private double totalPayments;

    public Report() {
    }

    public Report(int totalBookings, int totalTickets, double totalPayments) {
        this.totalBookings = totalBookings;
        this.totalTickets = totalTickets;
        this.totalPayments = totalPayments;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(int totalBookings) {
        this.totalBookings = totalBookings;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }
}

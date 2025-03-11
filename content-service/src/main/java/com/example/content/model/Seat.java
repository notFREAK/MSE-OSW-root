package com.example.content.model;

public class Seat {
    private int row;
    private String number;
    private String status; // available, booked, etc.

    public Seat() {
    }

    public Seat(int row, String number, String status) {
        this.row = row;
        this.number = number;
        this.status = status;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

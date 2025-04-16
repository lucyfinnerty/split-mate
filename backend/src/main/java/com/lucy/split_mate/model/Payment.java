package com.lucy.split_mate.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Roommate from; // Roommate ID of the person who made the payment
    private Roommate to; // Roommate ID of the person who received the payment
    private double amount; // Amount paid
    private String method; // Payment method (e.g., "Venmo", "Manual")
    private LocalDate date; // Date of the payment

    public Payment() {}
    public Payment(Long id, Roommate from, Roommate to, double amount, String method, LocalDate date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.method = method;
        this.date = date;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Roommate getFrom() {
        return from;
    }
    public void setFrom(Roommate from) {
        this.from = from;
    }
    public Roommate getTo() {
        return to;
    }
    public void setTo(Roommate to) {
        this.to = to;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}

package com.lucy.split_mate.model;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int from; // Roommate ID of the person who made the payment
    private int to; // Roommate ID of the person who received the payment
    private double amount; // Amount paid
    private String method; // Payment method (e.g., "Venmo", "Manual")
    private String date; // Date of the payment

    public Payment() {}
    public Payment(int id, int from, int to, double amount, String method, String date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.method = method;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getFrom() {
        return from;
    }
    public void setFrom(int from) {
        this.from = from;
    }
    public int getTo() {
        return to;
    }
    public void setTo(int to) {
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

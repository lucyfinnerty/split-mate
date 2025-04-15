package com.lucy.split_mate.model;

import java.util.Map;

import jakarta.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double amount;
    private Roommate paidBy; // Roommate who paid for the expense
    private String date; // Date of the expense
    Map<Roommate, Double> splitWith; // Amount each roommate owes for the expense
    Household household; // Household to which the expense belongs

    public Expense() {}
    public Expense(int id, String title, double amount, Roommate paidBy, String date, Map<Roommate, Double> splitWith, Household household) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.paidBy = paidBy;
        this.date = date;
        this.splitWith = splitWith;
        this.household = household;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Roommate getPaidBy() {
        return paidBy;
    }
    public void setPaidBy(Roommate paidBy) {
        this.paidBy = paidBy;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Map<Roommate, Double> getSplitWith() {
        return splitWith;
    }
    public void setSplitWith(Map<Roommate, Double> splitWith) {
        this.splitWith = splitWith;
    }
    public Household getHousehold() {
        return household;
    }
    public void setHousehold(Household household) {
        this.household = household;
    }
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", paidBy=" + paidBy +
                ", date='" + date + '\'' +
                ", splitWith=" + splitWith +
                ", household=" + household +
                '}';
    }
    public void addSplitWith(Roommate roommate, double amount) {
        this.splitWith.put(roommate, amount);
    }
    public void removeSplitWith(Roommate roommate) {
        this.splitWith.remove(roommate);
    }
    public void clearSplitWith() {
        this.splitWith.clear();
    }
    public void clearAll() {
        this.splitWith.clear();
    }
    public void clearHousehold() {
        this.household = null;
    }
}

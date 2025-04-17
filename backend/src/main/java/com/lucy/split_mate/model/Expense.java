package com.lucy.split_mate.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private double amount;
    private String date; // Date of the expense

    @ManyToOne
    @JoinColumn(name = "paid_by_id")
    private Roommate paidBy; // Roommate who paid for the expense

    @ManyToOne
    @JoinColumn(name = "household_id")
    Household household; // Household to which the expense belongs

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<SplitShare> splitWith;

    public Expense() {}
    public Expense(Long id, String title, double amount, Roommate paidBy, String date, List<SplitShare> splitWith, Household household) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.paidBy = paidBy;
        this.date = date;
        this.splitWith = splitWith;
        this.household = household;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public List<SplitShare> getSplitWith() {
        return splitWith;
    }
    public void setSplitWith(List<SplitShare> splitWith) {
        this.splitWith = splitWith;
    }
    public Household getHousehold() {
        return household;
    }
    public void setHousehold(Household household) {
        this.household = household;
    }
}

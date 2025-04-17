package com.lucy.split_mate.model;

import jakarta.persistence.*;

@Entity
public class SplitShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Roommate roommate;

    private Double amount;

    @ManyToOne
    private Expense expense;

    public SplitShare(){}
    public SplitShare(Long id, Roommate roommate, Double amount, Expense expense) {
        this.id = id;
        this.roommate = roommate;
        this.amount = amount;
        this.expense = expense;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Roommate getRoommate() {
        return roommate;
    }
    public void setRoommate(Roommate roommate) {
        this.roommate = roommate;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Expense getExpense() {
        return expense;
    }
    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}

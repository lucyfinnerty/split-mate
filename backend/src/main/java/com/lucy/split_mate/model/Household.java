package com.lucy.split_mate.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    List<Roommate> roommates;
    List<Expense> expenses;

    public Household(){}
    public Household(int id, String name, List<Roommate> roommates, List<Expense> expenses) {
        this.id = id;
        this.name = name;
        this.roommates = roommates;
        this.expenses = expenses;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Roommate> getRoommates() {
        return roommates;
    }
    public void setRoommates(List<Roommate> roommates) {
        this.roommates = roommates;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
    public void addRoommate(Roommate roommate) {
        this.roommates.add(roommate);
    }
    public void removeRoommate(Roommate roommate) {
        this.roommates.remove(roommate);
    }
    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }
    public void removeExpense(Expense expense) {
        this.expenses.remove(expense);
    }
    public void clearRoommates() {
        this.roommates.clear();
    }
    public void clearExpenses() {
        this.expenses.clear();
    }
    public void clearAll() {
        this.roommates.clear();
        this.expenses.clear();
    }
    
}

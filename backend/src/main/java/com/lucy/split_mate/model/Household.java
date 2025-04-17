package com.lucy.split_mate.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "household")
    List<Roommate> roommates;
    
    @OneToMany(mappedBy = "household")
    List<Expense> expenses;

    public Household(){}
    public Household(Long id, String name, List<Roommate> roommates, List<Expense> expenses) {
        this.id = id;
        this.name = name;
        this.roommates = roommates;
        this.expenses = expenses;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
}

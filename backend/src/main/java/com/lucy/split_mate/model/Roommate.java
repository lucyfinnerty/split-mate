package com.lucy.split_mate.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Roommate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    Household household;
    List<Payment> payments;

    public Roommate() {}
    public Roommate(int id, String name, String email, Household household, List<Payment> payments) {
        this.id = id;
        this. name = name;
        this.email = email;
        //this.household = household;
        //this.payments = payments;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Household getHousehold() {
        return household;
    }
    public void setHousehold(Household household) {
        this.household = household;
    }
    public List<Payment> getPayments() {
        return payments;
    }
    public void setPayment(List<Payment> payments) {
        this.payments = payments;
    }
}

package com.lucy.split_mate.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Roommate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    @OneToMany(mappedBy = "from")
    private List<Payment> paymentsMade;
    @OneToMany(mappedBy = "to")
    private List<Payment> paymentsReceived;

    public Roommate() {}
    public Roommate(Long id, String name, String email, Household household, List<Payment> paymentsMade, List<Payment> paymentsReceived) {
        this.id = id;
        this. name = name;
        this.email = email;
        this.household = household;
        this.paymentsMade = paymentsMade;
        this.paymentsReceived = paymentsReceived;
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
    public List<Payment> getPaymentsMade() {
        return paymentsMade;
    }
    public void setPaymentsMade(List<Payment> paymentsMade) {
        this.paymentsMade = paymentsMade;
    }
    public List<Payment> getPaymentsReceived() {
        return paymentsReceived;
    }
    public void setPaymentsReceived(List<Payment> paymentsReceived) {
        this.paymentsReceived = paymentsReceived;
    }
}

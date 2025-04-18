package com.lucy.split_mate.service;

import java.util.List;

import com.lucy.split_mate.model.Payment;

public interface PaymentServiceInterface {
    public Payment addPayment(Payment payment);
    public void removePayment(Payment payment);
    public Payment getPaymentById(Long id);
    public List<Payment> getAllPayments();
    public List<Payment> getPaymentsByRoommate(Long roommateId);
    public List<Payment> getPaymentsBetweenRoommates(Long id1, Long id2);
}

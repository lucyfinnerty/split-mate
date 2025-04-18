package com.lucy.split_mate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucy.split_mate.model.*;
import com.lucy.split_mate.repository.*;

@Service
public class PaymentService implements PaymentServiceInterface {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    @Override
    public void removePayment(Payment payment) {
        paymentRepository.delete(payment);
    }
    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
            .orElseThrow(() -> new IllegalArgumentException("Payment not found with ID: " + paymentId));
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    @Override
    public List<Payment> getPaymentsByRoommate(Long roommateId) {
        return paymentRepository.findByFromIdOrToId(roommateId, roommateId);
    }
    @Override
    public List<Payment> getPaymentsBetweenRoommates(Long id1, Long id2) {
        List<Payment> aToB = paymentRepository.findByFromIdAndToId(id1, id2);
        List<Payment> bToA = paymentRepository.findByFromIdAndToId(id2, id1);
        aToB.addAll(bToA);
        return aToB;
    }
}

package com.lucy.split_mate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lucy.split_mate.model.Payment;
import com.lucy.split_mate.service.PaymentServiceInterface;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {
    
    @Autowired
    PaymentServiceInterface paymentService;

    @PutMapping("/add")
    public String add(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return "New expense is added!";
    }

    @DeleteMapping("/remove")
    public String remove(@RequestBody Payment payment) {
        paymentService.removePayment(payment);
        return "Expense is removed!";
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/all")
    public List<Payment> getAll() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/roommate/{roommateId}")
    public List<Payment> getPaymentsByRoommate(@PathVariable Long roommateId) {
        return paymentService.getPaymentsByRoommate(roommateId);
    }

    @GetMapping("/between/{id1}/{id2}")
    public List<Payment> getPaymentsBetweenRoommates(@PathVariable Long id1, @PathVariable Long id2) {
        return paymentService.getPaymentsBetweenRoommates(id1, id2);
    }
}

package com.lucy.split_mate.service;

public interface PaymentServiceInterface {
    public void addPayment(Long id, String name, String description, Double amount, String date, String category, Long householdId);
    public void removePayment(Long id);
    public void getPaymentById(Long id);
    public void getAllPayments();
    public void getHouseholdPayments(Long householdId);
    public void getRoommatePayments(Long roommateId);
    public void updatePayment(Long id, String name, String description, Double amount, String date, String category);
    public void splitPayment(Long paymentId, Long[] roommateIds);
    public void markPaymentAsPaid(Long paymentId, Long roommateId);
    public void getUnpaidPayments();
    public void getPaidPayments();
}

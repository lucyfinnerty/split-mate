package com.lucy.split_mate.service;

public interface ExpenseServiceInterface {
    public void addExpense(Long id, String name, String description, Double amount, String date, String category, Long householdId);
    public void removeExpense(Long id);
    public void getExpenseById(Long id);
    public void getAllExpenses();
    public void getHouseholdExpenses(Long householdId);
    public void getRoommateExpenses(Long roommateId);
    public void updateExpense(Long id, String name, String description, Double amount, String date, String category);
    public void splitExpense(Long expenseId, Long[] roommateIds);
    public void markExpenseAsPaid(Long expenseId, Long roommateId);
    public void getUnpaidExpenses();
}

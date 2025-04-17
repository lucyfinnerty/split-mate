package com.lucy.split_mate.service;

import java.util.List;

import com.lucy.split_mate.model.*;

public interface ExpenseServiceInterface {
    public Expense addExpense(Expense expense);
    public void removeExpense(Expense expense);
    public Expense getExpenseById(Long id);
    public List<Expense> getAllExpenses();
    public List<Expense> getHouseholdExpenses(Long householdId);
    public List<Expense> getRoommateExpenses(Long roommateId);
    public Expense updateExpense(Expense expense);
    public void splitExpense(Long expenseId, Long[] roommateIds);
    public void markExpenseAsPaid(Long expenseId, Long roommateId);
    public List<Expense> getUnpaidExpenses();
}

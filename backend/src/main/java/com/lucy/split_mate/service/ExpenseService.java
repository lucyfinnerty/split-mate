package com.lucy.split_mate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucy.split_mate.model.*;
import com.lucy.split_mate.repository.*;

import jakarta.transaction.Transactional;

@Service
public class ExpenseService implements ExpenseServiceInterface {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private RoommateRepository roommateRepository;

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    @Override
    public void removeExpense(Expense expense) {
        expenseRepository.delete(expense);
    }
    @Override
    public Expense getExpenseById(Long expenseId) {
        return expenseRepository.findById(expenseId)
            .orElseThrow(() -> new IllegalArgumentException("Expense not found with ID: " + expenseId));
    }
    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    @Override
    public List<Expense> getHouseholdExpenses(Long householdId) {
        Household household = householdRepository.findById(householdId)
            .orElseThrow(() -> new IllegalArgumentException("Household not found."));
        return household.getExpenses();

    }
    @Override
    public List<Expense> getRoommateExpenses(Long roommateId) {
        Roommate roommate = roommateRepository.findById(roommateId)
            .orElseThrow(() -> new IllegalArgumentException("Roommate not found."));

        return expenseRepository.findAll().stream()
            .filter(e -> e.getPaidBy().equals(roommate) || 
                         e.getSplitShares().stream()
                             .anyMatch(ss -> ss.getRoommate().equals(roommate)))
            .toList();
    }
    @Override
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    @Override
    @Transactional
    public void splitExpense(Long expenseId, Long[] roommateIds) {
        Expense expense = getExpenseById(expenseId);
        double amountPerRoommate = expense.getAmount() / roommateIds.length;

        List<SplitShare> splitShares = new ArrayList<>();

        for (Long roommateId : roommateIds) {
            Roommate roommate = roommateRepository.findById(roommateId)
                .orElseThrow(() -> new IllegalArgumentException("Roommate not found with ID: " + roommateId));

            SplitShare splitShare = new SplitShare();
            splitShare.setRoommate(roommate);
            splitShare.setAmount(amountPerRoommate);
            splitShare.setExpense(expense);

            splitShares.add(splitShare);
        }
        expense.setSplitShares(splitShares);
        return;
    }
    @Override
    public void markExpenseAsPaid(Long expenseId, Long roommateId) {
        Expense expense = getExpenseById(expenseId);
        Roommate roommate = roommateRepository.findById(roommateId)
            .orElseThrow(() -> new IllegalArgumentException("Roommate not found"));

        List<SplitShare> shares = expense.getSplitShares();
        boolean removed = shares.removeIf(share -> share.getRoommate().equals(roommate));

        if (removed) {
            expenseRepository.save(expense); // JPA will remove orphaned SplitShare entries
        } else {
            throw new IllegalArgumentException("Roommate does not owe anything for this expense");
        }
    }

    @Override
    public List<Expense> getUnpaidExpenses() {
        return expenseRepository.findAll().stream()
            .filter(e -> !e.getSplitShares().isEmpty())
            .toList();
    }
}

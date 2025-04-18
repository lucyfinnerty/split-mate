package com.lucy.split_mate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lucy.split_mate.model.*;
import com.lucy.split_mate.service.ExpenseServiceInterface;

@RestController
@RequestMapping("/expense")
@CrossOrigin
public class ExpenseController {

    @Autowired
    ExpenseServiceInterface expenseService;

    @PutMapping("/add")
    public String add(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return "New expense is added!";
    }

    @DeleteMapping("/remove")
    public String remove(@RequestBody Expense expense) {
        expenseService.removeExpense(expense);
        return "Expense is removed!";
    }

    @GetMapping("/{id}")
    public Expense getById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @GetMapping("/all")
    public List<Expense> getAll() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/household/{householdId}")
    public List<Expense> getExpensesByHousehold(@PathVariable Long householdId) {
        return expenseService.getHouseholdExpenses(householdId);
    }

    @GetMapping("/roommate/{roommateId}")
    public List<Expense> getExpensesByRoommate(@PathVariable Long roommateId) {
        return expenseService.getRoommateExpenses(roommateId);
    }

    @PutMapping("/update")
    public Expense updateExpense(@RequestBody Expense expense) {
        return expenseService.updateExpense(expense);
    }

    @PutMapping("/split/{expenseId}")
    public String splitExpense(@PathVariable Long expenseId, @RequestBody Long[] roommateIds) {
        expenseService.splitExpense(expenseId, roommateIds);
        return "Expense split among roommates!";
    }

    @PutMapping("/mark-paid/{expenseId}/{roommateId}")
    public String markAsPaid(@PathVariable Long expenseId, @PathVariable Long roommateId) {
        expenseService.markExpenseAsPaid(expenseId, roommateId);
        return "Roommate marked as paid for the expense!";
    }

    @GetMapping("/unpaid")
    public List<Expense> getUnpaidExpenses() {
        return expenseService.getUnpaidExpenses();
    }
}

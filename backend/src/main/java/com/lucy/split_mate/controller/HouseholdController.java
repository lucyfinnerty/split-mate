package com.lucy.split_mate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lucy.split_mate.model.*;
import com.lucy.split_mate.service.HouseholdServiceInterface;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/household")
@CrossOrigin
public class HouseholdController {

    @Autowired
    HouseholdServiceInterface householdService;

    @PutMapping("/add")
    public String add(@RequestBody Household household) {
        householdService.addHousehold(household);
        return "New household is added!";
    }

    @DeleteMapping("/remove")
    public String remove(@RequestBody Household household) {
        householdService.removeHousehold(household);
        return "Household is removed!";
    }

    @GetMapping("/{id}")
    public Household getById(@PathVariable Long id) {
        return householdService.getHouseholdById(id);
    }

    @GetMapping("/all")
    public List<Household> getAll() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/{id}/roommates")
    public List<Roommate> getRoommates(@PathVariable Long householdId) {
        return householdService.getHouseholdRoommates(householdId);
    }

    @GetMapping("/{id}/expenses")
    public List<Expense> getExpense(@PathVariable Long expenseId) {
        return householdService.getHouseholdExpenses(expenseId);
    }

    @GetMapping("/{id}/payments")
    public List<Payment> getPayments(@PathVariable Long paymentId) {
        return householdService.getHouseholdPayments(paymentId);
    }
}

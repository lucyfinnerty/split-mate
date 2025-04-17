package com.lucy.split_mate.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucy.split_mate.model.*;
import com.lucy.split_mate.repository.HouseholdRepository;

@Service
public class HouseholdService implements HouseholdServiceInterface{

    @Autowired
    HouseholdRepository householdRepository;

    @Override
    public Household addHousehold(Household household) {
        return householdRepository.save(household);
    }
    @Override
    public void removeHousehold(Household household) {
        householdRepository.delete(household);
    }
    @Override
    public Household getHouseholdById(Long householdId) {
        return householdRepository.findById(householdId)
            .orElseThrow(() -> new IllegalArgumentException("Household not found with ID: " + householdId));
    }
    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }
    @Override
    public List<Roommate> getHouseholdRoommates(Long householdId) {
        Household household = getHouseholdById(householdId);
        return household.getRoommates();
    }
    @Override
    public List<Expense> getHouseholdExpenses(Long householdId) {
        Household household = getHouseholdById(householdId);
        return household.getExpenses();
    }
    @Override
    public List<Payment> getHouseholdPayments(Long householdId) {
        Household household = getHouseholdById(householdId);
        return household.getRoommates().stream()
            .flatMap(roommate -> {
            List<Payment> made = roommate.getPaymentsMade();
            List<Payment> received = roommate.getPaymentsReceived();
            return Stream.concat(made.stream(), received.stream());
        })
        .distinct() // Optional: removes duplicates if any (like if roommate A pays roommate B, and you include both sides)
        .toList();
    }
}

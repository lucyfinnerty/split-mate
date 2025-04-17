package com.lucy.split_mate.service;

import java.util.List;

import com.lucy.split_mate.model.*;

public interface HouseholdServiceInterface {
    public Household addHousehold(Household household);
    public void removeHousehold(Household household);
    public Household getHouseholdById(Long householdId);
    public List<Household> getAllHouseholds();
    public List<Roommate> getHouseholdRoommates(Long householdId);
    public List<Expense> getHouseholdExpenses(Long id);
    public List<Payment> getHouseholdPayments(Long id);
}

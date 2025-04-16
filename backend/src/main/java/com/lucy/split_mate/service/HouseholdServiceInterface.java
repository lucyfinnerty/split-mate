package com.lucy.split_mate.service;

import java.util.List;

import com.lucy.split_mate.model.Expense;
import com.lucy.split_mate.model.Household;
import com.lucy.split_mate.model.Payment;

public interface HouseholdServiceInterface {
    public void addHousehold(Long id, String name, String address, List<Roommate> roommates, List<Expense> expenses, List<Payment> payments);
    public void removeHousehold(Long id);
    public void getHouseholdById(Long id);
    public void getAllHouseholds(List<Household> households);
    public void getHouseholdRoommates(Long id, List<Roommate> roommates);
    public void getHouseholdExpenses(Long id, List<Expense> expenses);
    public void getHouseholdPayments(Long id, List<Payment> payments);
}

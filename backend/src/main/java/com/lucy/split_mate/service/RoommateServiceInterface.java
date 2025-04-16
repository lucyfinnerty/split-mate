package com.lucy.split_mate.service;

import java.util.List;

import com.lucy.split_mate.model.Household;
import com.lucy.split_mate.model.Roommate;

public interface RoommateServiceInterface {
    public void addRoommate(Long id, String name, String email, Household household, List<Roommate> roommates, List<Roommate> paymentsMade, List<Roommate> paymentsReceived);
    public void removeRoommate(Long id);
    public void getRoommatePayments(Long id, List<Roommate> paymentsMade, List<Roommate> paymentsReceived);
    public void getRoommateById(Long id);
    public void getAllRoommates(List<Roommate> roommates);
}

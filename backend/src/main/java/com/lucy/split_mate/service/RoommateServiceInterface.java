package com.lucy.split_mate.service;

import java.util.List;

import com.lucy.split_mate.model.*;

public interface RoommateServiceInterface {
    public Roommate addRoommate(Roommate roommate);
    public void removeRoommate(Roommate roommate);
    public List<Payment> getRoommatePayments(Long roommateId);
    public Roommate getRoommateById(Long roommateId);
    public List<Roommate> getAllRoommates();
}

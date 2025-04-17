package com.lucy.split_mate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucy.split_mate.model.*;
import com.lucy.split_mate.repository.*;

@Service
public class RoommateService implements RoommateServiceInterface {

    @Autowired
    private RoommateRepository roommateRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Roommate addRoommate(Roommate roommate) {
        return roommateRepository.save(roommate);
    }

    @Override
    public void removeRoommate(Roommate roommate) {
        roommateRepository.delete(roommate);
    }

    @Override
    public List<Payment> getRoommatePayments(Long roommateId) {
        return paymentRepository.findByFromIdOrToId(roommateId, roommateId);
    }

    @Override
    public Roommate getRoommateById(Long roommateId) {
        return roommateRepository.findById(roommateId)
            .orElseThrow(() -> new IllegalArgumentException("Roommate not found with ID: " + roommateId));
    }

    @Override
    public List<Roommate> getAllRoommates() {
        return roommateRepository.findAll();
    }
}

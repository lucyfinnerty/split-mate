package com.lucy.split_mate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lucy.split_mate.model.*;
import com.lucy.split_mate.service.RoommateServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/roommate")
@CrossOrigin
public class RoommateController {

    @Autowired
    private RoommateServiceInterface roommateService;

    @PostMapping("/add")
    public String add(@RequestBody Roommate roommate) {
        roommateService.addRoommate(roommate);
        return "New roommate is added!";
    }

    @DeleteMapping("/remove")
    public String remove(@RequestBody Roommate roommate) {
        roommateService.removeRoommate(roommate);
        return "Roommate is removed!";
    }

    @GetMapping("/{id}")
    public Roommate getById(@PathVariable Long id) {
        return roommateService.getRoommateById(id);
    }
    
    @GetMapping("/all")
    public List<Roommate> getAll() {
        return roommateService.getAllRoommates();
    }
    
    @GetMapping("/{id}/payments")
    public List<Payment> getPayments(@PathVariable Long id) {
        return roommateService.getRoommatePayments(id);
    }
}

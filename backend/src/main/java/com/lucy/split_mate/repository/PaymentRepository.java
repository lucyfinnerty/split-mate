package com.lucy.split_mate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucy.split_mate.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

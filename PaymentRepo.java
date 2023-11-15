package com.edu.eduexcellence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepo extends JpaRepository<Payment, String> {
    //Optional<Payment> findBystudentName(String studentName);
    Optional<Payment> findByStudentName(String studentName);
}

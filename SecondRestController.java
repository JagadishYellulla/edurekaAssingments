package com.edu.eduexcellence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2")
public class SecondRestController {
    @GetMapping("hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("This is my fourth assignment");
    }

    @Autowired
    PaymentRepo paymentRepo;

    @PostMapping("payment")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentRepo.save(payment), HttpStatus.CREATED);

    }

    @GetMapping("getpayments")
    public ResponseEntity<List<Payment>> getPayments() {
        return new ResponseEntity<>(paymentRepo.findAll(), HttpStatus.OK);

    }

   /*@GetMapping("payment/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable long id) {
        Optional<Payment> payment = paymentRepo.findById(id);
        if (payment.isPresent()) {
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    } */

    @GetMapping("payment/{studentName}")
    public ResponseEntity<Payment> getPayment(@PathVariable String studentName) {
        Optional<Payment> payment = paymentRepo.findByStudentName(studentName);
        if (payment.isPresent()) {
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}

package com.example.payment.controller;

import com.example.payment.model.PaymentReceipt;
import com.example.payment.model.PaymentRequest;
import com.example.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentReceipt> processPayment(@RequestBody PaymentRequest request) {
        PaymentReceipt receipt = paymentService.processPayment(request);
        return ResponseEntity.ok(receipt);
    }
}

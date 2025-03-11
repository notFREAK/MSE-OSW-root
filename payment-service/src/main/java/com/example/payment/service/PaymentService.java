package com.example.payment.service;

import com.example.payment.model.PaymentReceipt;
import com.example.payment.model.PaymentRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    /**
     * Заглушка: принимает любой платёж и возвращает успешный чек.
     */
    public PaymentReceipt processPayment(PaymentRequest request) {
        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setReceiptId(UUID.randomUUID().toString());
        receipt.setBookingId(request.getBookingId());
        receipt.setAmount(request.getAmount());
        receipt.setStatus("PAID");  // Все платежи считаются успешно выполненными
        receipt.setPaymentDate(LocalDateTime.now());
        return receipt;
    }
}

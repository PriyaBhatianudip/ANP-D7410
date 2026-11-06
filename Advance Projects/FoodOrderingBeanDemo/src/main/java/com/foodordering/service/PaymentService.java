package com.foodordering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodordering.payment.Payment;

@Service
public class PaymentService {

    @Autowired
    private Payment payment;

    public void processPayment(double amount) {
        payment.pay(amount);
    }
}
package com.foodordering.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.foodordering.payment.Payment;

@Service
public class PaymentService {

    private final Map<String, Payment> paymentMethods;

    public PaymentService(Map<String, Payment> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void processPayment(String method, double amount) {

        Payment payment = paymentMethods.get(method);

        if (payment == null) {
            System.out.println("Invalid payment method!");
            return;
        }

        payment.pay(amount);
    }
}
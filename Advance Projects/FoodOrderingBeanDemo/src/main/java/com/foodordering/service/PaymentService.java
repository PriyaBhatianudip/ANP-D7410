package com.foodordering.service;

import org.springframework.stereotype.Service;

import com.foodordering.payment.Payment;

@Service
public class PaymentService {

    private Payment payment;

    public PaymentService(Payment payment) 
    {
		this.payment = payment;
	}

	public void processPayment(double amount) {
        payment.pay(amount);
    }
}
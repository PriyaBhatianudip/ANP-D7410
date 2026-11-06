package com.foodordering.payment;

import org.springframework.stereotype.Component;

@Component
public class CashPayment implements Payment {

    @Override
    public void pay(double amount)
    {
        System.out.println(
            "Cash payment received: Rs. " + amount);
    }
}
package com.foodordering.payment;

import org.springframework.stereotype.Component;

@Component
public class OnlinePayment implements Payment {

    @Override
    public void pay(double amount) 
    {
        System.out.println(
            "Online payment successful: Rs. " + amount);
    }
}
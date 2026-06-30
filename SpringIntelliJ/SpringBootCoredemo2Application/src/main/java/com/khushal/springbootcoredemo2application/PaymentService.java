package com.khushal.springbootcoredemo2application;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay(){
        System.out.println("Payment Done");
    }
}

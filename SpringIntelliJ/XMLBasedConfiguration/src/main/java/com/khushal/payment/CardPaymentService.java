package com.khushal.payment;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Payment Done through Card");
    }
}

package com.khushal.springwithoutappcontext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {
//    @Value("${paymentGateway.type}")
//    @Value("${paymentGateway.type:RezorPay}") // if property does not exist in Application.properties then it will take default value :RazorPay
//    private String type;
//    @Value("${paymentGateway.retry-count}")
//    private int retryCount;

//    public PaymentGateway(@Value("${paymentGateway.type}") String type,@Value("${paymentGateway.retry-count}")  int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }


    private final PaymentProperties paymentProperties;

    private PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }
    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }
    public int getTimeout() {
        return paymentProperties.getTimeout();
    }

    public void print(){
        System.out.println("Timeout: "+getTimeout());
        System.out.println("RetryCount: "+getRetryCount());
        System.out.println("Type: "+getType());
        System.out.println("isEnabled: "+isEnabled());
    }

}

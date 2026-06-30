package com.khushal.springwithoutappcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class SpringWIthoutAppContextApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(SpringWIthoutAppContextApplication.class, args);

//        PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//        paymentGateway.setType("UPI");
//        paymentGateway.setRetryCount(3);
//        paymentGateway.print();

//        // Without Context you can still run your @Components and call method
        // By  implementing ApplicationRunner , CommandLineRunner also interface
        // like we have done in "DemoRunner.java" Class


    }

}

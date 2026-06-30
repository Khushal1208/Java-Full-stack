package com.khushal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();
//        AppConfig appConfig = context.getBean(AppConfig.class);
//        appConfig.demo();

        CartService cart = context.getBean(CartService.class);
        System.out.println(cart.getValue(1));

        context.close();
    }
}
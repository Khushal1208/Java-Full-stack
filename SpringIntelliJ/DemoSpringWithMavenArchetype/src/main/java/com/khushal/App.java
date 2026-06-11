package com.khushal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Dev dev = (Dev) context.getBean("dev"); // It is called searching by name
        Dev dev = context.getBean(Dev.class); // Searching ByType
        dev.build();
    }
}

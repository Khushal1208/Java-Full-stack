package com.khushal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        OrderService order = (OrderService) context.getBean("orderService");
//        OrderService order = context.getBean(OrderService.class); // Only works when same type bean exist only once otherwise it will give NoUniqueBeanDefinitionException

//        OrderService order2 = context.getBean("orderService",OrderService.class); // if you do like this then there will be no confusion or error
        // It is best way to Get bean by id and type both. Coz it is more specific


//        order2.placeOrder();

        UserService userService = (UserService)context.getBean("userService",UserService.class);

        context.close();
    }
}
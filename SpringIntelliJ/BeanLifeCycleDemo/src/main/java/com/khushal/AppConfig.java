package com.khushal;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
public class AppConfig {
    public void demo(){
        System.out.println("App Config demo");
    }

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public CartService getCartService(){
//        return new CartService();
//    }
}

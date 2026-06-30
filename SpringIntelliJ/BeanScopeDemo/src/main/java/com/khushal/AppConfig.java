package com.khushal;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
public class AppConfig {
    @Bean
    public User getUser(){
        return new User();
    }
}

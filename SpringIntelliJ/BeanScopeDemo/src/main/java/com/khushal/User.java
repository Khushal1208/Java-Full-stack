package com.khushal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
public class User {
    private int age;
    private String name;
    public void getUser(){
        System.out.println("User");
    }
}

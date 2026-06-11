package com.Java_Full_Stack.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CPU {
    @Autowired
    PowerOnOff powerOnOff;
    public void start(){
        powerOnOff.powerOn();
        System.out.println("Laptop is starting to Compile the Code.");
    }
}

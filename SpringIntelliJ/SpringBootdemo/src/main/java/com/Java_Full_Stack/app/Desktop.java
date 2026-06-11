package com.Java_Full_Stack.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    @Autowired
    CPU cpu;
    public void compile() {
        System.out.println("Desktop");
        cpu.start();
    }
}

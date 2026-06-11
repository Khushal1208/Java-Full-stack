package com.Java_Full_Stack.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // we have two beans of computer , so we will get error whom to choose
// so if it is not mentioned explicitly(in case of confusion) make one class as primary
// But if we dont want to use @Primary then mention @Qualifier("Laptop") it explicitly search for only "Laptop" class bean in the container

public class Laptop implements Computer {
    @Autowired
    CPU cpu;
    public void compile() {
        System.out.println("Laptop");
        cpu.start();
    }
}

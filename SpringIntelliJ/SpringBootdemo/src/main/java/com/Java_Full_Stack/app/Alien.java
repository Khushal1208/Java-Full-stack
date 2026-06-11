package com.Java_Full_Stack.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component  // It tells bean to create obj in the container so that i can use it.
// Through this I become free from hessel of creating obj,maintaining obj and destroying obj.
// I can use obj multiple times without being worried of creation to destruction.
public class Alien {

    @Autowired // It says to spring that it's resposibility to get obj of Laptop from Container
            // Basically Component create an obj in Container and Autowired connect obj with the Class
//    Laptop laptop;
    @Qualifier("laptop") // if we dont want to use @Primary in Laptop class then mention here @Qualifier("laptop") it explicitly search for only "Laptop" class bean in the container
    Computer computer;
    public void code(){
        computer.compile();
    }

}

package com.khushal.springwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // creates Getters and Setters
@AllArgsConstructor // creates Constructor
public class Student {

    private int id;
    private String name;

// We are using Lombok so it take care of Getters and Setters and also Constructor

//    public Student(int i, String name) {
//        this.id = i;
//        this.name = name;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}

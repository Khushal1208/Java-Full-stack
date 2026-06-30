package com.khushal.Simple;

import org.springframework.stereotype.Component;

//@Component
public class A {
    private B b;
    public A() {
        this.b = new B();
    }
}

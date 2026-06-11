package com.khushal;
public class Dev {
    //    private Laptop laptop;
    private Computer com;

    private int age ;

    public Dev(){
        System.out.println("Dev Constructor");
    }

//    public Dev(Laptop laptop) {
//        this.laptop = laptop;
//    }

    public void build(){
        System.out.println("Working on Awesome Project");
        com.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer computer) {
        com = computer;
    }

//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }
}

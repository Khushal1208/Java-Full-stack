package com.khushal;

public class Devotee {
    private int age;
    private Book book;
    public Devotee(){

    }

    public Devotee(Book book) {
        this.book = book;
    }

    public void chant(){
        System.out.println("Chanting Holy Name's");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

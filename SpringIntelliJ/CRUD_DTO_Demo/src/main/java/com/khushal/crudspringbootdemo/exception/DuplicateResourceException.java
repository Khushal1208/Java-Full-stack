package com.khushal.crudspringbootdemo.exception;

public class DuplicateResourceException extends  RuntimeException{

    public DuplicateResourceException(String message){
        super(message);
    }
}

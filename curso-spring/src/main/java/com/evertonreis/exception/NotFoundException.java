package com.evertonreis.exception;

public class NotFoundException extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public NotFoundException(String msg){
        super(msg);
    }
}

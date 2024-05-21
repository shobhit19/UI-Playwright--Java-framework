package com.org.ui.auto.exceptions;

public class FrameworkException extends RuntimeException{

    public FrameworkException(String message){
        super(message);
    }
    public FrameworkException(String message,Throwable cause){
        super(message,cause);
    }
}

package com.org.ui.auto.exceptions;

public class PlaywrightInitException extends FrameworkException{

    public PlaywrightInitException(String message){
        super(message);
    }
    public PlaywrightInitException(String message,Throwable cause){
        super(message,cause);
    }
}

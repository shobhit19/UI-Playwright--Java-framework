package com.org.ui.auto.exceptions;

public class InvalidBrowserInvocationException extends FrameworkException{


    public InvalidBrowserInvocationException(String message) {
        super(message);
    }

    public InvalidBrowserInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}

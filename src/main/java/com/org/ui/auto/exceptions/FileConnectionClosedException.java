package com.org.ui.auto.exceptions;

public class FileConnectionClosedException extends FrameworkException{


    public FileConnectionClosedException(String message) {
        super(message);
    }

    public FileConnectionClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}

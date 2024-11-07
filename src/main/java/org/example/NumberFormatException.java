package org.example;

public class NumberFormatException extends Exception{
    public NumberFormatException() {
        super("Number Format Exception");
    }

    public NumberFormatException(String message) {
        super(message);
    }

}

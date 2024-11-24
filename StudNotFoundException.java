package org.example;

public class StudNotFoundException extends Exception{
    public StudNotFoundException() {
        super("Student is not found in the system");
    }

    public StudNotFoundException(String message) {
        super(message);
    }
}

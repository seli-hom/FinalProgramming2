package org.example;

public class IOException extends Exception{
    public IOException() {
        super("I/O Exception");
    }

    public IOException(String message) {
        super(message);
    }
}

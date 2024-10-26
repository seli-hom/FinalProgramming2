package org.example;

abstract class Person {
    private String fName;
    private String lNAme;

    abstract public void getDescription(){
        System.out.println("Name: " + fName + " " + lNAme);
    }
}

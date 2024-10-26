package org.example;

public class Student extends Person{
    private int studId;
    private double studGPA;
    private int nextID = 10001;

    @Override
    public void getDescription() {
        System.out.println("Student: " + studId + "\n"
                + getFName() + " " + getLNAme());
    }
}

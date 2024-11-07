package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
public class Student extends Person{
    private int studId;
    @Setter
    private double studGPA;
    private static int nextID = 10001;

    public Student() {
    }

    public Student(int studId, double studGPA) {
        this.studId = nextID++;
        this.studGPA = studGPA;

    }

    @Override
    public void getDescription() {
        System.out.println("Student: " + studId + "\n"
                + getFName() + " " + getLNAme());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studId == student.studId;
    }

}

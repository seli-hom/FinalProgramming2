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
        super();
    }

    public Student(String name, String lName, double studGPA) {
        super(name, lName);
        this.studId = nextID++;
        this.studGPA = studGPA;

    }

    @Override
    public String getDescription() {
        return ("Student: " + studId + "\n"
                + getFName() + " " + getLNAme() + " GPA: " + studGPA);
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

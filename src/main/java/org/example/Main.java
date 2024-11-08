package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws StudNotFoundException {
        System.out.println("Hello world!");

        //Main GUI:
        //Text field
        //Table view
        //Buttons
        //Alert Dialogs

        Student tony = new Student("Tony", "PooPoo",3.1 );
        Student pee = new Student("Tony", "PeePee",2.6 );
        Student poo = new Student("Cacca", "PooPoo",3.0 );
        ArrayList<Student> students;
        students = new ArrayList<Student>();
        students.add(tony);
        students.add(pee);

        StudentManager school = new StudentManager(students);
        school.addStudent(poo);
        school.displayStudents();
        System.out.println("\n \n \n");

        try {
          Student found =  school.searchStudentById(10004);
          if (found == null){
              throw new StudNotFoundException("Student is null.");
          }
            found.getDescription();
        } catch (StudNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
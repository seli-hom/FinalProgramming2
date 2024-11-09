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

        Student tony = new Student("Tony", "Effe",3.1 );
        Student poppy = new Student("Poppy", "Seeds",2.6 );
        Student julie = new Student("Julie", "Plante",3.0 );
        ArrayList<Student> students;
        students = new ArrayList<Student>();
        students.add(tony);
        students.add(poppy);

        StudentManager school = new StudentManager(students);
        school.addStudent(julie);
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

        for (int i = 0; i < school.getStudents().size(); i++){
            school.saveToFile("students.txt", school.getStudents());

        }

        school.loadFromFile("students.txt");
    }
}
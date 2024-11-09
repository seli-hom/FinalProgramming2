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


        // creating user interaction








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

    /**
     * Menu pag eto be displayed for user to make choice
     */
    public static void menuPage(){

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
        System.out.println(" ===========Student Management System===========" );

        System.out.println("1 -> Add student to management system");
        System.out.println("2 -> Remove student from management system" );
        System.out.println("3 -> Load information from file" );
        System.out.println("4 -> Save to text file" );

        System.out.println("         ===========Thank You===========        " );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
    }
}
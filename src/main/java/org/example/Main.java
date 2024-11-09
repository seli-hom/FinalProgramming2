package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws StudNotFoundException {
        Scanner console = new Scanner(System.in);

        //Main GUI:
        //Table view
        //Buttons
        //Alert Dialogs
// premade students to test load and save file methods
        Student tony = new Student("Tony", "Effe",3.1 );
        Student poppy = new Student("Poppy", "Seeds",2.6 );
        Student julie = new Student("Julie", "Plante",3.0 );
        ArrayList<Student> students = new ArrayList<Student>();

        StudentManager school = new StudentManager(students);
        school.addStudent(julie);
        school.displayStudents();
        System.out.println("\n \n \n");


        // creating user interaction
        int choice = 0;

        menuPage();
        while (true){

            switch(choice){
                case 1 -> {
                    console.nextLine();
                    Student studentInput = new Student();
                    System.out.println("Please input student first name: ");
                    studentInput.setFName(console.nextLine());;
                    System.out.println("Please input student last name: ");
                    studentInput.setLNAme(console.nextLine());
                    System.out.println("Please input student GPA: ");
                    studentInput.setStudGPA(console.nextDouble());

                    school.addStudent(studentInput);
                    System.out.println("Student successfully added");
                }
                case 2 -> {
                    console.nextLine();
                    System.out.println("Please write the student Id of the student you wish to remove: ");
                    int idToRemove = console.nextInt();
                    school.removeStudent(idToRemove);
                    System.out.println("Student removed successfully");
                }
                case 3 -> {
                    console.nextLine();
                    System.out.println("Please write the name of the file with '.txt' from which you wish to load from");
                    school.loadFromFile(console.nextLine());
                }
                case 4 ->{
                    console.nextLine();
                    System.out.println("Please write the name of the file with '.txt' in which you wish to save the files");
                    System.out.println("File saved successfully");
                }
            }
            System.out.println("Would you like to perform another action? Yes/No");
            console.nextLine();

            String yesNo = console.nextLine();
            if (!yesNo.equalsIgnoreCase("yes")) {
                System.out.println("Exiting program...");
                break;
            } else {
                menuPage();
                choice = console.nextInt();
                console.nextLine();
            }
        }

//part of added objects and usage of methods for testing
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
package org.example;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@Setter
@Getter
public class StudentManager implements FileHandler{
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<Student>();
    }

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }
    public void displayStudents(){
        for (Student student : students){
            student.getDescription();
        }
    }
    /**
     * Adds Student to the array list of students
     * @param student
     */
    public void addStudent(Student student){
    students.add(student);
    }
    /**
     * Removes student from array list of students, if student is not found
     * the exception will be caught
     * @param studId
     */
    public void removeStudent(int studId) throws StudNotFoundException {
        try {
            Student toBeRemoved = searchStudentById(studId);
            students.remove(toBeRemoved);
        }
        catch (Exception e){
            System.out.println( e.getMessage() +
                    '\n' + "Action cannot be performed...");
        }
    }
    /**
     * Searches for the Student through their studentID
     * @param studId
     * @return the Student corresponding to the id
     */
    public Student searchStudentById(int studId) throws StudNotFoundException {
        return searchStudentById(studId,students.size() -1);
    }

    /**
     * Helper method for recursion. Searches for the student by going through all students and finding a
     * match with the studentId we are searching for, if not found it will throw a StudentNotFound Exception.
     * @param studId student we are looking for
     * @param idx initial idx comparing the studentIds
     * @return Student that matches the studentId input
     */
    private Student searchStudentById(int studId, int idx) throws StudNotFoundException{
        if (idx < 0){
            throw new StudNotFoundException("Student does not exist in the system");
        }
        if (students.get(idx).getStudId() == studId) {
            return students.get(idx);
        }

       return searchStudentById(studId, idx - 1);
    }
@Override
    public void saveToFile(String fileName, ArrayList<Student> students){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (Student student : students){
                    writer.write(student.getDescription() + '\n');
                    writer.close();
                }

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                reader.close();
            }

            System.out.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

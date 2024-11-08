package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class StudentManager {
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
        return searchStudentById(studId,0);
    }

    /**
     * Helper method for recursion. Searches for the student by going through all students and finding a
     * match with the studentId we are searching for, if not found it will throw a StudentNotFound Exception.
     * @param studId student we are looking for
     * @param idx initial idx comparing the studentIds
     * @return Student that matches the studentId input
     */
    private Student searchStudentById(int studId, int idx) throws StudNotFoundException{

            if (students.get(idx).getStudId() == studId) {
                return students.get(idx);
            }
            if (students.size() >= idx){
                throw new StudNotFoundException("Student does not exist in the system");
            }
            searchStudentById(studId, idx + 1);
        return null;
    }
}

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

    /**
     * Adds Student to the array list of students
     * @param student
     */
    public void addStudent(Student student){
    students.add(student);
    }

    /**
     * Removes student from array list of students
     * @param studId
     */
    public void removeStudent(int studId) throws StudNotFoundException {
        Student toBeRemoved = searchStudentById(studId);
        if (toBeRemoved == null){
            System.out.println("Student does not exist in the system" +
                    '\n' + "Action not performed...");
            return;
        }
        students.remove(toBeRemoved);
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
     * Helper method for recursion. Searches for thestudent by going through all students and finding a
     * match with the studentId we are searching for, if not found it will throw a StudentNotFound Exception.
     * @param studId student we are looking for
     * @param idx initial idx comparing the studentIds
     * @return Student that matches the studentId input
     */
    private Student searchStudentById(int studId, int idx) throws StudNotFoundException{
        for (Student student :  students){
            if (student.getStudId() == studId) {
                return student;
            }
            searchStudentById(studId, idx + 1);
        }
        throw new StudNotFoundException();
    }

}

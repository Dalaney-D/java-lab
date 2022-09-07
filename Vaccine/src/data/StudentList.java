/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class StudentList {
    private ArrayList<Student> studentList = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    Student s = new Student();
    
    public void addStudent() {
        String studentID, name, dob, address;
        int pos;
        do {
            studentID = TryCatch.getString("Input ID student: ", "Error");
            pos = searchStudentById(studentID);
            if (pos >= 0)
                System.out.println("The student id already exists. Input another one!");
        } while (pos != -1);
        
        name = TryCatch.getString("Input name student: ", "Error");
        dob = TryCatch.getDob("Input date of birth student with formart dd/MM/yyyy: ", "Error", "^\\d{2}[-|/]\\d{2}[-|/]\\d{4}$");
        address = TryCatch.getString("Input address student: ", "Error");
        studentList.add(new Student(studentID, name, dob, address));
    }
    
    public int searchStudentById(String studentId) {
        
        if (studentList.isEmpty())
            return -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID().equalsIgnoreCase(studentId))
                return i;
        }    
            return -1;
    }
    
    public Student searchStudentObjectById(String studentId) {
        if (studentList.isEmpty())
            return null;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID().equalsIgnoreCase(studentId))
                return studentList.get(i);
        }
        return null;
    }
    
    //Tìm và print student
    public void searchStudentById() {
        String id;
        Student s;
        id = TryCatch.getString("Input student id: ", "Student id is required!");
        s = searchStudentObjectById(id);
        System.out.println("----------------------------");
        if (s == null)
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the student that you want to search");
            s.showProfile();
        }
    }
    
    //In tất cả student
    public void printStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("The list is empty. Nothing to print");
            return;  
        }
        System.out.println("---------------------------------");
        System.out.println("Here is the student list");
        for (Student student : studentList) {
            student.showProfile();
        }
    }
    
    public void updateStudent() {
        if (studentList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }            
        
        int choice;
        String id = TryCatch.getString("Input student id: ", "Student id is required!");
        for (Student student : studentList) {
            if (student.getStudentID().equalsIgnoreCase(id)) { 
                menuUpdate();
                choice= TryCatch.getAnInteger("Input the choice: ", "Error", 1, 4);
                switch(choice) {
                    case 1:
                        student.setName(TryCatch.getString("Input new name: ", "Error"));
                        System.out.println("The student info is updated successfully!");
                        break;
                    case 2:
                        student.setDob(TryCatch.getString("Input new date of birth: ", "Error"));
                        System.out.println("The student info is updated successfully!");
                        break;
                    case 3:
                        student.setAddress(TryCatch.getString("Input new address: ", "Error"));
                        System.out.println("The student info is updated successfully!");
                        break;
                    case 4:
                        student.setName(TryCatch.getString("Input new name: ", "Error"));
                        student.setDob(TryCatch.getString("Input new date of birth: ", "Error"));
                        student.setAddress(TryCatch.getString("Input new address: ", "Error"));
                        System.out.println("The student info is updated successfully!");
                        break;
                }
                return;
            }
        }
        System.out.println("Failed");
    }
    
    public void menuUpdate() {
        System.out.println("Note that the student ID cannot be updated.");
        System.out.println("1. Update name student");
        System.out.println("2. Update date of birth student");
        System.out.println("3. Update address student");
        System.out.println("4. Update name, date of birth, address");
    }
}

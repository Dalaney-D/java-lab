/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import GUI.TryCatch;
import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Student implements Serializable{
    private String studentID;
    private String name;
    private String date;
    private String gender;

    public Student() {
    }

    public Student(String studentID, String name, String date, String gender) {
        this.studentID = studentID;
        this.name = name;
        this.date = date;
        this.gender = gender;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void input() {
        studentID = TryCatch.getString("Input ID student: ", "Error");
        name = TryCatch.getString("Input Name student: ", "Error");
        date = TryCatch.getString("Input Date:", "Error");
        gender = TryCatch.getString("Input gender student: ", "Error");
    }
    
    public void output() {
        System.out.printf("|STUDENT   |%-7s|%-20s|%-10s|%-5s|\n",
                                        studentID, name, date, gender);
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", date=" + date + ", gender=" + gender + '}';
    }
    
    
}

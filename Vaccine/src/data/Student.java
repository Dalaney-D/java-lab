/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Dell
 */
public class Student {
    private String studentID;
    private String name;
    private String dob;
    private String address;

    public Student() {
    }

    public Student(String studentID, String name, String dob, String address) {
        this.studentID = studentID;
        this.name = name;
        this.dob = dob;
        this.address = address;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void showProfile() {
        System.out.printf("|%8s|%-25S|%11s|%100s|\n", studentID, name, dob, address );
    }
    
}

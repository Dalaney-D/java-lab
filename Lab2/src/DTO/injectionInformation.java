/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GUI.Data;
import GUI.TryCatch;
import DTO.Student;
import DTO.Vaccine;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class injectionInformation implements Serializable{
    
    private String injectionId;
    private String firstInformationDate;
    private String secondInformationDate;
    private String firstInformationPlace;
    private String secondInformationPlace;
    private Student student;
    private Vaccine vaccine;

    public injectionInformation() {
    }

    public injectionInformation(String firstInformationDate, String secondInformationDate, String firstInformationPlace, String secondInformationPlace, Student student, Vaccine vaccine) {
        this.firstInformationDate = firstInformationDate;
        this.secondInformationDate = secondInformationDate;
        this.firstInformationPlace = firstInformationPlace;
        this.secondInformationPlace = secondInformationPlace;
        this.student = student;
        this.vaccine = vaccine;
    }

    public String getInjectionId() {
        return injectionId;
    }

    public void setInjectionId(String injectionId) {
        this.injectionId = injectionId;
    }

    public String getFirstInformationDate() {
        return firstInformationDate;
    }

    public void setFirstInformationDate(String firstInformationDate) {
        this.firstInformationDate = firstInformationDate;
    }

    public String getSecondInformationDate() {
        return secondInformationDate;
    }

    public void setSecondInformationDate(String secondInformationDate) {
        this.secondInformationDate = secondInformationDate;
    }

    public String getFirstInformationPlace() {
        return firstInformationPlace;
    }

    public void setFirstInformationPlace(String firstInformationPlace) {
        this.firstInformationPlace = firstInformationPlace;
    }

    public String getSecondInformationPlace() {
        return secondInformationPlace;
    }

    public void setSecondInformationPlace(String secondInformationPlace) {
        this.secondInformationPlace = secondInformationPlace;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public void input() {
        injectionId = TryCatch.getString("ID injection: ", "Error");
        firstInformationDate = TryCatch.getString("Nhập ngày: ", "Error");
        //secondInformationDate = TryCatch.getString("Date: ", "Error");
        firstInformationPlace = TryCatch.getString("Address: ", "Error");
        //secondInformationPlace = TryCatch.getString("Address: ", "Error");
    }

    public void output() {
        System.out.println("---Information---");
        student.output();
        vaccine.output();
        System.out.println("Id injection: " + injectionId);
        System.out.println("Day 1 injection: " + firstInformationDate);
        System.out.println("Day 2 injection: " + secondInformationDate);
        System.out.println("Address for 1st injection: " + firstInformationPlace);
        System.out.println("Address for 2st injection: " + secondInformationPlace);
    }

    @Override
    public String toString() {
        return "injectionInformation{" + "injectionId=" + injectionId + ", firstInformationDate=" + firstInformationDate + ", secondInformationDate=" + secondInformationDate + ", firstInformationPlace=" + firstInformationPlace + ", secondInformationPlace=" + secondInformationPlace + ", student=" + student + ", vaccine=" + vaccine + '}';
    }
    
    
}

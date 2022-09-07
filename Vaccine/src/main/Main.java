/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.StudentList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Main {

    public static void main(String[] args) {
        StudentList sl = new StudentList();
        sl.addStudent();
        sl.updateStudent();
        sl.printStudentList();
        
    }
}

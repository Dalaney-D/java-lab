/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GUI.Data;
import GUI.TryCatch;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class StudentList {

    ArrayList<Student> listS = new ArrayList<>();

    public void add(Student student) {
        listS.add(student);
    }

    public void seach() {
        boolean find = false;
        String id = TryCatch.getString("Enter the id you want seach: ", "Error");
        for (Student student : listS) {
            if (student.getStudentID().equalsIgnoreCase(id)) {
                student.output();
                find = true;
            }
        }
        if (find == false) {
            System.out.println("Not found");
        }
    }

//    public void writeFile() {
//        try {
//            FileOutputStream f = new FileOutputStream("D:\\---Kì 3---\\LAB\\Lab2\\Student.txt");
//            ObjectOutputStream of = new ObjectOutputStream(f);
//            for (int i = 0; i < listS.size(); i++) {
//                of.writeObject(listS.get(i));
//            }
//            of.close();
//            f.close();
//        } catch (IOException e) {
//            System.out.println("Error!! Can't save!!");
//        }
//    }
    
    public void writeFile() {
        String fileStudent = "D:\\---Kì 3---\\LAB\\Lab2\\Student.txt";
        Data.writeBinaryStudent(fileStudent, listS);
    }
}
    

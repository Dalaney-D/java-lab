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
public class VaccineList {
    ArrayList<Vaccine> listV = new ArrayList<>();
    
    public void add(Vaccine vaccine) {
        listV.add(vaccine);
    }
    
    public void seach() {
        String id = TryCatch.getString("Input id: ", "Error");
        for (Vaccine vaccine : listV) {
            if (vaccine.getVaccineID().equals(id)) {
                vaccine.output();
            }
        }
    }
    
    public void writeFile() {
        String fileVaccine = "D:\\---Kì 3---\\LAB\\Lab2\\Vaccine.txt";
        Data.writeBinaryVaccine(fileVaccine, listV);
    }
}

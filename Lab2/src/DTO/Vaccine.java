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
public class Vaccine implements Serializable{
    String vaccineID;
    String type;

    public Vaccine() {
    }

    public Vaccine(String vaccineID, String type) {
        this.vaccineID = vaccineID;
        this.type = type;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void input() {
        vaccineID = TryCatch.getString("Input ID vaccine: ", "Error");
        type = TryCatch.getString("Input type vaccine: ", "Error");
    }
    
    public void output() {
        System.out.printf("|VACCINE   |%-7s|%-10s|\n",
                            vaccineID, type);
    }

    @Override
    public String toString() {
        return "Vaccine{" + "vaccineID=" + vaccineID + ", type=" + type + '}';
    }
    
    
}

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
public class Injection {
    private String injectionID;
    private String firstInjectionPlace;
    private String secondInjectionPlace;
    private String firstInjectionDate;
    private String secondInjectionDate;

    public Injection() {
    }

    public Injection(String injectionID, String firstInjectionPlace, String secondInjectionPlace, String firstInjectionDate, String secondInjectionDate) {
        this.injectionID = injectionID;
        this.firstInjectionPlace = firstInjectionPlace;
        this.secondInjectionPlace = secondInjectionPlace;
        this.firstInjectionDate = firstInjectionDate;
        this.secondInjectionDate = secondInjectionDate;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public String getFirstInjectionPlace() {
        return firstInjectionPlace;
    }

    public void setFirstInjectionPlace(String firstInjectionPlace) {
        this.firstInjectionPlace = firstInjectionPlace;
    }

    public String getSecondInjectionPlace() {
        return secondInjectionPlace;
    }

    public void setSecondInjectionPlace(String secondInjectionPlace) {
        this.secondInjectionPlace = secondInjectionPlace;
    }

    public String getFirstInjectionDate() {
        return firstInjectionDate;
    }

    public void setFirstInjectionDate(String firstInjectionDate) {
        this.firstInjectionDate = firstInjectionDate;
    }

    public String getSecondInjectionDate() {
        return secondInjectionDate;
    }

    public void setSecondInjectionDate(String secondInjectionDate) {
        this.secondInjectionDate = secondInjectionDate;
    }
    
    
}

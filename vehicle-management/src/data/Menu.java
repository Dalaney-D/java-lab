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
public class Menu {

    public void menuMain() {
        System.out.println("");
        System.out.println("------------Menu------------");
        System.out.println("Welcome to vehicle management program.");
        System.out.println("Choose the following functions to play with.");
        System.out.println("1. Load data from file");
        System.out.println("2. Add new vehicle");
        System.out.println("3. Update vehicle by ID");
        System.out.println("4. Delete vehicle");
        System.out.println("5. Search vehicle");
        System.out.println("6. Show vehicle list");
        System.out.println("7. Store date to file");
        System.out.println("8. Quit");
        System.out.println("------------------------");
    }

    public void addVehicle() {
        System.out.println("");
        System.out.println("1. Add new car");
        System.out.println("2. Add new motorbike");
        System.out.println("3. Quit");
    }

    public void deleteVehicle() {
        System.out.println("1. Delete vehicle by ID");
        System.out.println("2. Delete all vehicle");
        System.out.println("3. Quit");
    }

    public void subMenuSearch() {
        System.out.println("");
        System.out.println("1. Search by name");
        System.out.println("2. Search by ID");
        System.out.println("3. Quit");
    }

    public void subMenuShow() {
        System.out.println("");
        System.out.println("1. Show all");
        System.out.println("2. Show all (descending by price)");
        System.out.println("3. Quit");
    }
}

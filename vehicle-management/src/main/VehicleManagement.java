/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.FileVehicle;
import data.VehicleList;
import data.Menu;
import data.TryCatch;
import java.util.List;

/**
 *
 * @author Dell
 */
public class VehicleManagement {

    public static void main(String[] args) {
        VehicleList cabinet = new VehicleList();
        Menu menu = new Menu();
        cabinet.loadData();
        boolean save = false;
        int choice;
        do {
            menu.menuMain();
            choice = TryCatch.getAnInteger("Enter your choice from 1->8: ", "Please enter your choice from 1->8: ", 1, 8);  
            
            switch (choice) {
                case 1:
                    List<String> listLine = FileVehicle.readFile();
                    if (listLine.isEmpty()) {
                        System.out.println("Vehicle does not exist");
                    } else {
                        for (int i = 0; i < listLine.size(); i++)
                            System.out.println(listLine.get(i));
                    }
                        break;
                case 2:
                    save = false;
                    int choice2;
                    do {
                        menu.addVehicle();
                        choice2 = TryCatch.getAnInteger("Enter your choice from 1->3: ", "Please enter your choice from 1->3: ", 1, 3);
                        switch (choice2) {
                            case 1:
                                cabinet.addNewCar();
                                break;
                            case 2:
                                cabinet.addNewMotorbike();
                                break;
                            case 3:
                                System.out.println("Quit");
                                break;
                        }
                    } while (choice2 != 3);
                    break;
                case 3:
                    save = false;
                    cabinet.updateVehicle();
                    break;
                case 4:
                    save = false;
                    int choice3;
                    do {                        
                        menu.deleteVehicle();
                        choice3 = TryCatch.getAnInteger("Enter your choice from 1->3: ", "Please enter your choice from 1->3: ", 1, 3);
                        switch (choice3) {
                            case 1:
                                cabinet.deleteVehicle();
                                break;
                            case 2:
                                cabinet.deleteAllVehicle();
                                break;
                            case 3:
                                System.out.println("Quit");
                                break;
                        }
                    } while (choice3 != 3);                
                    break;
                case 5:
                    cabinet.searchVehicleByName();
                    break;
                case 6:
                    int choice6;
                    do {
                        menu.subMenuShow();
                        choice6 = TryCatch.getAnInteger("Enter your choice from 1->3: ", "Please enter your choice from 1->3: ", 1, 3);
                        switch (choice6) {
                            case 1:
                                cabinet.showAllVehicle();
                                break;
                            case 2:
                                cabinet.showAllVehicleDescendingByPrice();
                                break;
                            case 3:
                                System.out.println("Quit");
                                break;
                        }
                    } while (choice6 != 3);
                    break;
                case 7:
                    save = true;
                    cabinet.storeData();
                    break;
                case 8:
                    if (save == false) {
                        String confirm = TryCatch.getString("Do you want to save change? ", "Save / Don't save");
                        if (confirm.equalsIgnoreCase("Save")) {
                            cabinet.storeData();
                            System.out.println("Bye-Bye");
                            break;
                        }
                    }
                    System.out.println("Bye-Bye");
            }
        } while (choice != 8);
    }
}

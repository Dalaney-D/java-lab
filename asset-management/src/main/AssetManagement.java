/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.Asset;
import data.AssetList;
import data.Borrow;
import data.BorrowList;
import data.BorrowRequest;
import data.BorrowRequestList;
import data.EmployeeList;
import data.Menu;
import data.TryCatch;

/**
 *
 * @author Dell
 */
public class AssetManagement {

    public static void main(String[] args) {
        EmployeeList employee = new EmployeeList();
        AssetList asset = new AssetList();
        BorrowRequestList request = new BorrowRequestList();
        BorrowList borrow = new BorrowList();
        Menu menu = new Menu();

        asset.readFile();
        employee.readFile();
        request.readFile();
        borrow.readFile();
        int ask = 0;
        int choice;
        do {
            menu.Login();
	//check quyền truy cập
            choice = TryCatch.getAnInteger("Enter your choice from 1->3: ", "Please enter your choice from 1->3", 1, 3);
            switch (choice) {
                case 1:
                    asset.searchAssetByName();
                    break;
                case 2:
                    String login = employee.checkLogin();
                    if (login == null) {
                        System.out.println("Incorrect id or password.");
                    } else {
                        System.out.println("Successfully.");
                        if (login.equals("MA")) {
                            do {
                                menu.menuMain();
                                choice = TryCatch.getAnInteger("Enter your choice from 2->7: ", "Please enter your choice from 2->7", 2, 7);
                                switch (choice) {
                                    case 2:
                                        asset.searchAssetByName();
                                        break;
                                    case 3:
                                        do {
                                            asset.showList();
                                            asset.addNewAsset();
                                            ask = TryCatch.getAnInteger("Do you want to continue?(1/0)", "Error", 0, 1);
                                        } while (ask == 1);
                                        break;
                                    case 4:
                                        asset.updateAsset();
                                        break;
                                    case 5:
                                        request.showList();
                                        String id = TryCatch.getString("Input requestID of your choice: ", "Id is required!");
                                        BorrowRequest r = request.searchRequest(id);
                                        if (r == null) {
                                            System.out.println("Not request!");
                                        } else {
                                            if (r.getQuantity() <= (asset.searchAsset(r.getAssetID()).getQuantity())) {
                                                //insert into borrow
                                                borrow.addNewBorrow(r.getAssetID(), r.getEmployeeID(), r.getQuantity());
                                                //remove data
                                                request.removeRequest(r);
                                                //update quantity asset
                                                int quantity = asset.searchAsset(r.getAssetID()).getQuantity() - r.getQuantity();
                                                asset.searchAsset(r.getAssetID()).setQuantity(quantity);
                                                asset.writeFile();
                                                System.out.println("Successfully.");
                                            } else {
                                                System.out.println("Not enough assets.");
                                            }
                                        }
                                        break;
                                    case 6:
                                        borrow.showList();
                                        break;
                                    case 7:
                                        break;
                                }
                            } while (choice != 7);
                        } else {
                            do {
                                menu.menuEmployee();
                                choice = TryCatch.getAnInteger("Enter your choice from 2->6: ", "Please enter your choice from 2->7", 2, 6);
                                switch(choice) {
                                    case 2:
                                        asset.searchAssetByName();
                                        break;
                                    case 3:
                                        asset.showList();
                                        do {  
                                            String employeeID, assetID;
                                            int quantity;
                                            employeeID = login;
                                            assetID = TryCatch.getString("Input assetID: ", "The assetID quantity is required!");
                                            quantity = TryCatch.getAnInteger("Input quantity Asset: ", "The Asset quantity is required!", 0, Integer.MAX_VALUE);
                                            
                                            Asset a = asset.searchAsset(assetID);
                                            if (a == null) {
                                                System.out.println("There is no asset you want to borrow.");
                                            } else {
                                                request.addNewBorrow(assetID, employeeID, quantity);
                                            }
                                            ask = TryCatch.getAnInteger("Do you want to continue?(1/0)", "Error", 0, 1);
                                        } while (ask == 1);
                                        break;
                                    case 4:
                                        do {
                                            request.showList(login);
                                            String rID = TryCatch.getString("Input ressetID: ", "The ressetID quantity is required!");
                                            String confirm = TryCatch.getString("Are you sure? (Yes/No): ", "Yes or No");
                                            if (confirm.equalsIgnoreCase("Yes")) {
                                                BorrowRequest b = request.searchRequest(rID);
                                                if (b == null)
                                                    System.out.println("Delete fail!");
                                                else {
                                                    request.removeRequest(b);
                                                    System.out.println("Successfully.");
                                                }
                                            } else
                                                System.out.println("The selected is removed fail!");
                                            ask = TryCatch.getAnInteger("Do you want to continue?(1/0)", "Error", 0, 1);
                                        } while (ask == 1);                                                                            
                                        break;
                                    case 5:
                                        do {
                                            borrow.showList(login);
                                            String borrowID = TryCatch.getString("Input borrowID: ", "The borrowID quantity is required!");
                                            String confirm = TryCatch.getString("Are you sure? (Yes/No): ", "Yes or No");
                                            if (confirm.equalsIgnoreCase("Yes")) {
                                                Borrow b = borrow.searchBorrow(borrowID);
                                                if (b == null)
                                                    System.out.println("Delete fail!");
                                                else {
                                                    borrow.removeBorrow(b);
                                                    int quantity = asset.searchAsset(b.getAssetID()).getQuantity() + b.getQuantity();
                                                    asset.searchAsset(b.getAssetID()).setQuantity(quantity);
                                                    asset.writeFile();
                                                    System.out.println("Successfully.");
                                                }
                                            } else
                                                System.out.println("The selected is removed fail!");
                                            ask = TryCatch.getAnInteger("Do you want to continue?(1/0)", "Error", 0, 1);
                                        } while (ask == 1);      
                                        break;
                                    case 6:
                                        break;
                                }
                            } while (choice !=6);                           
                        }   
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the program.");
                    break;
            }
        } while (choice != 3);

    }
}

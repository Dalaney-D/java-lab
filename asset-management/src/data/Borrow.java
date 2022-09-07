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
public class Borrow {
    private String bID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private String borrowDateTime;

    public Borrow() {
    }

    public Borrow(String bID, String assetID, String employeeID, int quantity, String borrowDateTime) {
        this.bID = bID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDateTime = borrowDateTime;
    }

    public String getbID() {
        return bID;
    }

    public String getAssetID() {
        return assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBorrowDateTime() {
        return borrowDateTime;
    }

    public void setBorrowDateTime(String borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }
    
    public void printBorrow() {
        System.out.printf("|%-10s|%5s|%5s|%10s|%3d|%20s|\n",
                            "Borrow", bID ,assetID, employeeID, quantity, borrowDateTime);
    }
}

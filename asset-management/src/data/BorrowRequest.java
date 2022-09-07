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
public class BorrowRequest {
    private String rID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private String requestDateTime;

    public BorrowRequest() {
    }

    public BorrowRequest(String rID, String assetID, String employeeID, int quantity, String requestDateTime) {
        this.rID = rID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }

    public String getrID() {
        return rID;
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

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }
    
    public void printRequest() {
        System.out.printf("|%-10s|%5s|%5s|%10s|%3d|%20s|\n",
                                "Request", rID, assetID, employeeID, quantity, requestDateTime);
    }
}

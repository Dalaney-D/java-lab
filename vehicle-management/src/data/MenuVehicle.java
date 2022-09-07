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
public interface MenuVehicle {
    public void addNewCar();
    public void addNewMotorbike();
    public void updateVehicle();
    public void deleteVehicle();
    public void searchVehicleByName();
    public void showAllVehicle();
    public void showAllVehicleDescendingByPrice();
    public int searchVehicleByID(String id);
}

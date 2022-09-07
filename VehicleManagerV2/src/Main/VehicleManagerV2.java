package Main;

import Data.VehicleList;

/**
 *
 * @author duyng
 */
public class VehicleManagerV2 {
    public static void main(String[] args) {
        VehicleList vehicle = new VehicleList();
        vehicle.addNewVehicle();
        vehicle.addNewVehicle();
        vehicle.addNewVehicle();
        vehicle.updateVehicle();
        vehicle.deleteVehicle();
        vehicle.searchVehicleByName();
        vehicle.searchVehicleByID();
        vehicle.showAll();
        vehicle.showPrice();
    }
}


package Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author duyng
 */
public class VehicleList {
    private ArrayList<Vehicle> vehicleList = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    Motorbike moto = new Motorbike();
    String id, name, color, brand, type, license;
    int price, yom, speed;
    
    //Lấy năm hiện tại
    LocalDateTime localDate = LocalDateTime.now();
    int year = localDate.getYear();
    
    //2. add new vehicle
    public void addNewVehicle() {
        int tmp;
        do {
            id = TryCatch.getID("\nInput Vehicle ID:\n"
                    + "Car ID is (CXXXXX)\n"
                    + "Motorbike ID is (MXXXXX)", "The format of Vehicle ID is (CXXXXX) or (MXXXXX)", "^[C|c]\\d{5}|^[M|m]\\d{5}");
            tmp = searchVehicleByID(id);
            if (tmp >= 0)
                System.out.println("The Vehicle ID already exists.");
        } while (tmp != -1);

        if (id.startsWith("C")) {
            name = TryCatch.getString("Input car name: ", "The car name is required!");
            color = TryCatch.getStringColor("Input car color (Blue, Green, Red): ", "The car color is required!").toUpperCase();
            price = TryCatch.getAnInteger("Input car price($): ", "The car price is required!", 0, Integer.MAX_VALUE);
            brand = TryCatch.getString("Input car brand: ", "The car brand is required!").toUpperCase();
            type = TryCatch.getStringType("Input car type (sport, travel, common): ", "The car type is required!");
            yom = TryCatch.getAnInteger("Input car year of manufacture (1885->" + year + "): ", "The car year of manufacture is from (1885->" + year + "): ", 1885, year);
            vehicleList.add(new Car(id, name, color, price, brand, type, yom));
            System.out.println("A car profile is added sucessfully");
        } else {
            name = TryCatch.getString("Input motorbike name: ", "The motorbike name is required!");
            color = TryCatch.getStringColor("Input motorbike color (Blue, Green, Red): ", "The motorbike color is required!").toUpperCase();
            price = TryCatch.getAnInteger("Input motorbike price($): ", "The motorbike price is required!", 0, Integer.MAX_VALUE);
            brand = TryCatch.getString("Input motorbike brand: ", "The motorbike brand is required!").toUpperCase();
            speed = TryCatch.getAnInteger("Input motorbike speed(0->500): ", "The motorbike speed form(0->500)", 0, 500);
            license = TryCatch.getString("Input motorbike license(Yes/No): ", "The motorbike license is required!");
            vehicleList.add(new Motorbike(id, name, color, price, brand, speed, license));
            System.out.println("A motorbike profile is added sucessfully");
        }
    }
  
    //3. Update vehicle by ID
    public void updateVehicle() {
        id = TryCatch.getID("Input id vehicle CXXXXX(car) or MXXXXX(motorbike): ", "The format of id is CXXXXX(car) or MXXXXX(motorbike): ", "^[C|c]\\d{5}|^[M|m]\\d{5}");
        int tmp = searchVehicleByID(id);
        if (tmp == -1) {
            System.out.println("Vehicle does not exist");
        } else {
            System.out.println("");
            System.out.println("Here is the vehicle before updating");
            vehicleList.get(tmp).showProfile();
            
            name = TryCatch.getString("Input new name: ");
            if (name.equals("")) {
                vehicleList.get(tmp).setName(vehicleList.get(tmp).getName());
            } else {
                vehicleList.get(tmp).setName(name);
            }
            
            while (true) {
                color = TryCatch.getString("Input new color (Blue, Green, Red): ");
                if (color.equalsIgnoreCase("Red") || color.equalsIgnoreCase("Blue") || color.equalsIgnoreCase("Green")) {
                    vehicleList.get(tmp).setColor(color);
                    break;
                } else if (color.equals("")) {
                    vehicleList.get(tmp).setColor(vehicleList.get(tmp).getColor());
                    break;
                }
            }
            
            while (true) {
                String s = TryCatch.getString("Input new price($): ");
                if (s.equals("")) {
                    vehicleList.get(tmp).setPrice(vehicleList.get(tmp).getPrice());
                    break;
                } else if ((price = Integer.parseInt(s)) > 0 && (price = Integer.parseInt(s)) <= Integer.MAX_VALUE) {
                    vehicleList.get(tmp).setPrice(price);
                    break;
                }
            }

            brand = TryCatch.getString("Input new brand: ");
            if (brand.equals(""))
                vehicleList.get(tmp).setBrand(vehicleList.get(tmp).getBrand());
            else
                vehicleList.get(tmp).setBrand(brand);
            
            if (id.startsWith("C")) {
                Car car = (Car) searchVehicle(id); //lên mạng xem thêm về ép kiểu nha
                while (true) {
                    type = TryCatch.getString("Input new type (sport, travel, common): ");
                    if (type.equalsIgnoreCase("sport") || type.equalsIgnoreCase("travel") || type.equalsIgnoreCase("common")) {
                        car.setType(type);
                        break;
                    } else if (type.equals("")) {
                        car.setType(car.getType());
                        break;
                    }
                }

                while (true) {
                    String yearm = TryCatch.getString("Input new year of manufacture (1885->" + year + "): ");
                    if ((yom = Integer.parseInt(yearm)) > 1885 && (yom = Integer.parseInt(yearm)) <= year) {
                        car.setYom(yom);
                        break;
                    } else if (yearm.equalsIgnoreCase("")) {
                        car.setYom(car.getYom());
                        break;
                    }
                }
                System.out.println("Here is the Car after updating");
                vehicleList.get(tmp).showProfile();
                
            } else {
                Motorbike moto = (Motorbike) searchVehicle(id);
                while (true) {
                    String km = TryCatch.getString("Input new speed (5->500): ");
                    if (km.equals("")) {
                        moto.setSpeed(moto.getSpeed());
                        break;
                    } else if ((speed = Integer.parseInt(km)) > 0 && (speed = Integer.parseInt(km)) <= 500) {
                        moto.setSpeed(speed);
                        break;
                    }
                }

                while (true) {
                    license = TryCatch.getString("Input new license (Yes/No): ");
                    if (license.equals("")) {
                        moto.setLicense(moto.getLicense());
                        break;
                    } else if (license.equalsIgnoreCase("yes") || (license.equalsIgnoreCase("no"))) {
                        moto.setLicense(license);
                        break;
                    }
                }
                System.out.println("Here is the Motorbike after updating");
                vehicleList.get(tmp).showProfile();
            }
        }
    }    
    
    //4.Delete
    public void deleteVehicle() {
        id = TryCatch.getID("Input id vehicle(car or motorbike): ", "The format of id is CXXXXX(car) or MXXXXX(motorbike): ", "^[C|c]\\d{5}|^[M|m]\\d{5}");
        int tmp = searchVehicleByID(id);
        
        if (tmp == -1) 
            System.out.println("Not Found");
        else {
            String cofirm = TryCatch.getString("Are you sure? (Yes/No): ", "Yes Or No.");
            if (cofirm.equalsIgnoreCase("Yes")) {
                vehicleList.remove(tmp);
                System.out.println("The selected vehicle is removed successfully.");
            } else 
                System.out.println("The selected is remove fail.");
        }
    }
    
    //5.Search 
    public void searchVehicleByName() {
        name = TryCatch.getString("Enter the name of the vehicle you want to find (car or motorbike): ", "Please enter the name of the place you want to find (car or motorbike)");
        boolean tmp = false;
        Collections.sort(vehicleList, Collections.reverseOrder());
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getName().contains(name)) {
                vehicleList.get(i).showProfile();
                tmp = true;
            }
        }
        if (tmp == false)
            System.out.println("Not Found.");
    }
    
    public void searchVehicleByID() {
        id = TryCatch.getID("Input id vehicle(car or motorbike): ", "The format of id is CXXXXX(car) or MXXXXX(motorbike): ", "^[C|c]\\d{5}|^[M|m]\\d{5}");
        int tmp = searchVehicleByID(id);
        if (tmp == -1)
            System.out.println("Not Found.");
        else 
            vehicleList.get(tmp).showProfile();
    }
    
    //6.Show vehicle
    public void showAll() {
        for (int i = 0; i < vehicleList.size(); i++) {
            vehicleList.get(i).showProfile();
        }
    }
    
    public void showPrice() {
        if (vehicleList.isEmpty()) 
            System.out.println("Vehicle does not exist.");
        else {
            Collections.sort(vehicleList, new Car());
            Collections.sort(vehicleList, new Motorbike());
            for (int i = 0; i < vehicleList.size(); i++) {
                vehicleList.get(i).showProfile();
                if (vehicleList.get(i).getId().startsWith("M"))
                    moto.makeSound();
            }
        }
    }
    
    
    
    public Vehicle searchVehicle(String id) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if(vehicleList.get(i).getId().equals(id))
                return vehicleList.get(i);   
        }
        return null;
    }
    
    public int searchVehicleByID(String id) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
    
    
}

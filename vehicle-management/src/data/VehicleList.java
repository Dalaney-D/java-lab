/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class VehicleList implements MenuVehicle {

    //Menu menu = new Menu();
    private ArrayList<Car> carList = new ArrayList();
    private ArrayList<Motorbike> motorbikeList = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    
    //Lấy năm hiện tại
    LocalDateTime localDate = LocalDateTime.now();
    int year = localDate.getYear();

    //1.Load data from file
    public void loadData() {
        List<String> listLine = FileVehicle.readFile();
        if (listLine.isEmpty())
            System.out.println("Vehicle does not exist");
        else {
            for (int i = 0; i < listLine.size(); i++) {
                String[] lineSplit = listLine.get(i).split(", ");
                if (lineSplit[0].startsWith("C"))
                    carList.add(new Car(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]), lineSplit[4], lineSplit[5], Integer.parseInt(lineSplit[6])));
                else
                    motorbikeList.add(new Motorbike(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]), lineSplit[4], Integer.parseInt(lineSplit[5]), lineSplit[6]));
            }
        }
    }
    
    //2. add new vehicle
    @Override
    public void addNewCar() { 
        String id, name, color, brand, type;
        int price, yom;
        int tmp;
        do {
            id = TryCatch.getID("Input car id (CXXXXX): ", "The format of id is CXXXXX (X stands for a digit)", "^[C|c]\\d{5}");
            tmp = searchVehicleByID(id);
            if (tmp >= 0)
                System.out.println("The car id already exists."); 
        } while (tmp != -1);

        name = TryCatch.getString("Input car name: ", "The car name is required!");
        color = TryCatch.getStringColor("Input car color (Blue, Green, Red): ", "The car color is required!").toUpperCase();
        price = TryCatch.getAnInteger("Input car price($): ", "The car price is required!", 0, Integer.MAX_VALUE);
        brand = TryCatch.getString("Input car brand: ", "The car brand is required!").toUpperCase();
        type = TryCatch.getStringType("Input car type (sport, travel, common): ", "The car type is required!");
        yom = TryCatch.getAnInteger("Input car year of manufacture (1885->" + year + "): ", "The car year of manufacture is from (1885->" + year + "): ", 1885, year);
        carList.add(new Car(id, name, color, price, brand, type, yom));
        System.out.println("A car profile is added sucessfully");
    }
    
    @Override
    public void addNewMotorbike() {
        String id, name, color, brand, type, license;
        int price, speed;
        int tmp;
        String confirm;
        do {
            id = TryCatch.getID("Input motorbike id (MXXXXX): ", "The format of id is MXXXXX (X stands for a digit)", "^[M|m]\\d{5}");
            tmp = searchVehicleByID(id);
            if (tmp >= 0)
                System.out.println("The motorbike id already exists.");
        } while (tmp != -1);
        name = TryCatch.getString("Input motorbike name: ", "The motorbike name is required!");
        color = TryCatch.getStringColor("Input motorbike color (Blue, Green, Red): ", "The motorbike color is required!").toUpperCase();
        price = TryCatch.getAnInteger("Input motorbike price($): ", "The motorbike price is required!", 0, Integer.MAX_VALUE);
        brand = TryCatch.getString("Input motorbike brand: ", "The motorbike brand is required!").toUpperCase();
        speed = TryCatch.getAnInteger("Input motorbike speed(0->500): ", "The motorbike speed form(0->500)", 0, 500);
        license = TryCatch.getString("Input motorbike license(Yes/No)): ", "The motorbike license is required!");
        motorbikeList.add(new Motorbike(id, name, color, price, brand, speed, license));
        System.out.println("A motorbike profile is added sucessfully");
    }

    //4. Update vehicle by id
    @Override
    public void updateVehicle() {
        String id, name, color, brand, type, license;
        String tmp;
        int price, speed, yom;
        id = TryCatch.getID("Input id vehicle CXXXXX(car) or MXXXXX(motorbike): ", "The format of id is CXXXXX(car) or MXXXXX(motorbike): ", "^[C|c]\\d{5}|^[M|m]\\d{5}");    
        
        if (id.startsWith("C")) {
            tmp = searchVehicleByID2(id);
            if (tmp == null)
                System.out.println("Vehicle does not exist");
            else {
                for (int i = 0; i < carList.size(); i++) {
                    if (carList.get(i).getId().equalsIgnoreCase(tmp)) {
                        System.out.println("");
                        System.out.println("Here is the car before updating");
                        carList.get(i).showProfile();

                        name = TryCatch.getString("Input new name: ");
                        if (name.equals(""))
                            carList.get(i).setName(carList.get(i).getName());
                        else
                            carList.get(i).setName(name);

                        while (true) {
                            color = TryCatch.getString("Input car color (Blue, Green, Red): ");
                            if (color.equalsIgnoreCase("Red") || color.equalsIgnoreCase("Blue") || color.equalsIgnoreCase("Green")) {
                                carList.get(i).setColor(color);
                                break;
                            } else if (color.equals("")) {
                                carList.get(i).setColor(carList.get(i).getColor());
                                break;
                            }
                        }

                        while (true) {
                            String s = TryCatch.getString("Input car price($): ");
                            if (s.equals("")) {
                                carList.get(i).setPrice(carList.get(i).getPrice());
                                break;
                            } else if ((price = Integer.parseInt(s)) > 0 && (price = Integer.parseInt(s)) <= Integer.MAX_VALUE) {
                                carList.get(i).setPrice(price);
                                break;
                            }
                        }

                        brand = TryCatch.getString("Input new brand: ");
                        if (brand.equals(""))
                            carList.get(i).setBrand(carList.get(i).getBrand());
                        else
                            carList.get(i).setBrand(brand);

                        while (true) {
                            type = TryCatch.getString("Input new type (sport, travel, common): ");
                            if (type.equalsIgnoreCase("sport") || type.equalsIgnoreCase("travel") || type.equalsIgnoreCase("common")) {
                                carList.get(i).setType(type);
                                break;
                            } else if (type.equals("")) {
                                carList.get(i).setType(carList.get(i).getType());
                                break;
                            }
                        }

                        while (true) {
                            String yearm = TryCatch.getString("Input new year of manufacture (1885->" + year + "): ");
                            if (yearm.equalsIgnoreCase("")) {
                                carList.get(i).setYom(carList.get(i).getYom());
                                break;
                            } else if ((yom = Integer.parseInt(yearm)) > 1885 && (yom = Integer.parseInt(yearm)) <= year) {
                                carList.get(i).setYom(yom);
                                break;
                            }
                        }
                        System.out.println("Here is the Car after updating");
                        carList.get(i).showProfile();
                    }
                }
            }    
                
        } else {
            tmp = searchVehicleByID2(id);
            if (tmp == null)
                System.out.println("Vehicle does not exist");
            else {
                for (int i = 0; i < motorbikeList.size(); i++) {
                    if (motorbikeList.get(i).getId().equalsIgnoreCase(tmp)) {
                        System.out.println("");
                        System.out.println("Here is the motorbike before updating");
                        motorbikeList.get(i).showProfile();

                        name = TryCatch.getString("Input new name: ");
                        if (name.equals(""))
                            motorbikeList.get(i).setName(motorbikeList.get(i).getName());
                        else
                            motorbikeList.get(i).setName(name);

                        while (true) {
                            color = TryCatch.getString("Input motor color (Blue, Green, Red): ");
                            if (color.equalsIgnoreCase("Red") || color.equalsIgnoreCase("Blue") || color.equalsIgnoreCase("Green")) {
                                motorbikeList.get(i).setColor(color);
                                break;
                            } else if (color.equals("")) {
                                motorbikeList.get(i).setColor(motorbikeList.get(i).getColor());
                                break;
                            }
                        }

                        while (true) {
                            String s = TryCatch.getString("Input motorbike price($): ");
                            if (s.equals("")) {
                                motorbikeList.get(i).setPrice(motorbikeList.get(i).getPrice());
                                break;
                            } else if ((price = Integer.parseInt(s)) > 0 && (price = Integer.parseInt(s)) <= Integer.MAX_VALUE) {
                                motorbikeList.get(i).setPrice(price);
                                break;
                            }
                        }

                        brand = TryCatch.getString("Input new brand: ");
                        if (brand.equals(""))
                            motorbikeList.get(i).setBrand(motorbikeList.get(i).getBrand());
                        else
                            motorbikeList.get(i).setBrand(brand);

                        while (true) {
                            String km = TryCatch.getString("Input new speed (5->500): ");
                            if (km.equals("")) {
                                motorbikeList.get(i).setSpeed(motorbikeList.get(i).getSpeed());
                                break;
                            } else if ((speed = Integer.parseInt(km)) > 0 && (speed = Integer.parseInt(km)) <= 500) {
                                motorbikeList.get(i).setSpeed(speed);
                                break;
                            }
                        }

                        while (true) {
                            license = TryCatch.getString("Input new license (Yes/No): ");
                            if (license.equals("")) {
                                motorbikeList.get(i).setLicense(motorbikeList.get(i).getLicense());
                                break;
                            } else if (license.equalsIgnoreCase("yes") || (license.equalsIgnoreCase("no"))) {
                                motorbikeList.get(i).setLicense(license);
                                break;
                            }
                        }
                        System.out.println("Here is the Motorbike after updating");
                        motorbikeList.get(i).showProfile();
                    }
                }
            }
        }
    }

    //4. Delete vehicle id
    @Override
    public void deleteVehicle() {
        String id;
        id = TryCatch.getID("Input id vehicle(car or motorbike): ", "The format of id is CXXXXX(car) or MXXXXX(motorbike): ", "^[C|c]\\d{5}|^[M|m]\\d{5}");
        int tmp = searchVehicleByID(id);

        if (tmp == -1)
            System.out.println("Not found!!!");
        else {
            String confirm = TryCatch.getString("Are you sure? (Yes/No): ", "Yes or No");
            if (confirm.equalsIgnoreCase("Yes")) {
                if (id.startsWith("C")) {
                    carList.remove(tmp);
                    System.out.println("The selected car is removed successfully!");
                } else {
                    motorbikeList.remove(tmp);
                    System.out.println("The selected motorbike is removed successfully!");
                }
            } else
                System.out.println("The selected is removed fail!");
        }
    }

    public void deleteAllVehicle() {
        String confirm = TryCatch.getString("Are you sure? (Yes/No): ", "Yes or No");
        if (confirm.equalsIgnoreCase("Yes")) {
            if (carList.isEmpty() && motorbikeList.isEmpty()) 
                System.out.println("Vehicle does not exist");
            else {
                carList.removeAll(carList);
                motorbikeList.removeAll(motorbikeList);
                System.out.println("The selected is removed successfully!");
            }
        } else {
            System.out.println("The selected is removed fail!");
        }
    }
    
    //5. Search vehicle
    @Override
    public void searchVehicleByName() {
        String name = TryCatch.getString("Enter the name of the vehicle you want to find (car or motorbike): ", "Please enter the name of the place you want to find (car or motorbike)");
        
        if (name.equalsIgnoreCase("Car") || name.equalsIgnoreCase("Motorbike")) {
            if (name.equalsIgnoreCase("Car")) {
                if (carList.isEmpty())
                    System.out.println("Vehicle does not exist");
                else {
                    Collections.sort(carList, Collections.reverseOrder());
                    for (int i = 0; i < carList.size(); i++)
                        carList.get(i).showProfile();                   
                }
            } else if (name.equalsIgnoreCase("Motorbike")) {
                if (motorbikeList.isEmpty())
                    System.out.println("Vehicle does not exist");
                else{
                    Collections.sort(motorbikeList, Collections.reverseOrder());
                    for (int i = 0; i < motorbikeList.size(); i++)
                        motorbikeList.get(i).showProfile();
                }
            }    
        } else
            System.out.println("Vehicle does not exist");
    }

    //6.Show vehicle list
    @Override
    public void showAllVehicle() {
        if (carList.isEmpty() && motorbikeList.isEmpty())
            System.out.println("Vehicle does not exist");
        else {
            for (int i = 0; i < carList.size(); i++){
                carList.get(i).showProfile();
                //System.out.println(carList.get(i));//in dia chi
            }    
            for (int i = 0; i < motorbikeList.size(); i++) 
                motorbikeList.get(i).showProfile();
        }
    }
    
    @Override
    public void showAllVehicleDescendingByPrice() {
        if (carList.isEmpty())
            System.out.println("Car does not exist");
        else {
            Collections.sort(carList, new Car());
            for (int i = 0; i < carList.size(); i++)
                carList.get(i).showProfile();
        }
        if (motorbikeList.isEmpty())
            System.out.println("Motorbike does not exist");
        else 
            for (int i = 0; i < 1; i++)
                motorbikeList.get(i).makeSound();   
    }

    @Override
    public int searchVehicleByID(String id) {
        if (id.startsWith("C")) {
            for (int i = 0; i < carList.size(); i++) 
                if (carList.get(i).getId().equalsIgnoreCase(id))
                    return i;        
        } else {
            for (int i = 0; i < motorbikeList.size(); i++)
                if (motorbikeList.get(i).getId().equalsIgnoreCase(id))
                    return i;
        }
        return -1;
    }
    
    public String searchVehicleByID2(String id) {
        if (id.startsWith("C")) {
            for (int i = 0; i < carList.size(); i++) 
                if (carList.get(i).getId().equalsIgnoreCase(id))
                    return carList.get(i).getId();        
        } else {
            for (int i = 0; i < motorbikeList.size(); i++)
                if (motorbikeList.get(i).getId().equalsIgnoreCase(id))
                    return motorbikeList.get(i).getId();
        }
        return null;
    }

    
    //7.Store vehicle
    public void storeData() {
        try {
            FileWriter fw = new FileWriter("vehicle.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = null;
            for (Car car : carList) {
                line = car.getId() + ", " + car.getName() + ", " + car.getColor() + ", "
                        + car.getPrice() + ", " + car.getBrand() + ", " + car.getType() + ", " + car.getYom();
                bw.write(line);
                bw.newLine();
            }
            for (Motorbike motor : motorbikeList) {
                line = motor.getId() + ", " + motor.getName() + ", " + motor.getColor() + ", "
                        + motor.getPrice() + ", " + motor.getBrand() + ", " + motor.getSpeed() + ", " + motor.getLicense();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("File saved successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    } 
    
    
}

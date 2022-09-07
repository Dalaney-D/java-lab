/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GUI.TryCatch;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class AnimalList {

    ArrayList<Animal> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean find = false;

    public void add(Animal animal) {
        list.add(animal);
    }

    public int findAnimal(String ID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void updateAnimal() {
        String id = TryCatch.getString("Enter the Animal id you want to update: ", "Error");
        for (Animal animal : list) {
            if (animal.getID().equalsIgnoreCase(id)) {
                animal.setName(TryCatch.getString("Update new Animal name: ", "Error"));
                animal.setColor(TryCatch.getString("Update new Animal color: ", "Error"));
                animal.setSound(TryCatch.getBoolean("Update new Animal sound: ", "Error"));
                System.out.println("New eat");
                animal.setEat(sc.nextLine());
                animal.setWeight(TryCatch.getDouble("Update new Animal weight: ", "Error"));
                System.out.println("Update successfull");
                animal.outPut();
                return;
            }
        }
        System.out.println("Animal does not exist");
    }

    public void delete() {
        String id = TryCatch.getString("Enter the Animal id you want to delete: ", "Error");
        String ys = TryCatch.getString("Are you sure?(Yes/No)", "Error");
        if (ys.equalsIgnoreCase("yes")) {
            for (Animal animal : list) {
                if (animal.getID().equalsIgnoreCase(id)) {
                    list.remove(animal);
                    System.out.println("Remove successful.");
                    return;
                }
            }
        }
        System.out.println("Remove failed");
    }

    public void seachAnimalWithName() {
        String name = TryCatch.getString("Enter the Animal name you want seach: ", "Error");
        for (Animal animal : list) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("                ------Animal------");
                animal.outPut();
                find = true;
            }
        }
        if (find == false) {
            System.out.println("Not found");
        }
    }

    public void seachAnimalWithWeight() {
        double minWeight = TryCatch.getDouble("Enter the Animal minWeight you want seach: ", "Error");
        double maxWeight = TryCatch.getDouble("Enter the Animal maxWeight you want seach: ", "Error");
        for (Animal animal : list) {
            if ((animal.getWeight() >= minWeight) && (animal.getWeight() <= maxWeight)) {
                System.out.println("                ------Animal------");
                animal.outPut();
                find = true;
            }
        }
        if (find == false) {
            System.out.println("Not found");
        }
    }

    public void typeWantShow() {
        System.out.println("1. No Legs, 2. Two Legs and Can't Fly, 3. Two Legs and Fly, 4. Four Legs");
        int legs = TryCatch.getAnInteger("Enter the Animal type you want seach: ", "Error");
        for (Animal animal : list) {
            if (animal.getAnimalType() == legs) {
                animal.outPut();
                find = true;
            }
        }
        if (find == false) {
            System.out.println("Not found");
        }
    }

    public void showAll() {
        System.out.println("                ------Animal------");
        for (Animal animal : list) {
            animal.outPut();
        }
    }

    public void writeFile() {
        String fileAnimal = "D:\\---Kì 3---\\LAB\\Lab1\\animal.txt";
        File.writeBinaryAnimal(fileAnimal, list);
    }

    public void readFile() {
        String fileAnimal = "D:\\---Kì 3---\\LAB\\Lab1\\animal.txt";
        ArrayList<Animal> list = File.readBinaryAnimal(fileAnimal);
        System.out.println(list);
    }
    
    
}

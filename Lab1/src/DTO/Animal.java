/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GUI.TryCatch;
import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Animal implements Serializable {

    private int animalType;
    private String ID;
    private String name;
    private String color;
    private boolean sound;
    private String eat;
    private double weight;
    private String properties;

    public Animal() {
    }

    public Animal(int animlaType, String ID, String name, String color, boolean sound, String eat, double weight, String properties) {
        this.animalType = animlaType;
        this.ID = ID;
        this.name = name;
        this.color = color;
        this.sound = sound;
        this.eat = eat;
        this.weight = weight;
        this.properties = properties;
    }

    public int getAnimalType() {
        return animalType;
    }

    public void setAnimalType(int animalType) {
        this.animalType = animalType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public void input() {
        animalType = TryCatch.getInt("Input Animal Type: ", "Input again", 1, 4);
        ID = TryCatch.getString("Input ID: ", "Input again");
        name = TryCatch.getString("Input name: ", "Input again");
        color = TryCatch.getString("Input Color: ", "Input again");
        sound = TryCatch.getBoolean("Input Sound(True or False): ", "Input again");
        eat = TryCatch.getString("Input Eat: ", "Input again");
        weight = TryCatch.getDouble("Input Weight: ", "Input again");
        // properties = TryCatch.getString("Input Properties(Tính chất): ", "Input again");
    }

    public void outPut() {
        System.out.printf("|%s|%-5s|%-10s|%-5s|%-5s|%-7s|%.2f|%-5s|\n",
                animalType, ID, name, color, sound, eat, weight, properties);
    }

    @Override
    public String toString() {
        return "Animal{" + "animalType = " + animalType + ", ID = " + ID + ", name = " + name + ", color = " + color + ", sound = " + sound + ", eat = " + eat + ", weight = " + weight + ", properties = " + properties + '}' + "\n";
    }
    
    
}

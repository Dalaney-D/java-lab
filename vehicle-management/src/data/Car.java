/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Comparator;

/**
 *
 * @author Dell
 */
public class Car extends Vehicle implements Comparable<Car>, Comparator<Car>{
    String type;
    int yom;

    public Car() {
    }

    public Car(String id, String name, String color, int price, String brand, String type, int yom) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yom = yom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYom() {
        return yom;
    }

    public void setYom(int yom) {
        this.yom = yom;
    }
    
    @Override
    public void showProfile() {
        System.out.printf("|%-10s|%6s|%10s|%7s|%10s|%10s|%6s|%6d|\n", 
                                       "CAR", id, name, color, price + "$", brand, type, yom);
    }
    
    @Override
    public int compareTo(Car car) {
        return this.getId().compareToIgnoreCase(car.getId());
    }
    
    @Override
    public int compare(Car a, Car b) {
        return b.getPrice() - a.getPrice();
    }
}

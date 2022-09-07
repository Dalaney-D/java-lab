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
public class Asset implements Comparable<Asset>{
    private String assetId;
    private String name;
    private String color;
    private int price;
    private double weight;
    private int quantity;

    public Asset() {
    }

    public Asset(String assetId, String name, String color, int price, double weight, int quantity) {
        this.assetId = assetId;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getAssetId() {
        return assetId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void printAsset() {
        System.out.printf("|%-10s|%5s|%30s|%10s|%6d|%4.1f|%4d|\n",
                                  "Asset", assetId, name, color, price, weight, quantity);
    } 
    
    @Override
    public int compareTo(Asset asset) {
        return this.getAssetId().compareToIgnoreCase(asset.getAssetId());
    }
    
}

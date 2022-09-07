/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Dell
 */
public class AssetList implements FunctionOfManager{
    private ArrayList<Asset> assetList = new ArrayList();
    int idTemp = 1;
    
    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("asset.dat", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            for (Asset asset : assetList) {
                line = asset.getAssetId() + ", " + asset.getName() + ", " + asset.getColor() + ", " + asset.getPrice() + ", " + asset.getWeight() + ", " + asset.getQuantity();
                bufferedWriter.write(line);
                bufferedWriter.newLine();  
            }           
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readFile() {
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("asset.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
            bufferedReader.close();
            fileReader.close();
            for (int i = 0; i < listLine.size(); i++) {
                String[] lineSplit = listLine.get(i).split(", ");
                assetList.add(new Asset(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]), Double.parseDouble(lineSplit[4]), Integer.parseInt(lineSplit[5])));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("The system cannot find the file asset.dat. The system will get the data available in the program.");
            inputAsset();
        }
    }
    
    
    public void inputAsset() {      
        assetList.add(new Asset("A" + String.valueOf(idTemp++), "Samsung projector", "White", 500, 3.2 ,10));
        assetList.add(new Asset("A" + String.valueOf(idTemp), "Macbook pro 2016", "Sliver", 1000, 2.2, 5));
        writeFile();
    }
    
    //Function 2.
    @Override
    public void searchAssetByName() {
        boolean tmp = false; 
        String name = TryCatch.getString("Input name Asset: ", "The Asset name is required!");
        Collections.sort(assetList, Collections.reverseOrder());
        for (int i = 0; i < assetList.size(); i++) {
            if (assetList.get(i).getName().contains(name)) {
                assetList.get(i).printAsset();
                tmp = true;
            }
        }
        if (tmp == false)
            System.out.println("Not found!");
    }
    
    //Function 3.
    @Override
    public void addNewAsset() {
        String name, color;
        int price, quantity;
        double weight;
        Collections.sort(assetList);

        for (int i = 0; i < assetList.size(); i++) {
            idTemp = Integer.parseInt(assetList.get(i).getAssetId().substring(1));
        }
        idTemp++;
        name = TryCatch.getString("Input name Asset: ", "The Asset name is required!");
        color = TryCatch.getString("Input color Asset: ", "The Asset color is required!");
        price = TryCatch.getAnInteger("Input price Asset: ", "The Asset price is required!", 1, Integer.MAX_VALUE);
        weight = TryCatch.getAnDouble("Input weight Asset: ", "The Asset weight is required!", 0.1, Double.MAX_VALUE);
        quantity = TryCatch.getAnInteger("Input quantity Asset: ", "The Asset quantity is required!", 0, Integer.MAX_VALUE);
        assetList.add(new Asset("A" + String.valueOf(idTemp), name, color, price, weight, quantity));
        writeFile();
    }
        
    //Function 4.
    @Override
    public void updateAsset() {
        String id, name, color, tmp;
        int price, quantity;
        double weight;
        Asset a;
        id = TryCatch.getString("Input id Asset: ", "Asset id is required!");
        a = searchAsset(id);
        System.out.println("-------------------------------");
        if (a == null) 
            System.out.println("Asset does not exist");
        else {
            System.out.println("Here is the Asset before updating");
            a.printAsset();
            System.out.println("");
            
            name = TryCatch.getString("Input name Asset: ");
            if (name.equals(""))
                a.setName(a.getName());
            else 
                a.setName(name);
            
            color = TryCatch.getString("Input color Asset: ");
            if (color.equals(""))
                a.setColor(a.getColor());
            else 
                a.setColor(color);
   
            while (true) {
                tmp = TryCatch.getString("Input price Asset: ");
                if (tmp.equals("")) {
                    a.setPrice(a.getPrice());
                    break;
                } else {
                    try {
                        if ((price = Integer.parseInt(tmp)) > 0 && (price = Integer.parseInt(tmp)) <= Integer.MAX_VALUE) {
                            a.setPrice(price);
                            break;
                        } else
                            System.out.println("Price > 0");
                    } catch (Exception e) {
                        System.out.println("Input again.");
                    }
                }
            }

            while (true) {
                tmp = TryCatch.getString("Input weight Asset: ");
                if (tmp.equals("")) {
                    a.setWeight(a.getWeight());
                    break;
                } else {
                    try {
                        if ((weight = Double.parseDouble(tmp)) > 0.1 && (weight = Double.parseDouble(tmp)) <= Double.MAX_VALUE) {
                            a.setWeight(weight);
                            break;
                        } else 
                            System.out.println("Weight > 0");
                    } catch (Exception e) {
                        System.out.println("Input again.");
                    }
                }
            }
            
            while (true) {
                tmp = TryCatch.getString("Input quantity Asset: ");
                if (tmp.equals("")) {
                    a.setQuantity(a.getQuantity());
                    break;
                } else {
                    try {
                        if ((quantity = Integer.parseInt(tmp)) > 0 && (quantity = Integer.parseInt(tmp)) <= Integer.MAX_VALUE) {
                            a.setQuantity(quantity);
                            break;
                        } else
                            System.out.println("Quantity > 0");
                    } catch (Exception e) {
                        System.out.println("Input again.");
                    }
                }
            }
            
            System.out.println("");
            System.out.println("Here is the Asset after updating");
            a.printAsset();
            writeFile();
        }
    }
    
    public void showList() {
        Collections.sort(assetList, Collections.reverseOrder());
        for (int i = 0; i < assetList.size(); i++)
            assetList.get(i).printAsset();
    }
    
    public Asset searchAsset(String id) {
        for (int i = 0; i < assetList.size(); i++) 
            if(assetList.get(i).getAssetId().equals(id)) 
                return assetList.get(i);
        return null;
    }
    
}

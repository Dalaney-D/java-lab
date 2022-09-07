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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class BorrowList {
    private ArrayList<Borrow> borrowList = new ArrayList();
    int idTemp = 1;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
     public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("borrow.dat", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            for (Borrow borrow : borrowList) {         
                line = borrow.getbID() + ", " + borrow.getAssetID() + ", " + borrow.getEmployeeID() + ", " + borrow.getQuantity() + ", " + borrow.getBorrowDateTime();
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
            FileReader fileReader = new FileReader("borrow.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
            bufferedReader.close();
            fileReader.close();
            for (int i = 0; i < listLine.size(); i++) {
                String[] lineSplit = listLine.get(i).split(", ");
                    borrowList.add(new Borrow(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]), lineSplit[4]));
            }         
        } catch (IOException | NumberFormatException e) {
            System.out.println("The system cannot find the file borrow.dat. The system will get the data available in the program.");
            inputBorrow();
        }
    }
    
    public void inputBorrow() {
        borrowList.add(new Borrow("B" + String.valueOf(idTemp++), "A1", "E160001", 1, dateFormat.format(date)));
        borrowList.add(new Borrow("B" + String.valueOf(idTemp++), "A1", "E160001", 2, dateFormat.format(date)));
        borrowList.add(new Borrow("B" + String.valueOf(idTemp++), "A2", "E160798", 3, dateFormat.format(date)));
        borrowList.add(new Borrow("B" + String.valueOf(idTemp), "A1", "E160240", 2, dateFormat.format(date)));
        writeFile();
    }
    
    public void addNewBorrow(String assetID, String employeeID, int quantity) {
        for (int i = 0; i < borrowList.size(); i++) {
            idTemp = Integer.parseInt(borrowList.get(i).getbID().substring(1));
        }
        idTemp++;       
        borrowList.add(new Borrow("B" + String.valueOf(idTemp), assetID, employeeID, quantity, dateFormat.format(date)));
        writeFile();
    }
    
    public void showList() {
        for (Borrow borrow : borrowList) {
            borrow.printBorrow();
        }
    }
    
    public void showList(String id) {
        for (int i = 0; i < borrowList.size(); i++) {
            if (borrowList.get(i).getEmployeeID().equals(id)) {
                borrowList.get(i).printBorrow();
            }
        }
    }
        
    public Borrow searchBorrow(String id) {
        for (int i = 0; i < borrowList.size(); i++) 
            if(borrowList.get(i).getbID().equals(id)) 
                return borrowList.get(i);
        return null;
    }
      
    public void removeBorrow(Borrow b) {
        borrowList.remove(b);
        writeFile();
    }
    
}   

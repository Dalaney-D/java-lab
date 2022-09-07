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
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class BorrowRequestList {
    private ArrayList<BorrowRequest> requesList = new ArrayList();
    int idTemp = 1;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
    
    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("request.dat", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            for (BorrowRequest request : requesList) {
                line = request.getrID() + ", " + request.getAssetID() + ", " + request.getEmployeeID() + ", " + request.getQuantity() + ", " + request.getRequestDateTime();
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
            FileReader fileReader = new FileReader("request.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
            bufferedReader.close();
            fileReader.close();
            for (int i = 0; i < listLine.size(); i++) {
                String[] lineSplit = listLine.get(i).split(", ");
                    requesList.add(new BorrowRequest(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]), lineSplit[4]));
            }         
        } catch (IOException | NumberFormatException e) {
            System.out.println("The system cannot find the file request.dat. The system will get the data available in the program.");
            inputReques();
        }
    }
    
    public void inputReques() {
        requesList.add(new BorrowRequest("R" + String.valueOf(idTemp++), "A1", "E140449", 1, dateFormat.format(date)));
        requesList.add(new BorrowRequest("R" + String.valueOf(idTemp++), "A2", "E160001", 1, dateFormat.format(date)));
        requesList.add(new BorrowRequest("R" + String.valueOf(idTemp++), "A1", "E160798", 1, dateFormat.format(date)));
        requesList.add(new BorrowRequest("R" + String.valueOf(idTemp), "A2", "E160240", 1, dateFormat.format(date)));
        writeFile();
    }
    
    public void addNewBorrow (String assetID, String employeeID, int quantity) {

        for (int i = 0; i < requesList.size(); i++) {
            idTemp = Integer.parseInt(requesList.get(i).getrID().substring(1));
        }
        idTemp++;
        requesList.add(new BorrowRequest("R" + String.valueOf(idTemp), assetID, employeeID,quantity, dateFormat.format(date)));
        writeFile();
    }
    
    public void showList() {
        if (requesList.isEmpty())
            System.out.println("No borrow request");
        else
            for (BorrowRequest borrowRequest : requesList)
                borrowRequest.printRequest();
    }
    
    public void showList(String id) {
        for (int i = 0; i < requesList.size(); i++) {
            if (requesList.get(i).getEmployeeID().equalsIgnoreCase(id)) {
                requesList.get(i).printRequest();
            }
        }
    }
    
    public BorrowRequest searchRequest(String id) {
        for (int i = 0; i < requesList.size(); i++) 
            if(requesList.get(i).getrID().equals(id)) 
                return requesList.get(i);
        return null;
    }
      
    public void removeRequest(BorrowRequest i) {
        requesList.remove(i);
        writeFile();
    }   
    
}

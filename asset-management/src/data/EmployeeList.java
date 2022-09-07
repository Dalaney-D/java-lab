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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class EmployeeList {

    private ArrayList<Employee> employeeList = new ArrayList();
    
    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("employee.dat", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            for (Employee employee : employeeList) {
                line = employee.getEmployID() + ", " + employee.getName() + ", " + employee.getBirthdate() + ", " + employee.getRole() + ", " + employee.getSex() + ", " + employee.getPassword();
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
            FileReader fileReader = new FileReader("employee.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
            bufferedReader.close();
            fileReader.close();
            for (int i = 0; i < listLine.size(); i++) {
                String[] lineSplit = listLine.get(i).split(", ");
                    employeeList.add(new Employee(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5]));
            }          
        } catch (IOException e) {
            System.out.println("The system cannot find the file employee.dat. The system will get the data available in the program.");
            inputEmployee();
        }
    }
    
    public void inputEmployee() {    
        employeeList.add(new Employee("E160001" ,"Nguyen Hong Hiep", "11/06/2000", "EM", "male", "e10adc3949ba59abbe56e057f20f883e"));
        employeeList.add(new Employee("E160240", "Tran Dinh Khanh", "15/07/2002", "EM", "male", "e10adc3949ba59abbe56e057f20f883e"));
        employeeList.add(new Employee("E140449", "Le Buu Hoang", "10/07/2002", "EM", "male", "e10adc3949ba59abbe56e057f20f883e"));
        employeeList.add(new Employee("E160798", "Truong Le Minh", "03/12/2002", "EM", "male", "e10adc3949ba59abbe56e057f20f883e"));
        employeeList.add(new Employee("E160052", "Hoa Doan", "05/06/1990", "MA", "male", "e10adc3949ba59abbe56e057f20f883e"));
        writeFile();
    }
    
    public void showList() {
        for (Employee employee : employeeList)
            employee.printEmployee();
    }
    
    public Employee searchEmployee(String id) {
        for (int i = 0; i < employeeList.size(); i++) 
            if(employeeList.get(i).getEmployID().equals(id)) 
                return employeeList.get(i);
        return null;
    }
    
    public String checkLogin() {
        String id = TryCatch.getString("Input employeeID: ", "Input again employeeID.");
        String pw = getMD5(TryCatch.getString("Input password: ", "Input again password."));
        Employee e = searchEmployee(id);
        if (e == null)
            return null;
        else {
            if (e.getRole().equalsIgnoreCase("MA") && e.getPassword().equalsIgnoreCase(pw))
                return "MA";
            
            if (e.getRole().equalsIgnoreCase("EM") && e.getPassword().equalsIgnoreCase(pw))
                return "EM";
            
            return null;
        }    
    }

    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex1(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertByteToHex1(byte[] data) {
        BigInteger number = new BigInteger(1, data);
        String hashtext = number.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
}

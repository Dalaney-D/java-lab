/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class FileVehicle {
    public static List<String> readFile() {
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fr = new FileReader("vehicle.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                listLine.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listLine;
    }
}

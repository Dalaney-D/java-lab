/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class TryCatch {
    private static Scanner sc = new Scanner(System.in);
    
    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {            
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) 
                    throw new Exception();
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static String getString(String inputMsg, String errorMsg) {
        String m;
        while (true) {            
            System.out.print(inputMsg);
            m = sc.nextLine().trim();
            if (m.length() == 0 || m.isEmpty())
                System.out.println(errorMsg);
            else 
                return m;
        }
    }
    
    public static String getDob(String inpuMsg, String errorMsg, String format) {
        String dob;
        boolean match;
        while(true) {
            System.out.print(inpuMsg);
            dob = sc.nextLine().trim().toUpperCase();
            match = dob.matches(format);
            if (dob.length() == 0 || dob.isEmpty() || match == false)
                System.out.println(errorMsg);
            else
                return dob;
        }
    } 
    
}

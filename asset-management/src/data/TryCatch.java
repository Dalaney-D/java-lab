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

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int i, tmp;

        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        while (true) {
            try {
                System.out.print(inputMsg);
                i = Integer.parseInt(sc.nextLine());
                if (i < lowerBound || i > upperBound)
                    throw new Exception ();
                return i;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getAnDouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double i, tmp;

        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                i = Double.parseDouble(sc.nextLine());
                if (i < lowerBound || i > upperBound) {
                    throw new Exception();
                }
                return i;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String s;
        while (true) {
            System.out.print(inputMsg);
            s = sc.nextLine().trim();
            if (s.isEmpty() || s.length() == 0)
                System.out.println(errorMsg);
            else 
                return s;   
        }
    }
    
    public static String getString(String inputMsg) {
        String s;
        while (true) {            
            System.out.print(inputMsg);
            s = sc.nextLine().trim();
            return s;
        }
    }

    public static String getFormat(String inpuMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inpuMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
            else 
                return id;
        }
    }

   
}

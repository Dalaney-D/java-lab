
package Data;

import java.util.Scanner;

/**
 *
 * @author duyng
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
                    throw new Exception();
                return i;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
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
    
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {            
            System.out.println(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
            else 
                return id;
        }
    }
    
    public static String getStringColor(String inputMsg, String errorMsg) {
        String s;
        while (true) {
            s = getString(inputMsg, errorMsg);
            if (s.equalsIgnoreCase("Red") || s.equalsIgnoreCase("Blue") || s.equalsIgnoreCase("Green"))
                return s;
            else
                System.out.println(errorMsg);
        }
    }
    
    public static String getStringType(String inputMsg, String errorMsg) {
        String s;
        while (true) {
            s = getString(inputMsg, errorMsg);
            if (s.equalsIgnoreCase("sport") || s.equalsIgnoreCase("travel") || s.equalsIgnoreCase("common"))
                return s;
            else 
                System.out.println(errorMsg);
        }
    }
}

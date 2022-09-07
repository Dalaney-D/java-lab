/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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

    public static String getString(String inputMsg, String errorMsg) {
        String s;
        while (true) {
            System.out.print(inputMsg);
            s = sc.nextLine().trim();
            if (s.length() == 0 || s.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return s;
            }

        }
    }

    public static boolean getBoolean(String inputMsg, String errorMsg) {
        String b;
        while (true) {
            System.out.print(inputMsg);
            b = sc.nextLine().trim();
            if (b.equalsIgnoreCase("True")) {
                return true;
            } else if (b.equalsIgnoreCase("False")) {
                return false;
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getDouble(String inputMsg, String errorMsg) {
        double d;
        while (true) {
            try {
                System.out.print(inputMsg);
                d = Double.parseDouble(sc.nextLine());
                if (d <= 0) {
                    throw new Exception();
                }
                return d;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getInt(String inputMsg, String errorMsg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
//                if (n <= 0) {
//                    throw new Exception();
//                }
                if (n >= min && n <= max) {
                    return n;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

}

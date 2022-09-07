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

    static Scanner sc = new Scanner(System.in);

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

}

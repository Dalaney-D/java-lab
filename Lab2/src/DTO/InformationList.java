/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GUI.Data;
import java.util.ArrayList;
import GUI.TryCatch;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class InformationList {

    static Scanner sc = new Scanner(System.in);
    ArrayList<injectionInformation> listI = new ArrayList<>();

    public void Date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    }

    public void add(injectionInformation iI) {
        listI.add(iI);
    }

    public void show() {
        if (listI.isEmpty()) {
            System.out.println("No File");
        } else {
            for (injectionInformation information : listI) {
                information.output();
            }
        }
    }

    public void update() {
        boolean ys = false;
        int n;
        do {
            String injectionId = TryCatch.getString("Input injection Id: ", "Error");
            for (injectionInformation information1 : listI) {
                if (information1.getInjectionId().equalsIgnoreCase(injectionId)) {

  //                  SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
//                    String m;
//                    while (true) {
//                        try {
//                            System.out.println(inputMsg);
//                            information1.setSecondInformationDate(m = sc.nextLine().trim());
//                            m = sc.nextLine().trim();
//                            a.parse(m);
//
//                            Date second = a.parse(m);
//                            Date sub = information1.getFirstInformationDate().
//                            long noDay = (second.getTime() - listI.f) / (24 * 3600 * 1000);
//                            System.out.println("Số ngày: " + noDay);
//                            if (noDay < 28) {
//                                System.out.println("ko đủ điều kiên tiêm");
//                            } else {
//                                System.out.println("đủ điều kiện tiêm");
//                            }
//                            return m;
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }
//
                        information1.setSecondInformationPlace(TryCatch.getString("Update địa chỉ tiêm mũi 2: ", "Error"));
                        ys = true;
                    }
                }
                if (ys == false) {
                    System.out.println("“Injection does not exist”");
                    return;
                }

                for (injectionInformation information : listI) {
                    if (information.getInjectionId().equalsIgnoreCase(injectionId)) {
                        System.out.println("Đây có phải là thông tin bạn muốn chỉnh sửa");
                        information.output();
                        break;
                    }
                }

                n = TryCatch.getAnInteger("Choose(1/0): ", "Error");
            }
            while (n == 0);
        }


    public String frist(String inputMsg, String errorMsg) {
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");

        String n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = sc.nextLine().trim();
                a.parse(n);
                Date first = a.parse(n);
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public void search() {
        String studentID = TryCatch.getString("Input student Id: ", "Error");
        for (injectionInformation information : listI) {
            if (information.getStudent().getStudentID().equalsIgnoreCase(studentID)) {
                information.input();
            }
        }
    }

    public void delete1() {
        String injectionId = TryCatch.getString("Input injection Id: ", "Error");
        String ys = TryCatch.getString("Are you sure? (Yes/No)", "Error");
        if (ys.equalsIgnoreCase("Yes")) {
            for (injectionInformation information : listI) {
                if (information.getInjectionId().equalsIgnoreCase(injectionId)) {
                    listI.remove(information);
                    System.out.println("Remove successful.");
                    return;
                }
            }
        }
        System.out.println("Remove failed");
    }

    public void delete2() {
        int choice;
        do {
            System.out.println("1. Xóa mũi 1");
            System.out.println("2. Xóa mũi 2");
            choice = TryCatch.getAnInteger("Input choice: ", "Error");
            switch (choice) {
                case 1:
                    String injectionId = TryCatch.getString("Input injection Id: ", "Error");
                    String ys = TryCatch.getString("Are you sure? (Yes/No)", "Error");
                    if (ys.equalsIgnoreCase("Yes")) {
                        for (injectionInformation information : listI) {
                            if (information.getInjectionId().equalsIgnoreCase(injectionId)) {
                                listI.get(choice).setSecondInformationDate(injectionId);
                                System.out.println("Remove successful.");
                                return;
                            }
                        }
                    }
                    System.out.println("Remove failed");
                    break;
                case 2:

                    break;
            }
        } while (choice != 1 || choice != 2);
    }

    public void writeFile() {
        String fileInformation = "D:\\---Kì 3---\\LAB\\Lab2\\injection.txt";
        Data.writeBinarryInformation(fileInformation, listI);
    }

    public void readFile() {
        String fileInformation = "D:\\---Kì 3---\\LAB\\Lab2\\injection.txt";
        ArrayList<injectionInformation> listI = Data.readBinaryInformation(fileInformation);
        System.out.println(listI);
    }

//    public static String second(String inputMsg, String errorMsg) {
//        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
//        String m;
//        while (true) {
//            try {
//                System.out.println(inputMsg);
//                m = sc.nextLine().trim();
//                a.parse(m);
//                Date first = a.parse(m);
//
//                if (injectionInformation.class.getF) {
//                    throw new Exception();
//                } else {
//                    System.out.println("");
//                }
//                long noDay = (second.getTime() - first.getTime()) / (24 * 3600 * 1000);
//                System.out.println("Số ngày: " + noDay);
//                if (noDay < 28) {
//                    System.out.println("ko đủ điều kiên tiêm");
//                } else {
//                    System.out.println("đủ điều kiện tiêm");
//                }
//                return m;
//            } catch (Exception e) {
//                System.out.println(errorMsg);
//            }
//        }
//    }
}

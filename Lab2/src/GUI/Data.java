/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Student;
import DTO.Vaccine;
import DTO.injectionInformation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Data {

    static Scanner sc = new Scanner(System.in);

    public static void writeBinaryStudent(String fileStudent, ArrayList<Student> listS) {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(fileStudent);
            of = new ObjectOutputStream(f);
            of.writeObject(listS);
        } catch (Exception e) {
            System.out.println("Error" + e);
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (of != null) {
                    of.close();
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        }
    }

    public static void writeBinaryVaccine(String fileVaccine, ArrayList<Vaccine> listV) {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(fileVaccine);
            of = new ObjectOutputStream(f);
            of.writeObject(listV);
        } catch (Exception e) {
            System.out.println("Error" + e);
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (of != null) {
                    of.close();
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        }
    }

    public static void writeBinarryInformation(String fileInformation, ArrayList<injectionInformation> listI) {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(fileInformation);
            of = new ObjectOutputStream(f);
            of.writeObject(listI);
            if (f != null) {
                f.close();
            }
            if (of != null) {
                of.close();
            }
        } catch (Exception e) {
            System.out.println("Error!! Can't save!!");
        }
    }

    public static ArrayList<injectionInformation> readBinaryInformation(String fileInformation) {
        FileInputStream f = null;
        ObjectInputStream of = null;
        ArrayList<injectionInformation> listI = null;
        try {
            f = new FileInputStream(fileInformation);
            of = new ObjectInputStream(f);
            listI = (ArrayList<injectionInformation>) of.readObject();
        } catch (Exception e) {
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (of != null) {
                    of.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return listI;
    }

    public static void test() {
        // Định dạng thời gian

        String n, m;
        boolean fa;
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        a.setLenient(false);
        do {
            try {
                n = sc.nextLine().trim();
                m = sc.nextLine().trim();
                a.parse(n);
                Date first = a.parse(n);
                Date second = a.parse(m);
                c1.setTime(first);
                c2.setTime(second);
                System.out.printf("%s %tB %<te, %<tY", "Due date:", first);
                System.out.println("");
                System.out.printf("%s %tB %<te, %<tY", "Due date:", second);
                System.out.println("");
                if (first.after(second)) {
                    throw new Exception();
                } else {
                    System.out.println("");
                }

                long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
                System.out.println("Số ngày: " + noDay);
                if (noDay < 28) {
                    System.out.println("ko đủ điều kiên tiêm");
                    return;
                } else {
                    System.out.println("đủ điều kiện tiêm");
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (true);

    }

    
     
     
}

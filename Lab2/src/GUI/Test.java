/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.*;

/**
 *
 * @author Dell
 */
public class Test {

    public static void main(String[] args) {
        StudentList list1 = new StudentList();
        VaccineList list2 = new VaccineList();
        InformationList list3 = new InformationList();
        int choice;
        do {
            Menu();
            choice = TryCatch.getAnInteger("Enter your choice: ", "Error");
            switch (choice) {
                case 1:
                    list3.show();
                    break;
                case 2:
                    int choice1;
                    do {
                        menuAdd();
                        choice1 = TryCatch.getAnInteger("Enter your choice: ", "Error");
                        switch (choice1) {
                            case 1:
                                int choice2;
                                do {
                                    Student student = new Student();
                                    student.input();
                                    list1.writeFile();

                                    Vaccine vaccine = new Vaccine();
                                    vaccine.input();
                                    list2.writeFile();

                                    injectionInformation iI = new injectionInformation();
                                    iI.input();

                                    iI.setStudent(student);
                                    iI.setVaccine(vaccine);

                                    list1.add(student);
                                    list2.add(vaccine);
                                    list3.add(iI);

                                    choice2 = TryCatch.getAnInteger("Want to continue(1/0): ", "Error");
                                } while (choice2 == 1);
                                break;
                            case 2:
                                break;
                            case 3:
                                System.out.println("Quite");
                                break;
                        }
                    } while (choice1 != 3);
                    break;
                case 3:
                    list3.update();
                    break;
                case 4:
                    int choice2;
                    do {
                        menuDelete();
                        choice2 = TryCatch.getAnInteger("Input choice: ", "Error");
                        switch (choice2) {
                            case 1:
                                list3.delete1();
                                break;
                            case 2:
                                list3.delete2();
                                break;
                        }
                    } while (choice2 != 1 || choice2 != 2);
                    break;
                case 5:
                    list3.readFile();
                    break;
                case 6:
                    list3.writeFile();
                    break;
                case 7:
                    System.out.println("Quite");
                    break;
            }
        } while (choice != 7);
    }

    public static void Menu() {
        System.out.println("");
        System.out.println("1. Show information all students have been injected");
        System.out.println("2. Add student's vaccine injection information");
        System.out.println("3. Updating information of students' vaccine injection");
        System.out.println("4. Delete student vaccine injection information");
        System.out.println("5. Search for injection information by studentID");
        System.out.println("6. Store data to file");
        System.out.println("7. Quit");
    }

    public static void menuAdd() {
        System.out.println("1. New injection information. ");
        System.out.println("2. New injection");
        System.out.println("3. Qiute");
    }

    public static void menuDelete() {
        System.out.println("1. Delete student vaccine injection information ");
        System.out.println("2. Delete the Injection in the list.");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.*;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Test {

    public static void main(String[] args) {
        AnimalList LIST = new AnimalList();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            Menu();
            choice = TryCatch.getAnInteger("Enter your choice: ", "Please enter again");
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.println("                Để tránh tình trạng xảy ra lỗi.");
                        System.out.println("    Xin lưu ý chương trình đang quản lý những loại thú sau.");
                        System.out.println("1. No Legs, 2. Two Legs and Can't Fly, 3. Two Legs and Fly, 4. Four Legs");
                        System.out.println("");
                        Animal animal = new Animal();
                        do {
                            animal.input();
                        } while (LIST.findAnimal(animal.getID()) != -1);
                        LIST.add(animal);
                        System.out.println("Added successfull");
                        System.out.println("Do you want enter again?");
                        choice1 = TryCatch.getAnInteger("Want to continue(1/0): ", "Error");
                    } while (choice1 == 1);
                    break;
                case 2:
                    LIST.updateAnimal();
                    break;
                case 3:
                    LIST.delete();
                    break;
                case 4:
                    Seach();
                    int choice2 = TryCatch.getAnInteger("Enter your choice: ", "Error");
                    switch (choice2) {
                        case 1:
                            LIST.seachAnimalWithName();
                            break;
                        case 2:
                            LIST.seachAnimalWithWeight();
                            break;
                    }
                    break;
                case 5:
                    show();
                    int choice3 = TryCatch.getAnInteger("Enter your choice: ", "Error");
                    switch (choice3) {
                        case 1:
                            LIST.typeWantShow();
                            break;
                        case 2:
                            LIST.showAll();
                            break;
                    }
                    break;
                case 6:
                    LIST.writeFile();
                    break;
                case 7:
                    LIST.readFile();
                    break;
                case 8:
                    System.out.println("Quit");
                    break;
            }
        } while (choice != 8);

    }

    public static void Menu() {
        System.out.println("--------Welcome to the program to manage animals in the zoo.--------");
        System.out.println("1.Add new animal");
        System.out.println("2.Update animal");
        System.out.println("3.Delete animal");
        System.out.println("4.Seach by type");
        System.out.println("5.Show animal list");
        System.out.println("6.Store data to file");
        System.out.println("7.Read data to file");
        System.out.println("8.Quit.");
        System.out.println("");
    }

    public static void Seach() {
        System.out.println("    1.Seach by name");
        System.out.println("    2.Seach by weight");
    }

    public static void show() {
        System.out.println("    1.Show by Type");
        System.out.println("    2.Show all");
    }

}

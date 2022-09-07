/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author Dell
 */
public class File {
    //fileName la ten file ket qua sau khi ghi la chuoi nhi phan
    public static void writeBinaryAnimal(String fileAnimal, ArrayList<Animal> list) {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(fileAnimal);
            of = new ObjectOutputStream(f);
            of.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }finally{
            try {
                if (f != null) {
                    f.close();
                } if (of != null){
                    of.close();
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        }
    }
    
    public static ArrayList<Animal> readBinaryAnimal(String fileAnimal) {
        FileInputStream f = null;
        ObjectInputStream of = null;
        ArrayList<Animal> list = null;
        try {
            f = new FileInputStream(fileAnimal);
            of = new ObjectInputStream(f);
            list = (ArrayList<Animal>) of.readObject();
        } catch (Exception e) {
        }
        finally{
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
        return list;
    }

}
    


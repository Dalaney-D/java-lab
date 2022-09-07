/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Dell
 */
public class Menu {
    
    public void menuMain() {
        System.out.println("");
        System.out.println("-----------Menu-----------");
        System.out.println("---You have just logged into your account, as Manager.---");
        System.out.println("2. Search asset");
        System.out.println("3. Create new Asset");
        System.out.println("4. Update asset");
        System.out.println("5. Approve the request of employee");
        System.out.println("6. Show list of borrow asset");
        System.out.println("7. Exit");
    }
    
    public void menuEmployee() {
        System.out.println("");
        System.out.println("-----------Menu-----------");
        System.out.println("---You have just logged into your account, as Employee.---");
        System.out.println("2. Search asset");
        System.out.println("3. Borrow the assets");
        System.out.println("4. Cancel request");
        System.out.println("5. Return request");
        System.out.println("6. Exit");
    }
    
    public void Login() {
        System.out.println("");
        System.out.println("      -----Hello-----");
        System.out.println("    Welcome to the program.     ");
        System.out.println("1. Search asset by name");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }
}

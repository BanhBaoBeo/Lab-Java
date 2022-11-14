/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BBBGARDEN
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);
    //Check nhập lựa chọn 
    public static int checkChoice() {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 1 || choice > 2) {
                    throw new NumberFormatException();
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid value!!!");
            }
        }
        return choice;
    }
    //Check ks tự 
    public static boolean checkChar(String msg, char ch1, char ch2) {
        char c = sc.nextLine().toLowerCase().trim().charAt(0);
        while (c != ch1 && c != ch2) {
            System.out.print(msg);
            c = sc.nextLine().toLowerCase().trim().charAt(0);
        }
        return c == ch1;
    }
    //Check item 
    public static Item checkItem(String name, List<Item> list) {
        for (Item item : list) {
            if (name.equalsIgnoreCase(item.getName().trim())) {
                return item;
            }
        }
        return null;
    }
}

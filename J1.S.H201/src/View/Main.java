/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Validation;
import Model.DiscountBill;
import Model.Employee;
import Model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BBBGARDEN
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Item> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new Item("Banh Bao", 20.25, 0.25));
        list.add(new Item("Bun Bo",35.5, 0.0));
        list.add(new Item("Quay", 6.5, 1.0));
        list.add(new Item("Bun Dau", 30.0, 0.5));
        list.add(new Item("Tra Da", 3.0, 0.0));
        list.add(new Item("Banh My ",15.0,0.5));
        list.add(new Item("Thit Nuong",50.5,2.0));
        Employee employee = new Employee();
        int choice;
        do {
            System.out.println("===========💌💌💌💌💌===========\n"
                    + "1. Print Bill\n"
                    + "2. Exit");
            System.out.print("Your choice: ");
            choice = Validation.checkChoice();

            switch (choice) {
                case 1:
                    //Nhập tên khách hàng 
                    System.out.println("Enter name of customer: ");
                    employee.setName(sc.nextLine().trim());
                    //Check xem có phải khách hàng được hưởng giảm giá không 
                    System.out.printf("Are %s preffered? (T/F): ", employee.getName());
                    boolean pr = Validation.checkChar("Must enter T/F: ", 't', 'f');
                    DiscountBill db = new DiscountBill(employee, pr);
                    do {
                        System.out.printf("Input name of items %s were bought: ", employee.getName());
                        String name = sc.nextLine().trim();
                        //Nếu có mặt hàng đấy thì add , không thì báo không tìm thấy 
                        if (Validation.checkItem(name, list) == null) {
                            System.err.println("Not found Item!!!");
                        } else {
                            db.add(Validation.checkItem(name, list));
                            System.out.println("Add successfully!!!");
                        }
                        //Hỏi người nhập bill có muốn tiếp tục không 
                        System.out.print("Continue? (Y/N): ");
                    } while (Validation.checkChar("Must enter Y/N: ", 'y', 'n'));

                    db.printRecieipt();
                    System.out.println("🛒🛒----------------------------------------🛒🛒");
                    //In ra tổng 
                    System.out.printf("Total: %.2f\n", db.getTotal() + db.getDiscountAmount());
                    //In ra số đồ được giảm giá 
                    System.out.println("The amount of discount items: " + db.getDiscountCount());
                    //In ra tổng được giảm giá 
                    System.out.printf("Total discount: %.2f\n", db.getDiscountAmount());
                    //% giảm giá với tổng 
                    System.out.printf("Percentage of discount: %.2f%%\n", db.getDiscountPercent());
                    //In ra tổng 
                    System.out.printf("Total price: %.2f\n", db.getTotal());
                    break;
                case 2:
                    return;

            }
        } while (choice > 0 && choice < 3);

    }

}

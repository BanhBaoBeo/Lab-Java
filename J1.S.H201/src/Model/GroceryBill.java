/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BBBGARDEN
 */
public class GroceryBill {
    private Employee clerk;
    private List<Item> listItems;
    private double total;

    public GroceryBill() {
    }

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        total = 0.0;
        listItems = new ArrayList<>();
    }

    public void add(Item i) {
        listItems.add(i);
        total += i.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public Employee getClerk() {
        return clerk;
    }
    //in ra biên lai 
    public void printRecieipt(){
        System.out.println("List of items: ");
        System.out.printf("%-13s%-8s%-8s\n", "Name", "Price", "Discount");
        for (Item item : listItems) {
            System.out.println(item.toString());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0020;

import java.util.Scanner;

/**
 *
 * @author BBBGARDEN
 */
public class J1SP0020 {
//check đầu vào 
    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Please input integer number");
                System.out.print("Enter again: ");
            }
        }
    }

//Nhập giá trị cho mảng 
    private static int[] inputValueOfArray(int n) {
       int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i]= getInt();
        }
        return a;
    }
//Hiển thị mảng   
    private static void display(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if(i<a.length-1) System.out.print(", ");
        }
        System.out.print("]");
    }
//Thuật toán SelectionSort 
    private static void SelectionSort(int[] a) {
        int i;
       
        for (i = 0; i < a.length-1; i++)
        {
            // Tim so be nhat trong mang
            int min_idx = i;
            for (int j = i+1; j < a.length; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;
 
            // Swap vs phan tu dau tien
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
        System.out.println();
    }
// --------------------Main----------------------

    public static void main(String[] args) {
        System.out.println("Enter number of array: ");
        int n = getInt();
        int[] a = inputValueOfArray(n);
        System.out.print("Unsorted array: ");
        display(a);
        SelectionSort(a);
        System.out.print("Sorted array: ");
        display(a);
    }  
}
    

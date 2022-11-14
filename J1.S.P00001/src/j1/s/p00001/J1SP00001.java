package j1.s.p00001;

import java.util.Random;
import java.util.Scanner;


public class J1SP00001 {
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
//Nhập size cho mảng 
    private static int inputSizeOfArray() {
        int n;
        do{
            System.out.println("Enter number of array: ");
            n = getInt();
        }while(n<=0);
        return n;
    }
//Giá trị cho mảng theo random 
    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        Random result = new Random();
        for (int i = 0; i < n; i++) {
            a[i]=result.nextInt(n)+1   ;   
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
//Thuật toán BubbleSort 
    private static void BubbleSort(int[] a) {
        int i;
        for ( i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
    }
// --------------------Main----------------------

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = inputValueOfArray(n);
        System.out.print("Unsorted array: ");
        display(a);
        BubbleSort(a);
        System.out.print("Sorted array: ");
        display(a);
    }  
}
 
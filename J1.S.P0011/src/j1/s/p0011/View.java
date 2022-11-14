/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author BBBGARDEN
 */
public class View {
    //Check nhập số nguyên
    public static int getInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(msg);

            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.out.println("Out of range");
                }

            } catch (NumberFormatException e) {
                System.out.println(e);
            }

        } while (true);
    }
    //Check nhập số thưc 
    public static double getDouble(String msg, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double n;

        do {
            System.out.println(msg);
            try {
                n = Double.parseDouble(sc.nextLine());

                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.out.println("Out of range");
                }

            } catch (NumberFormatException e) {

                System.out.println(e);
            }

        } while (true);
    }
    //Check nhập chuỗi 
    public static String getString(String msg, boolean isEmpty) {
        Scanner sc = new Scanner(System.in);

        String s;

        do {
            System.out.println(msg);
            s = sc.nextLine();

            if (isEmpty == true) {
                return s;
            } else {
                if (s.trim().equals("")) {
                    System.out.println("String must have atleast 1 character!");
                } else {
                    return s;
                }
            }

        } while (true);
    }
    //Check nhập chuỗi bới regex 
    public static String getStringByRegex(String msg, String Patt) {
        String s;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(msg);
            s = sc.nextLine();
            if (Pattern.matches(Patt, s)) {
                return s;
            } else {
                System.out.println("Wrong format");
            }

        } while (true);
    }

}

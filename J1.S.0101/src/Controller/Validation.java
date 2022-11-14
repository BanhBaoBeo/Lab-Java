/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author BBBGARDEN
 */
public class Validation {

    public static final String PHONE_PATTERN = "^[\\d]{10}$";
    public static final String EMAIL_PATTERN = "^\\w+@\\w+(\\.\\w+){1,2}$";
// Check nhập số nguyên 
    public static int getInt(String msg, int min, int max) {
        int i;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(msg);
            try {
                i = Integer.parseInt(sc.nextLine());
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.out.println("Out of range");
                }

            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        } while (true);
    }
    //Check nhập số thực 
    public static double getDouble(String msg, double min, double max) {
        double i;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(msg);
            try {
                i = Double.parseDouble(sc.nextLine());
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.out.println("Out of range");
                }

            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        } while (true);
    }
    //Check nhập string   
    public static String getString(String msg, boolean isEmpty) {

        String s;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(msg);
            s = sc.nextLine();
            if (isEmpty == true) {
                return s;
            } else {
                if (s.equals("")) {
                    System.err.println("String must have atleast 1 character");
                    System.out.println(msg);
                } else {
                    return s;
                }
            }

        } while (true);
    }
    //Check ngày tháng
    public static Date getDate(String msg, String dateFomart) {
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat(dateFomart); 
        SDF.setLenient(false);
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(msg);
            String sDate = sc.nextLine();
            try {
                date = SDF.parse(sDate);
                return date;
            } catch (ParseException e) {
                System.out.print(e);
            }
        } while (true);

    }
    //Check chuổi nhập vào bới regex 
    public static String getStringByRegex(String msg, String Patt) {
        String s;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(msg);
            try {
                s = sc.nextLine();
                if (Pattern.matches(Patt, s) == true) {
                    return s;
                }
            } catch (Exception e) {
                System.out.print(e);
            }
        } while (true);
    }

}

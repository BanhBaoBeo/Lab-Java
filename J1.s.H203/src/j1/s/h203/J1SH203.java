/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h203;

import java.util.Scanner;

/**
 *
 * @author BBBGARDEN
 */
public class J1SH203 {

    public static String getString(boolean isLoop) {
        Scanner sc = new Scanner(System.in);
        String result = null;

        do {

            try {
                result = sc.nextLine();
                if (result.trim().isEmpty()) {
                    System.err.println("You must enter a not empty string");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("You must enter a string");
            }
        } while (isLoop);

        return result;
    }

    public static void printReverse(String string) {
        while (string.isEmpty()) {
            System.err.println("String is now empty, try to enter again: ");
            string = getString(string.isEmpty() == true);
        }
        String str = "";
        String[] src = string.split("\\s+");

        for (int i = src.length - 1; i >= 0; i--) {
            str += src[i] + " ";
        }

        String[] src1 = str.split("\\s+");

        str = "";

        for (int i = 0; i < src1.length; i++) {
            if (src1[i].endsWith(".") || src1[i].endsWith("?") || src1[i].endsWith("!")
                    || src1[i].endsWith(";") || src1[i].endsWith(",")) {
                src1[i] = src1[i].substring(0, src1[i].length() - 1);
            }
            if (src[i].charAt(src[i].length() - 1) == '.' || src[i].charAt(src[i].length() - 1) == '?'
                    || src[i].charAt(src[i].length() - 1) == '!' || src[i].charAt(src[i].length() - 1) == ';'
                    || src[i].charAt(src[i].length() - 1) == ',') {
                src1[i] = src1[i] + src[i].charAt(src[i].length() - 1);
            }
            src1[i] = src1[i].toLowerCase();
        }
        src1[0] = src1[0].substring(0, 1).toUpperCase() + src1[0].substring(1);
        for (int i = 0; i < src1.length - 1; i++) {
            if (src1[i].endsWith(".") || src1[i].endsWith("?") || src1[i].endsWith("!")
                    || src1[i].endsWith(";")) {
                src1[i + 1] = src1[i + 1].substring(0, 1).toUpperCase() + src1[i + 1].substring(1).toLowerCase();
            }
        }
        for (int i = 0; i < src1.length; i++) {
            str += src1[i] + " ";
        }
        System.out.println(str.trim());
    }

    public static void main(String[] args) {
        printReverse("hello there. abc xyz.");

    }
}


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BBBGARDEN
 */
public class Main {
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
        string= string.trim();
        StringBuilder tmp = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            tmp.append(string.charAt(i));
        }
        System.out.print("String after reverse: "+tmp);
        
    }
    public static void main(String[] args) {
        printReverse("");

    }
}

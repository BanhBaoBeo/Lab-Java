/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

import java.util.Scanner;

/**
 *
 * @author BBBGARDEN
 */
public class View {
    private final Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("💌==========Calculator Program==========💌\n"
                + "1. Addidion matrix.\n"
                + "2. Subtraction matrix.\n"
                + "3. Multiplication matrix.\n"
                + "4. Exit.\n");
        return checkInputChoice("Enter your choice: ", 1, 4);
    }

    public String checkInputString(String message) {
        while (true) {
            System.out.print(message);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Please give value, don't leave it empty.");
            } else {
                return result;
            }
        }
    }

    public int checkInputChoice(String message, int min, int max) {
        System.out.print(message);
        while (true) {
            try {
                String size = sc.nextLine().trim();
                int price = Integer.parseInt(size);
                if (price < min || price > max) {
                    throw new Exception();
                }
                return price;
            } catch (Exception e) {
                System.err.printf("Please enter your choice between [%d,%d]: ", min, max);
            }
        }
    } 

    public int checkInputNumber(String message, boolean check) {
        while (true) {
            try {
                int number = Integer.parseInt(checkInputString(message));
                if (number < 0 && !check) {
                    System.out.println("That value must be > 0");
                    continue;
                }
                return number;

            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit.Plaease get emter number!");
            }
        }
    }

    public int[][] inputMatrix(int i_th) {
        int row_1 = checkInputNumber("Enter row value of matrix " + i_th + ": ", false);
        int col_1 = checkInputNumber("Enter column value of matrix " + i_th + ": ", false);
        int[][] Matrix_x = new int[row_1][col_1];
        for (int i = 0; i < row_1; i++) {
            for (int j = 0; j < col_1; j++) {
                Matrix_x[i][j] = checkInputNumber(String.format("Enter matrix_" + i_th + " [%d][%d]: ", i + 1, j + 1), true);
            }
        }
        return Matrix_x;
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.format("[%d]", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void displayResult(int[][] Matrix_1, int[][] Matrix_2, int[][] Result, String Controler) {
        System.out.println("=======Result=======");
        displayMatrix(Matrix_1);
        System.out.println(Controler);
        displayMatrix(Matrix_2);
        System.out.println("=");
        displayMatrix(Result);
        System.out.println();
    }  
    
}

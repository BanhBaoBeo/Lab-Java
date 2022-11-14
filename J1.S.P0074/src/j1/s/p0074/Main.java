/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author BBBGARDEN
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Controler Controler = new Controler();
        View view = new View();

        while (true) {
            int choice = view.menu();
            switch (choice) {
                case 1: {
                    System.out.println("--------Addition Matrix--------");
                    int[][] Matrix_1 = view.inputMatrix(1);
                    int[][] Matrix_2 = view.inputMatrix(2);
                    int[][] Result = Controler.additionMatrix(Matrix_1, Matrix_2);
                    if (Result != null) {
                        view.displayResult(Matrix_1, Matrix_2, Result, "+");
                    } else {
                        System.err.println("Two matrices must have the same dimensions to add.\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("--------Subtraction Matrix--------");
                    int[][] Matrix_1 = view.inputMatrix(1);
                    int[][] Matrix_2 = view.inputMatrix(2);
                    int[][] Result = Controler.subtractionMatrix(Matrix_1, Matrix_2);
                    if (Result != null) {
                        view.displayResult(Matrix_1, Matrix_2, Result, "-");
                    } else {
                        System.err.println("Two matrices must have the same dimensions to subtract.\n");
                    }
                    break;
                }
                case 3: {
                    System.out.println("--------Multiplication Matrix--------");
                    int[][] Matrix_1 = view.inputMatrix(1);
                    int[][] Matrix_2 = view.inputMatrix(2);
                    int[][] Result = Controler.multiplicationMatrix(Matrix_1, Matrix_2);
                    if (Result != null) {
                        view.displayResult(Matrix_1, Matrix_2, Result, "*");
                    } else {
                        System.err.println("The number of columns in the first matrix must be equal to the number of rows in the second matrix.\n");
                    }
                    break;
                }
                case 4:
                    return;
            }
        }
    }

}

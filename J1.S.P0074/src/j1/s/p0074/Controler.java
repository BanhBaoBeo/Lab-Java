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
public class Controler {
    private int[][] Result;

    public int[][] additionMatrix(int[][] Matrix_1, int[][] Matrix_2) {
        if (Matrix_1.length != Matrix_2.length
                || Matrix_1[0].length != Matrix_2[0].length) {
            return null;
        }
        int row = Matrix_1.length;
        int col = Matrix_1[0].length;
        Result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Result[i][j] = Matrix_1[i][j] + Matrix_2[i][j];
            }
        }
        return Result;
    }

    public int[][] subtractionMatrix(int[][] Matrix_1, int[][] Matrix_2) {
        if (Matrix_1.length != Matrix_2.length
                || Matrix_1[0].length != Matrix_2[0].length) {
            return null;
        }
        int row = Matrix_1.length;
        int col = Matrix_1[0].length;
        Result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Result[i][j] = Matrix_1[i][j] - Matrix_2[i][j];
            }
        }
        return Result;
    }

    public int[][] multiplicationMatrix(int[][] Matrix_1, int[][] Matrix_2) {
        if (Matrix_1[0].length != Matrix_2.length) {       
            return null;
        }
        int row = Matrix_1.length;
        int col = Matrix_2[0].length;
        Result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < Matrix_2.length; k++) {
                    Result[i][j] += Matrix_1[i][k] * Matrix_2[k][j]; 
                }
            }
        }
        return Result;
    }

    
}


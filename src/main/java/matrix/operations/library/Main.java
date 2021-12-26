/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.operations.library;

import java.util.Random;

/**
 *
 * @author kneiv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        int[][] matrix2 = new int[9][7];
        
        Random r = new Random();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt(10);
            }
        }
        
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = r.nextInt(10);
            }
        }
        
        Matrix m = new Matrix(matrix);
        m.print();
        System.out.println("");
        m.print(matrix2);
        
        System.out.println("");
        System.out.println("Multiplied matrices");
        m.print(m.multiplyMatrices(matrix2));
        System.out.println("");
        m.print(m.multiplyMatrices(matrix, matrix2));
                
    }
    
}

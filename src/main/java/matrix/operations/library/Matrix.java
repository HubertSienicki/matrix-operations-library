/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.operations.library;

/**
 *
 * @author kneiv
 */
public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    /*TODO:
        1.Matrix printing : DONE
        2.Matrix multiplication : DONE
        3.Matrix addition : 
        4.Matrix subtraction
        5.Matrix inversion
        6.Matrix patrial inversion
        7.Matrix transposition
        8.Equation solving using matrices
        9.Changing element at index
        10.Merging two matrices together at an index
        11.Removing certain number from a matrix
        12.Adding a number to an index
        13.Multiply all
    */
    
    //Function for printing out loaded matrix
    public void print(){
        for(int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }
    
     public void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }
    
    
    public int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix){
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];
        
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiplyCells(firstMatrix, secondMatrix, i, j);
            }
        }
        return result;
    }
    
    public int[][] multiplyMatrices(int[][] secondMatrix){
        int[][] result = new int[this.matrix.length][secondMatrix[0].length];
        
        for (int i = 0; i < result.length ; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiplyCells(this.matrix, secondMatrix, i, j);
            }
        }
        return result;
    }
    
    public int[][] addMatrices(int[][] secondMatrix){
        int[][] result = new int[this.matrix.length][secondMatrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = this.matrix[i][j] + secondMatrix[i][j];
            }
        }
        return result;
    }
    
    public int[][] addMatrices(int[][] firstMatrix, int[][] secondMatrix){
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = this.matrix[i][j] + secondMatrix[i][j];
            }
        }
        return result;
    }        
    
    
    
    
    
    
    
    
    //---------Helper Methods-----------//
    
    //Used in matrix multiplication to multiply row of cells
    private int multiplyCells(int[][] firstMatrix, int[][] secondMatrix, int row, int col){
        int cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }
    
    //returns dimension of a matrix
    private int calculateDimensions(int[][] matrix){
        int result;
        result = matrix.length * matrix[0].length;
        return result;
    }
}

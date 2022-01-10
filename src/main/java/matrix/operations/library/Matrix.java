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

    public Matrix() {

    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    /* MAKE GENERIC */
    
    /*TODO:
        1.Matrix printing : DONE
        2.Matrix multiplication : DONE
        3.Matrix addition : DONE (throws an array index out of bounds exception when both matrices hav different dimenstions)
        4.Matrix subtraction : DONE
        5.Matrix inversion : (int)DONE, (double)TODO
        7.Matrix transposition : DONE
        8.Equation solving using matrices
        9.Changing element at index
        10.Merging two matrices together at an index
        11.Removing certain number from a matrix
        12.Adding a number to an index
        13.Multiply all
        14.SORT matrices
     */

    //Function for printing out loaded matrix
    public void print() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiplyCells(firstMatrix, secondMatrix, i, j);
            }
        }
        return result;
    }

    public int[][] multiplyMatrices(int[][] secondMatrix) {
        int[][] result = new int[this.matrix.length][secondMatrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiplyCells(this.matrix, secondMatrix, i, j);
            }
        }
        return result;
    }

    public int[][] addMatrices(int[][] secondMatrix) {
        int[][] result = new int[this.matrix.length][secondMatrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = this.matrix[i][j] + secondMatrix[i][j];
            }
        }
        return result;
    }

    public int[][] addMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = this.matrix[i][j] + secondMatrix[i][j];
            }
        }
        return result;
    }

    //subtracts a variable matrix from a loaded matrix
    public int[][] subtract(int[][] secondMatrix) {
        int[][] result = new int[this.matrix.length][secondMatrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = this.matrix[i][j] - secondMatrix[i][j];
            }
        }
        return result;
    }

    //subtracts an two matrices from eachother
    public int[][] subtract(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return result;
    }
    
    public int[][] invert(int matrix[][]){
        int n = matrix.length;
        int x[][] = new int[n][n];
        int b[][] = new int[n][n];
        int index[] = new int [n];
        for (int i = 0; i < n; i++)
            b[i][i] = 1;
        
        gaussianPivoting(matrix, index);
        
        for (int i = 0; i < n-1; i++) 
            for (int j = i+1; j < n; j++) 
                for (int k = 0; k < n; k++) 
                    b[index[j]][k] -= matrix[index[i]][k];
        
        for (int i = 0; i < n; i++) {
            x[n-1][i] = b[index[n-1]][i] / matrix[index[n-1]][n-1];
            
            for (int j = n-2; j >= 0; j--) {
                x[j][i] = b[index[j]][i];
            
                for (int k = j+1; k < n; k++) {
                    x[j][i] -= matrix[index[j]][k] * x[k][i];
                }
                x[j][i] /= matrix[index[j]][j];
            }
        }
        return x;
    }
    
    public int[][] transpose(){
        int[][] transpose = new int[this.matrix.length][this.matrix[0].length];
        
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                transpose[i][j] = this.matrix[j][i];
            }
        }
        return transpose;
    }
    
    public int[][] transpose(int[][] matrix){
        int[][] transpose = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }
    
    //---------Helper Methods-----------//
    //Used in matrix multiplication to multiply row of cells
    private int multiplyCells(int[][] firstMatrix, int[][] secondMatrix, int row, int col) {
        int cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    //returns dimension of a matrix
    private int calculateDimensions(int[][] matrix) {
        int result;
        result = matrix.length * matrix[0].length;
        return result;
    }
    
    private int findOrder(int[][] matrix){
        return matrix.length;
    }
    
    //only works for square matrices (N is the order of the square matrix) 
    private int findDeterminant(int[][] matrix, int N) {
        int det;
        switch (N) {
            case 1 ->
                det = matrix[0][0];
            case 2 ->
                det = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
            default -> {
                det = 0;
                for (int j1 = 0; j1 < N; j1++) {
                    int[][] m = new int[N - 1][];
                    for (int k = 0; k < (N - 1); k++) {
                        m[k] = new int[N - 1];
                    }
                    for (int i = 1; i < N; i++) {
                        int j2 = 0;
                        for (int j = 0; j < N; j++) {
                            if (j == j1) {
                                continue;
                            }
                            m[i - 1][j2] = matrix[i][j];
                            j2++;
                        }
                    }
                    det += Math.pow(-1.0, 1.0 + j1 + 1.0) * matrix[0][j1] * findDeterminant(matrix, N-1);
                }
            }
        }
        return det;
    }
    
    //gaussian partial pivoitng 
    private void gaussianPivoting(int[][] matrix, int[] index){
        int n = index.length;
        int c[] = new int[n];
 
    // Initialize the index
           for (int i=0; i<n; ++i) 
               index[i] = i;

    // Find the rescaling factors, one from each row
           for (int i=0; i<n; ++i) 
           {
               int c1 = 0;
               for (int j=0; j<n; ++j) 
               {
                   int c0 = Math.abs(matrix[i][j]);
                   if (c0 > c1) c1 = c0;
               }
               c[i] = c1;
           }

    // Search the pivoting element from each column
           int k = 0;
           for (int j=0; j<n-1; ++j) 
           {
               int pi1 = 0;
               for (int i=j; i<n; ++i) 
               {
                   int pi0 = Math.abs(matrix[index[i]][j]);
                   pi0 /= c[index[i]];
                   if (pi0 > pi1) 
                   {
                       pi1 = pi0;
                       k = i;
                   }
               }

      // Interchange rows according to the pivoting order
               int itmp = index[j];
               index[j] = index[k];
               index[k] = itmp;
               for (int i=j+1; i<n; ++i) 	
               {
                   int pj = matrix[index[i]][j]/matrix[index[j]][j];

    // Record pivoting ratios below the diagonal
                   matrix[index[i]][j] = pj;

    // Modify other elements accordingly
                   for (int l=j+1; l<n; ++l)
                       matrix[index[i]][l] -= pj*matrix[index[j]][l];
               }
           }
       }
   }

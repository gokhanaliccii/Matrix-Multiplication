package utility;

import java.util.Random;

/**
 * Created by Gökhan on 11/17/2014.
 */
public class MatrixUtility {

    public static final int DEFAULT_PRECISION = 10;

    public int[][] getPartOfMatrix(int[][] matrix, int size, int part) {
        if (matrix == null)
            return null;

        int[][] newMatrix = new int[size][matrix[0].length];

        for (int i = part * size, j = 0; i < (part + 1) * size; i++, j++) {
            System.arraycopy(matrix[i], 0, newMatrix[j], 0, matrix[i].length);
        }

        return newMatrix;
    }

    public int[][] createRandomIntMatrix(int row, int column, int precision) {
        int[][] newMatrix = new int[row][column];

        Random random = new Random();

        //assigning new random values
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newMatrix[i][j] = random.nextInt(precision);
            }
        }

        return newMatrix;
    }

    public int[][] createRandomIntMatrix(int row, int column) {
        return createRandomIntMatrix(row, column, DEFAULT_PRECISION);
    }

    public void printMatrix(int[][] matrix) {
        if (matrix == null)
            return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean saveMatrix(String fileName, int[][] matrix) {
        return new FileUtility().writeToFile(fileName, matrix);
    }

    public int[][] multiplexingMatrices(int[][] matrix1, int[][] matrix2) {

        if (matrix1 == null || matrix2 == null)
            return null;

        if (matrix1[0].length != matrix2.length)
            return null;

        int[][] newMatrix = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    newMatrix[i][j] += (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }

        return newMatrix;
    }

    public synchronized int[][] pushNewMatrix(int[][] newMatrix, int[][] srcMatrix,int part) {

        int currentPoint=part * newMatrix.length;

        for (int i = 0; i <newMatrix.length ; i++) {
            System.arraycopy(newMatrix[i],0,srcMatrix[currentPoint],0,newMatrix[i].length);
            currentPoint++;
        }

        return srcMatrix;
    }

    public int nearestPrime(int size, int partitionQuantity) {
        while (true) {
            if (size % partitionQuantity == 0)
                break;
            ;
            ++partitionQuantity;
        }
        return partitionQuantity;
    }
}

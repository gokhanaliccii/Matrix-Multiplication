package server;

/**
 * Created by Gökhan on 11/16/2014.
 */
public class Calculation {
    public boolean isMultipleMatrices(int[][] first, int[][] second) {
        return first[0].length == second.length;
    }

    private int[] multiplication(int[] row, int[][] secondMatrix) {
        if (row == null)
            return null;

        int[] newMatrix = new int[secondMatrix[0].length];

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < row.length; j++) {
                newMatrix[i] += (row[j] * secondMatrix[j][i]);
            }

        }

        return newMatrix;
    }

    public int[][] multiplicationMatrices(int[][] first, int[][] second) {

        if (first == null || second == null)
            return null;

        if (!isMultipleMatrices(first, second))
            return null;

        int newMatrix[][] = new int[first.length][second[0].length];

        for (int i = 0; i < newMatrix.length; i++) {
            newMatrix[i] = multiplication(first[i], second);
        }
        return newMatrix;
    }


}

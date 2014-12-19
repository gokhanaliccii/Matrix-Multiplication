package server;

import utility.MatrixUtility;

/**
 * Created by Gökhan on 11/25/2014.
 */
public class MatrixDivider extends Thread {
    private int[][] first, result;
    private int size, part;

    public MatrixDivider(int[][] first, int size, int part) {
        this.first = first;
        this.part = part;
        this.size = size;
    }



    public int getPart() {
        return part;
    }

    public int[][] getResult() {
        return result;
    }

    @Override
    public void run() {
        System.out.println(size +"  "+part);
        MatrixUtility utility = new MatrixUtility();
        result = utility.getPartOfMatrix(first, size, part);

    }
}

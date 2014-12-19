package server;

import utility.FileUtility;

/**
 * Created by Gökhan on 11/25/2014.
 */
public class Writer extends Thread {

    FileUtility fileUtility;
    String fileNane;
    int[][] matrix;

    public Writer(String filename, int[][] matrix) {
        this.fileNane = filename;
        this.matrix = matrix;
        this.fileUtility = new FileUtility();
    }

    public boolean write() {
        start();
        try {
            join();
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        fileUtility.writeToFile(fileNane, matrix);
        return;
    }
}

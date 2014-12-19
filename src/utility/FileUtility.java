package utility;

import java.io.*;

/**
 * Created by Gökhan on 11/18/2014.
 */
public class FileUtility {

    /**
     * read files from specified path
     *
     * @param filePath
     * @return
     */
    public String readFile(String filePath) {

        File yourFile = new File(filePath);

        if (!yourFile.exists())
            return null;


        StringBuilder sb = new StringBuilder();

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(yourFile));
        } catch (FileNotFoundException e) {
            return null;
        }

        String row = "";

        try {
            while ((row = bufferedReader.readLine()) != null) {
                sb.append(row + "\n");
            }

            bufferedReader.close();

        } catch (IOException e) {
        }

        return sb.toString();
    }

    /**
     * Write text into specified path
     *
     * @param filename
     * @param text
     * @return status
     */
    public boolean writeToFile(String filename, String text) {

        File file = new File(filename);

        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e1) {
                return false;
            }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.append(text);

            bufferedWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean writeToFile(String filename, int[][] matrix) {

        if (matrix == null)
            return false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }

        return writeToFile(filename,sb.toString());
    }


}

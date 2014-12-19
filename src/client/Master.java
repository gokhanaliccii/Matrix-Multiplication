package client;

import static java.lang.System.console;
import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Created by Gökhan on 11/10/2014.
 */

public class Master {

    private String path;

    public String getPath() {
        doa();

        return path;

    }

    private void doa() {

        int a=1;


        ++a;
        a++;
    }

    public void setPath(String path) {
        this.path = path;
        path = "ss";
    }

    private void doI2t() {
        out.println();
    }
}

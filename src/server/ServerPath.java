package server;

/**
 * Created by Gökhan on 11/19/2014.
 */
public class ServerPath {

    public static final String MACHINE_1_URL = "http://192.168.126.128:8080/MultiplicationService/MultiplicationService?wsdl";
    public static final String MACHINE_2_URL = "http://192.168.1.222:8084/MultiplicationService/MultiplicationService?wsdl";
    private static final int MACHINE_PATH_QUANTITY = 2;

    public static String getMachine1Url() {
        return MACHINE_1_URL;
    }

    public static String getMachine2Url() {
        return MACHINE_2_URL;
    }

    public static String getServerPathByIndex(int index) {
        index = index % MACHINE_PATH_QUANTITY;

        switch (index) {
            case 0:
                return MACHINE_1_URL;
            case 1:
                return MACHINE_2_URL;
            default:
                return MACHINE_1_URL;
        }

    }
}
package example;

import com.google.gson.GsonBuilder;
import service.MultiplicationService_PortType;
import service.MultiplicationService_ServiceLocator;
import utility.GsonUtility;
import utility.MatrixUtility;

/**
 * Created by G�khan on 11/19/2014.
 */
public class HelloWorldClient {
    public static void main(String[] argv) {
        try {
            MultiplicationService_ServiceLocator locator = new MultiplicationService_ServiceLocator();
            MultiplicationService_PortType service = locator.getMultiplicationServicePort();



        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }
}

package service;

import com.google.gson.GsonBuilder;
import listener.MatrixResponseListener;
import server.ServerPath;
import utility.GsonUtility;
import utility.MatrixUtility;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * Created by Gökhan on 11/19/2014.
 */
public class Matrixservice {
    private MatrixResponseListener responseListener;

    public Matrixservice(MatrixResponseListener responseListener) {
        this.responseListener = responseListener;
        if (responseListener == null) {
            throw new IllegalStateException("listener have to implement");
        }
    }

    public void invokeService(int[][] f, int[][] s) {
        try {
            MatrixUtility utility = new MatrixUtility();
            System.out.println("service");
            utility.printMatrix(f);
            System.out.println("-");
            utility.printMatrix(s);
            System.out.println("service called");


            MultiplicationService_ServiceLocator locator = new MultiplicationService_ServiceLocator();
            MultiplicationService_PortType service = locator.getMultiplicationServicePort();

            long startTime = System.currentTimeMillis();

            String fjson = GsonUtility.convertJson(f);
            String sjson = GsonUtility.convertJson(s);

            String response = service.multiplication(fjson, sjson);
            long finishTime = System.currentTimeMillis() - startTime;


            responseListener.onServiceReplied(response);
            responseListener.onPassedTime(finishTime);

            int[][] result = new GsonBuilder().create()
                    .fromJson(response, f.getClass());

            responseListener.onServiceReplied(result);
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }


    }


    public void hello() {
        try {
            System.out.println("a1");
            URL url = new URL(ServerPath.getMachine1Url());
            System.out.println("a2");
            MultiplicationService_ServiceLocator locator = new MultiplicationService_ServiceLocator();
            System.out.println("a3");
            MultiplicationService_PortType service = locator.getMultiplicationServicePort(url);
            System.out.println("a4");
            try {
                String response = service.hello("merhab uzeyir");
                System.out.println("giden:" + "merhab uzeyir");
                System.out.println("glen:" + response);
            } catch (RemoteException e) {
                e.printStackTrace();
                System.out.println("c1");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("c2");
        } catch (ServiceException e) {
            e.printStackTrace();
            System.out.println("c3");
        }

    }

    public void invokeRemoteService(String urlPath, int[][] f, int[][] s) {
        try {
            URL url = new URL(urlPath);
            MultiplicationService_ServiceLocator locator = new MultiplicationService_ServiceLocator();
            MultiplicationService_PortType service = locator.getMultiplicationServicePort(url);

            long startTime = System.currentTimeMillis();

            String fjson = GsonUtility.convertJson(f);
            String sjson = GsonUtility.convertJson(s);

            String response = service.multiplication(fjson, sjson);
            long finishTime = System.currentTimeMillis() - startTime;


            responseListener.onServiceReplied(response);
            responseListener.onPassedTime(finishTime);

            int[][] result = new GsonBuilder().create()
                    .fromJson(response, f.getClass());

            responseListener.onServiceReplied(result);
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            System.out.println("Unexpected url");
        }


    }

}

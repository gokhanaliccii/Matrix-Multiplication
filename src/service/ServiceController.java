package service;

import listener.MatrixResponseListener;
import server.MatrixDivider;
import server.ServerPath;
import server.Writer;
import utility.MatrixUtility;

import java.util.ArrayList;

/**
 * Created by Gökhan on 11/25/2014.
 */
public class ServiceController {
    int[][] first;
    int[][] second;
    int[][] result;

    private int size;
    private int machineQuantity = 1;

    public ServiceController(int[][] first, int[][] second) {
        this.first = first;
        this.second = second;
        this.result = new int[first.length][second[0].length];
        init();
    }

    public ServiceController(int[][] first, int[][] second, int machineQuantity) {
        this.first = first;
        this.second = second;
        this.machineQuantity = machineQuantity;
        this.result = new int[first.length][second[0].length];
        init();
    }


    private void init() {
        MatrixUtility utility = new MatrixUtility();
        size = first.length;
        machineQuantity = utility.nearestPrime(size, machineQuantity);
        size /= machineQuantity;

    }

    public int[][] executeRemoteService() {

        long ct = System.currentTimeMillis();

        //saving files
        new Writer("m1-" + ct + "-" + ".txt", first).write();
        new Writer("m2-" + ct + "-" + ".txt", second).write();


        ArrayList<MatrixDivider> dividers = new ArrayList<MatrixDivider>();

        MatrixUtility utility = new MatrixUtility();


        for (int i = 0; i < machineQuantity; i++) {
            MatrixDivider divider = new MatrixDivider(first, size, i);
            dividers.add(divider);

            divider.start();
        }

        ArrayList<ServiceInvoker> invokers = new ArrayList<ServiceInvoker>();


        for (int i = 0; i < dividers.size(); i++) {
            MatrixDivider divider = dividers.get(i);

            try {
                divider.join();


                ServiceInvoker invoker = new ServiceInvoker(divider.getResult(), second, i);
                invoker.setWsdlPath(ServerPath.getServerPathByIndex(i));
                invoker.start();

                invokers.add(invoker);
            } catch (InterruptedException e) {
            }

        }


        for (int i = 0; i < invokers.size(); i++) {
            ServiceInvoker invoker = invokers.get(i);
            try {
                invoker.join();
                System.out.println("Joined from invoker " + invoker.getPart());
                new Writer("rp-" + ct + "-" + invoker.getPart() + ".txt", invoker.getResult()).write();

                result = utility.pushNewMatrix(invoker.getResult(), result, invoker.getPart());
            } catch (InterruptedException e) {

            }
        }

        new Writer("r-" + ct + ".txt", result).write();
        return result;
    }

    public int[][] executeService() {

        long ct = System.currentTimeMillis();

        ArrayList<MatrixDivider> dividers = new ArrayList<MatrixDivider>();

        MatrixUtility utility = new MatrixUtility();


        for (int i = 0; i < machineQuantity; i++) {
            MatrixDivider divider = new MatrixDivider(first, size, i);
            dividers.add(divider);

            divider.start();
        }

        ArrayList<ServiceInvoker> invokers = new ArrayList<ServiceInvoker>();


        for (int i = 0; i < dividers.size(); i++) {
            MatrixDivider divider = dividers.get(i);

            try {
                divider.join();


                ServiceInvoker invoker = new ServiceInvoker(divider.getResult(), second, i);
                invoker.start();

                invokers.add(invoker);
            } catch (InterruptedException e) {
            }

        }


        for (int i = 0; i < invokers.size(); i++) {
            ServiceInvoker invoker = invokers.get(i);
            try {
                invoker.join();
                System.out.println("Joined from invoker " + invoker.getPart());
                new Writer("rp-" + ct + "-" + invoker.getPart() + ".txt", invoker.getResult()).write();

                result = utility.pushNewMatrix(invoker.getResult(), result, invoker.getPart());
            } catch (InterruptedException e) {

            }
        }

        new Writer("r-" + ct + ".txt", result).write();
        return result;
    }


    private class ServiceInvoker extends Thread implements MatrixResponseListener {
        int[][] first;
        int[][] second;
        int[][] result;
        int part;
        String wsdlPath = ServerPath.getMachine1Url();

        public ServiceInvoker(int[][] first, int[][] second, int part) {
            this.first = first;
            this.second = second;
            this.part = part;
        }

        public void setWsdlPath(String wsdlPath) {
            this.wsdlPath = wsdlPath;
        }

        @Override
        public void run() {
            Matrixservice matrixservice = new Matrixservice(this);
            matrixservice.invokeRemoteService(wsdlPath, first, second);

        }

        @Override
        public void onServiceReplied(int[][] result) {
            this.result = result;
        }

        @Override
        public void onServiceReplied(String result) {

        }

        @Override
        public void onPassedTime(long time) {
            System.out.println(getPart() + " reached data:" + time);

        }

        public int[][] getResult() {
            return result;
        }

        public int getPart() {
            return part;
        }
    }
}

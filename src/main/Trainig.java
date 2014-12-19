package main;

import listener.MatrixResponseListener;
import server.Multiplication;
import service.Matrixservice;
import service.ServiceController;
import utility.MatrixUtility;

/**
 * Created by Gökhan on 11/16/2014.
 */
public class Trainig {


    public static void main(String[] args) {

//
//        final MatrixUtility utility = new MatrixUtility();
        int[][] first = new int[][]{{1,2},{3,4}};
        int[][] second = new int[][]{{1,2},{3,4}};

//
//        ServiceController serviceController = new ServiceController(first, second);
//
//        long start=System.currentTimeMillis();
//        int[][] result = serviceController.executeService();
//        long finish=System.currentTimeMillis();
//        finish-=start;
//
//        System.out.println("Total Time:"+finish);
//        System.out.println("Without \n");


//        Multiplication multiplication=new Multiplication();
//        long  start=System.currentTimeMillis();
//        int[][] result=multiplication.divideAndConquer(first,second);
//        long finish=System.currentTimeMillis();

//        utility.printMatrix(result);

//        finish-=start;
//        System.out.println("Total Time:"+finish);

        System.out.println();

        ServiceController controller=new ServiceController(first,second);
        int[][] result =controller.executeRemoteService();


        MatrixUtility utility=new MatrixUtility();
        System.out.println("birinci");


        utility.printMatrix(first);
        System.out.println("ikinci");
        utility.printMatrix(second);

        System.out.println("sonuc");
        utility.printMatrix(result);



    }


}

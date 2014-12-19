package server;

import utility.MatrixUtility;

import java.util.ArrayList;

/**
 * Created by Gökhan on 11/10/2014.
 */
public class Multiplication {

    public int[][] divideAndConquer(int[][] first, int[][] second) {
        DivideAndConquer divideAndConquer = new DivideAndConquer(first, second);
        divideAndConquer.start();

        try {
            divideAndConquer.join();
        } catch (InterruptedException e) {

        }

        return divideAndConquer.getResult();

    }

    private class DivideAndConquer extends Thread {
        int MAX_THREAD_QUANTITY = 16;
        int[][] first, second, result;
        int size;
        private int partitionQuantity;

        public DivideAndConquer(int[][] first, int[][] second) {

            this.first = first;
            this.second = second;
            this.result = new int[first.length][second[0].length];
            init();
            System.out.println(size+" pq:"+partitionQuantity);
        }

        private void init() {
            size = first.length;
            MatrixUtility utility=new MatrixUtility();
            if (size < 100) {
                partitionQuantity = utility.nearestPrime(size, 2);
                size /= partitionQuantity;
            } else if (size < 500) {
                partitionQuantity = utility.nearestPrime(size, 4);
                size /= partitionQuantity;
            } else if (size < 1500) {
                partitionQuantity = utility.nearestPrime(size, 10);
                size /= partitionQuantity;
            } else if (size < 2000) {
                partitionQuantity = utility.nearestPrime(size, 16);
                size /= partitionQuantity;
            } else if (size < 3000) {
                partitionQuantity = utility.nearestPrime(size, 23);
                size /= partitionQuantity;
            }


        }




        public void setMaxThreadQuantity(int maxThreadQuantity) {
            this.MAX_THREAD_QUANTITY = maxThreadQuantity;
        }

        public int[][] getResult() {
            return result;
        }

        @Override
        public void run() {
            ArrayList<MatrixDivider> dividerThreads = new ArrayList<MatrixDivider>();
            ArrayList<MultiplicationMatrix> multiplexerThreads = new ArrayList<MultiplicationMatrix>();

            for (int i = 0; i < partitionQuantity; i++) {
                dividerThreads.add(new MatrixDivider(first, size, i));
            }


            //starting threads
            for (MatrixDivider divider : dividerThreads) {
                divider.start();
            }

            //waiting for divided result;
            for (MatrixDivider divider : dividerThreads) {
                try {
                    divider.join();
                    MultiplicationMatrix multiplicationMatrix = new MultiplicationMatrix(divider.getResult(), second, divider.getPart());
                    multiplexerThreads.add(multiplicationMatrix);
                    multiplicationMatrix.start();
                } catch (InterruptedException e) {

                }
            }

            MatrixUtility utility = new MatrixUtility();

            //waiting for matrix results
            for (MultiplicationMatrix matrix : multiplexerThreads) {
                try {
                    matrix.join();
                    result = utility.pushNewMatrix(matrix.getResult(), result, matrix.getPart());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        private class MultiplicationMatrix extends Thread {
            private int[][] first, second, result;
            private int part;

            public MultiplicationMatrix(int[][] first, int[][] second, int part) {
                this.first = first;
                this.second = second;
                this.part = part;
            }

            public int[][] getResult() {
                return result;
            }

            public int getPart() {
                return part;
            }

            @Override
            public void run() {
                MatrixUtility utility = new MatrixUtility();
                result = utility.multiplexingMatrices(first, second);

            }


        }


    }

}
package gui;

import listener.NewMultiplicationListener;
import server.Multiplication;
import service.Matrixservice;
import service.ServiceController;
import utility.MatrixUtility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Gökhan on 11/18/2014.
 */
public class ApplicationUi extends DefaultWindow {
    private JPanel panel;
    private JButton new_calculation;
    private JButton multi_machine;
    private JButton localButton;
    private MatrixUtility matrixUtility;

    public ApplicationUi() {
        super("Matrix Multiplication");
        matrixUtility = new MatrixUtility();

        setContentPane(panel);
        pack();

        defaultVisualConfig();
        initButtons();


    }


    private void initButtons() {
        new_calculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NewMatrixInput.showDialog(new NewMultiplicationListener() {
                    @Override
                    public void OnNewMultiplicationListener(int firstWidthSize, int firstHeight, int secondWidth, int secondHeigt) {

                        int[][] first = matrixUtility.createRandomIntMatrix(firstWidthSize, firstHeight);
                        int[][] second = matrixUtility.createRandomIntMatrix(secondWidth, secondHeigt);

                        ServiceController controller=new ServiceController(first,second);
                        JOptionPane.showMessageDialog(ApplicationUi.this, "Matrislerin carpimi basladi");
                        int[][] result=controller.executeRemoteService();

                        JOptionPane.showMessageDialog(ApplicationUi.this, "Matrislerin carpimi tamamlandi");

                    }
                });

            }
        });


        multi_machine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NewMatrixInput.showDialog(new NewMultiplicationListener() {
                    @Override
                    public void OnNewMultiplicationListener(int firstWidthSize, int firstHeight, int secondWidth, int secondHeigt) {

                        int[][] first = matrixUtility.createRandomIntMatrix(firstWidthSize, firstHeight);
                        int[][] second = matrixUtility.createRandomIntMatrix(secondWidth, secondHeigt);

                        ServiceController controller=new ServiceController(first,second,2);

                        JOptionPane.showMessageDialog(ApplicationUi.this, "Matrislerin carpimi basladi");

                        int[][] result=controller.executeRemoteService();

                        JOptionPane.showMessageDialog(ApplicationUi.this, "Matrislerin carpimi tamamlandi");




                    }
                });

            }
        });


        localButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NewMatrixInput.showDialog(new NewMultiplicationListener() {
                    @Override
                    public void OnNewMultiplicationListener(int firstWidthSize, int firstHeight, int secondWidth, int secondHeigt) {

                        int[][] first = matrixUtility.createRandomIntMatrix(firstWidthSize, firstHeight);
                        int[][] second = matrixUtility.createRandomIntMatrix(secondWidth, secondHeigt);


                        Multiplication multiplication = new Multiplication();
                        long start = System.currentTimeMillis();
                        int[][] result = multiplication.divideAndConquer(first, second);
                        long finish = System.currentTimeMillis();


                        JOptionPane.showMessageDialog(ApplicationUi.this, "Matrislerin carpimi tamamlandi  zaman:"+finish);


                    }
                });

            }
        });


    }


}

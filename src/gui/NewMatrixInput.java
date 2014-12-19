package gui;

import listener.NewMultiplicationListener;

import javax.swing.*;
import java.awt.event.*;

public class NewMatrixInput extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField firstWidth;
    private JTextField firstHeight;
    private JTextField secondWidth;
    private JTextField secondHeight;
    private NewMultiplicationListener newMultiplicationListener;

    public NewMatrixInput(NewMultiplicationListener multiplicationListener) {
        if (multiplicationListener == null)
            return;

        this.newMultiplicationListener = multiplicationListener;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void showDialog(NewMultiplicationListener multiplicationListener){

        NewMatrixInput dialog = new NewMatrixInput(multiplicationListener);

        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        int fW = 0;
        int fH = 0;
        int sW = 0;
        int sH = 0;

        try {
            fW = Integer.valueOf(firstWidth.getText()).intValue();
            fH = Integer.valueOf(firstHeight.getText()).intValue();

            sW = Integer.valueOf(secondWidth.getText()).intValue();
            sH = Integer.valueOf(secondHeight.getText()).intValue();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(NewMatrixInput.this, "Gecersiz giris", "HATA",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        if (fW != sH){

            JOptionPane.showMessageDialog(NewMatrixInput.this, "Bu matrisler carpilamaz", "HATA",
                    JOptionPane.ERROR_MESSAGE);
        return;
        }

        newMultiplicationListener.OnNewMultiplicationListener(fW, fH, sW, sH);
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}

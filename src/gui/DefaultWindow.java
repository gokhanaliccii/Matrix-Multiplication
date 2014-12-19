package gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.net.URL;

/**
 * Created by Gökhan on 11/19/2014.
 */
public class DefaultWindow extends JFrame {

    public DefaultWindow() {

    }

    public DefaultWindow(String title) {
        super(title);
    }

    public void defaultVisualConfig() {

        UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.red));
        changeIcon();
        setFixedWindowSize(500, 500);
        centerAtScreen();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void permitAddView(JComponent view) {
        view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
    }


    private void changeIcon() {
        URL iconURL = getClass().getResource("../resources/images/app_default_icon.png");
        if (iconURL == null)
            return;

        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());
    }

    private void setFixedWindowSize(int width, int height) {
        setSize(width, height);
        setMinimumSize(new Dimension(width, 0));
        setMaximumSize(new Dimension(height, Integer.MAX_VALUE));
    }

    private void centerAtScreen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
}

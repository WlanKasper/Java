package wlankasper.com.restaurant.gui;

import javax.swing.*;
import java.awt.*;

public class RestFrame extends JFrame {

    public static final int RESTAURANT_WIDTH = 1200;
    public static final int RESTAURANT_HEIGHT = 800;

    RestPanel restPanel;

    public RestFrame () {
        restPanel = new RestPanel();
        this.add(restPanel);
        this.setTitle("Space Invaders");
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}

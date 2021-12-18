package WlanKasper.com.Restaurant.GameFrame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    RestaurantPanel restaurantPanel;

    public GameFrame () {
        restaurantPanel = new RestaurantPanel();
        this.add(restaurantPanel);
        this.setTitle("Restaurant");
        this.setResizable(false);
        this.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}

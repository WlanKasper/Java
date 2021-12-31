package wlankasper.com.restaurant.gui;

import java.awt.*;

public class RestWalls extends Rectangle {

    String money = "222$";

    public void draw (Graphics g) {
        g.setColor(Color.black);

        // Footer
        g.drawLine(0,700,1200,700);
        g.drawString(money, 550, 750);

        // Kitchen
        g.drawLine(800,400,1200,400);
        g.drawLine(800,400,800,700);
    }
}

package wlankasper.com.restaurant.threads;

import java.awt.*;

public class Chef extends Thread {

    ChefObject chef;

    public Chef () {
        chef = new ChefObject(300, 500);
    }

    @Override
    public void run () {
        super.run();

    }

    public void draw (Graphics g) {
        chef.draw(g);
    }
}

class ChefObject extends Rectangle {
    public static final int CHEF_WIDTH = 25;
    public static final int CHEF_HEIGHT = 25;

    public int xVelocity, yVelocity;

    public ChefObject (int x, int y) {
        super(x, y, CHEF_WIDTH, CHEF_HEIGHT);
    }

    public void setXDirection (int xDirection) {
        xVelocity = xDirection;
    }
    public void setYDirection (int yDirection) {
        yVelocity = yDirection;
    }

    public void move () {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw (Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }

}

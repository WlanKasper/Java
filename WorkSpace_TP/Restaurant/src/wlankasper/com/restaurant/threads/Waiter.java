package wlankasper.com.restaurant.threads;

import java.awt.*;

public class Waiter extends Thread {

    WaiterObject waiter;

    public Waiter () {
        waiter = new WaiterObject(300, 400);
    }

    @Override
    public void run () {
        super.run();
    }

    public void draw (Graphics g){
        waiter.draw(g);
    }

}

class WaiterObject extends Rectangle {
    public static final int WAITER_WIDTH = 25;
    public static final int WAITER_HEIGHT = 25;

    public int xVelocity, yVelocity;

    public WaiterObject (int x, int y) {
        super(x, y, WAITER_WIDTH, WAITER_HEIGHT);
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
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }
}

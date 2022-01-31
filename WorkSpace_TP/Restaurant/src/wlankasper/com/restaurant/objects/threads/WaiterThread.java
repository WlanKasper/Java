package wlankasper.com.restaurant.objects.threads;

import wlankasper.com.restaurant.objects.StandardGraphicsObject;

import java.awt.*;

public class WaiterThread extends Thread {

    Waiter waiter;
    public WaiterThread () {
        waiter = new Waiter(1100, 200,0);
    }

    @Override
    public void run() {
        super.run();
    }

    public void draw(Graphics g){
        waiter.draw(g);
    }
}

class Waiter extends StandardGraphicsObject {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    public Waiter(int x, int y, int id) {
        super(x, y, WIDTH, HEIGHT, id);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, width, height);
    }
}

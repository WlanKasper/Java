package wlankasper.com.restaurant.objects.threads;

import wlankasper.com.restaurant.objects.StandardGraphicsObject;
import wlankasper.com.restaurant.objects.threads.resource.PlateThread;

import java.awt.*;

public class WaiterThread extends Thread {

    PlateThread plate;
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

    public void takePlate (PlateThread plate) {
        this.plate = plate;
        waiter.goTo(plate.getPositionX(), plate.getPositionY());  // можно перегрузить метод и передавать rectangle

    }
}

class Waiter extends StandardGraphicsObject {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    public Waiter(int x, int y, int id) {
        super(x, y, WIDTH, HEIGHT,1, id);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, width, height);
    }
}

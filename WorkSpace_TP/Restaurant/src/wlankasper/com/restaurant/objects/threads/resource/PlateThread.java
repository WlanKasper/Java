package wlankasper.com.restaurant.objects.threads.resource;

import wlankasper.com.restaurant.objects.StandardGraphicsObject;

import java.awt.*;

public class PlateThread extends Thread {

    Plate plate;

    public PlateThread () {
        plate = new Plate(1000, 700, 0);
    }

    @Override
    public void run() {
        super.run();
    }

    public void draw(Graphics g){
        plate.draw(g);
    }

    class Plate extends StandardGraphicsObject {

        public static final int WIDTH = 25;
        public static final int HEIGHT = 25;

        public Plate(int x, int y, int id) {
            super(x, y, WIDTH, HEIGHT, id);
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.green);
            g.fillOval(x, y, width, height);
        }
    }
}

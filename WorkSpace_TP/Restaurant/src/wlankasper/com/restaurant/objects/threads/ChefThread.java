package wlankasper.com.restaurant.objects.threads;

import wlankasper.com.restaurant.objects.StandardGraphicsObject;

import java.awt.*;

public class ChefThread extends Thread {

    private static final int[] WINDOW = {1000, 400};
    private static final int[] STOVE = {850, 650};

    Chef chef;
    int sleepTime = 10;

    public ChefThread() {
        chef = new Chef(1100, 600, 0);
        cook();
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                sleep(sleepTime);

                chef.move();
                chef.checkStatus();
                checkCollins();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics g) {
        chef.draw(g);
    }

    // переделать на достижение точек
    public void checkCollins() {
        if (isAround(chef.x, chef.y, WINDOW[0], WINDOW[1], 10)) {
            chef.setXDirection(0);
            chef.setYDirection(0);
        }

        if (isAround(chef.x, chef.y, STOVE[0], STOVE[1], 10)) {
            chef.setXDirection(0);
            chef.setYDirection(0);
        }
    }

    public void takePlate() {
        chef.goTo(WINDOW[0], WINDOW[1]);
    }

    public void cook() {
        chef.goTo(STOVE[0], STOVE[1]);
        chef.isCooking = true;
    }

    public boolean isAround(int x1, int y1, int x2, int y2, int radius) {
        return (x1 > x2 + radius || x1 < x2 - radius) && (y1 > y2 + radius || y1 < y2 - radius);
    }

}

class Chef extends StandardGraphicsObject {
    public static int WIDTH = 50;
    public static int HEIGHT = 50;

    public boolean isCooking = false;

    public Chef(int x, int y, int id) {
        super(x, y, WIDTH, HEIGHT, 1, id);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, width, height);
    }
}
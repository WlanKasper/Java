package wlankasper.com.restaurant.objects.threads;

import wlankasper.com.restaurant.objects.StandardGraphicsObject;

import java.awt.*;

public class ChefThread extends Thread {

    private static final int windowX = 1000;
    private static final int windowY = 400;

    Chef chef = null;
    int sleepTime = 100;

    public ChefThread() {
        chef = new Chef(1100, 600, 0);
        takePlate();
    }

    @Override
    public void run() {
        super.run();
        while (this.isAlive()) {
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sleepTime = 100;
            chef.move();
            checkCollins();
        }
    }

    public void draw(Graphics g) {
        chef.draw(g);
    }

    public void checkCollins(){
        if (chef.x >= 1200 - chef.width || chef.x <= 800){
            chef.setXDirection(-chef.xDirection);
            sleepTime = 2000;
        }
        if (chef.y >= 700- chef.width || chef.y <= 400){
            chef.setYDirection(-chef.yDirection);
            sleepTime = 2000;
        }
    }

    public void takePlate () {
        chef.goTo(windowX-5, windowY-5);
    }
}

class Chef extends StandardGraphicsObject {
    public static int WIDTH = 50;
    public static int HEIGHT = 50;

    public Chef(int x, int y, int id) {
        super(x, y, WIDTH, HEIGHT, id);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, width, height);
    }
}
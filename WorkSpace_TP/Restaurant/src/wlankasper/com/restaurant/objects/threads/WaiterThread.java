package wlankasper.com.restaurant.objects;

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

class Waiter extends Rectangle {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    private int xVelocity;
    private int yVelocity;

    private final int id;

    public Waiter(int xPos, int yPos, int id) {
        super(xPos, yPos, WIDTH, HEIGHT);
        this.id = id;
    }

    public void draw (Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, width, height);

        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 10));
        g.drawString("Waiter", x + (WIDTH / 2), y + (HEIGHT / 2));
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        x = x + xVelocity;
        y = y + yVelocity;
    }

    public int getId() {
        return id;
    }
}

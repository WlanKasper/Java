package wlankasper.com.restaurant.objects;

import java.awt.*;

public abstract class StandardGraphicsObject extends Rectangle {

    public static final int SPEED = 2;
    public double xDirection; // {-1, 1}
    public double yDirection; // {-1, 1}
    public final int id;

    public StandardGraphicsObject(int x, int y, int width, int height, int id) {
        super(x, y, width, height);
        this.id = id;
    }

    public void draw (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }

    public void setXDirection(double xDirection) {
        this.xDirection = xDirection;
    }

    public void setYDirection(double yDirection) {
        this.yDirection = yDirection;
    }

    public void move() {
        x += xDirection * SPEED;
        y += yDirection * SPEED;
    }

    public void goTo (int x, int y){
        xDirection = Math.cos(Math.atan2((y - this.y), (x - this.x)));
        yDirection = Math.sin(Math.atan2((y - this.y), (x - this.x)));
    }
}

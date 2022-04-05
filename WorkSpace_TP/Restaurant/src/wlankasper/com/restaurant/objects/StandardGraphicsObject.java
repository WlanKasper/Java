package wlankasper.com.restaurant.objects;

import java.awt.*;

public class StandardGraphicsObject extends Rectangle{

    /*
     *  Проблема в Rectangle
     *  Работает с x и y только в INTEGER
     *  Но направление объекта исключительно в Double
     *
     *  Возможное решение: Rectangle.translate()
     *
     * Полезные методы:
     * Rectangle.union()
     */

    private int speed = 5;
    private double xDirection; // {-1, 1}
    private double yDirection; // {-1, 1}

    public final int id;
    public boolean isOccupied = false;

    public StandardGraphicsObject(int x, int y, int width, int height, int speed, int id) {
        super(x, y, width, height);
        this.speed = speed;
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
        x += xDirection * speed;
        y += yDirection * speed;
    }

    public void goTo (int x, int y) {
//        xDirection = Math.cos(Math.atan2((y - this.y), (x - this.x)));
//        yDirection = Math.sin(Math.atan2((y - this.y), (x - this.x)));

        this.translate(x - this.x,y - this.y);
        isOccupied = true;
    }

    public void checkStatus () {
        if (xDirection == 0 && yDirection == 0){
            isOccupied = false;
        }
    }

//    public void isIntersect (Rectangle r){
//        if (this.intersects(r)){
//            xDirection = 0;
//            yDirection = 0;
//        }
//    }
}

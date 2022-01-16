package wlankasper.com.restaurant.objects;

import java.awt.*;

public class Chef extends Rectangle {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    private final int id;

    public Chef (int xPos, int yPos, int id) {
        super(xPos, yPos, WIDTH, HEIGHT);
        this.id = id;
    }

    public void draw (Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, width, height);

        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 10));
        g.drawString("Chef", x + (WIDTH / 2), y + (HEIGHT / 2));
    }


    public int getId() {
        return id;
    }
}

package WlanKasper.com.Restaurant.Objects;

import java.awt.*;

public class Client extends Rectangle {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    private final int id;

    public Client (int x, int y, int id) {
        super(x, y, WIDTH, HEIGHT);
        this.id = id;
    }

    public void draw (Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }


    public int getId() {
        return id;
    }
}

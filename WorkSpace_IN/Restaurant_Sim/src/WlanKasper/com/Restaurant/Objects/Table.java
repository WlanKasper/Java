package WlanKasper.com.Restaurant.Objects;

import java.awt.*;

public class Table extends Rectangle {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    private final int id;

    public Table (int xPos, int yPos, int id) {
        super(xPos, yPos, WIDTH, HEIGHT);
        this.id = id;
    }

    public void draw (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 10));
        g.drawString(String.valueOf(id), x + (WIDTH / 2), y + (HEIGHT / 2));
    }
    

    public int getId() {
        return id;
    }
}

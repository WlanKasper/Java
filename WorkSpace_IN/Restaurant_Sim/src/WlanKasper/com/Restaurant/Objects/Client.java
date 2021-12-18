package WlanKasper.com.Restaurant.Objects;

import java.awt.*;

public class Client extends Rectangle {
    // Добавлять по x и y клиента
    public static final int CLIENT_WIDTH = 50;
    public static final int CLIENT_HEIGHT = 50;

    private final int id;
    private String name;

    public Client (int x, int y, String name, int id) {
        super(x, y, CLIENT_WIDTH, CLIENT_HEIGHT);
        this.name = name;
        this.id = id;
    }

    public void draw (Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }


}

package wlankasper.com.restaurant.gui;

import wlankasper.com.restaurant.threads.Chef;
import wlankasper.com.restaurant.threads.Waiter;

import javax.swing.*;
import java.awt.*;

public class RestPanel extends JPanel implements Runnable {

    private static final Dimension SCREEN_SIZE = new Dimension(RestFrame.RESTAURANT_WIDTH, RestFrame.RESTAURANT_HEIGHT);

    Thread mainThread;
    Chef chef;
    Waiter waiter;

    RestWalls walls;

    Image image;
    Graphics graphics;

    public boolean isRun = false;

    public RestPanel () {
        isRun = true;

        this.setFocusable(true);
        this.setPreferredSize(SCREEN_SIZE);

        mainThread = new Thread(this);
        mainThread.start();

        chef = new Chef();
        chef.start();

        waiter = new Waiter();
        waiter.start();

        walls = new RestWalls();
    }

    @Override
    public void run () {
        while (isRun) {
            repaint();
        }
    }

    public void paint (Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw (Graphics g) {
        chef.draw(g);
        waiter.draw(g);
        walls.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }
}

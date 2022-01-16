package wlankasper.com.restaurant.gui;

import wlankasper.com.restaurant.objects.ClientList;
import wlankasper.com.restaurant.objects.TableList;

import javax.swing.*;
import java.awt.*;

public class RestPanel extends JPanel implements Runnable {

    private static final Dimension SCREEN_SIZE = new Dimension(RestFrame.RESTAURANT_WIDTH, RestFrame.RESTAURANT_HEIGHT);

    Thread mainThread;

    RestWalls walls;

    ClientList clientList;
    TableList tableList;

    Image image;
    Graphics graphics;

    public boolean isRun = false;

    public RestPanel () {
        isRun = true;

        this.setFocusable(true);
        this.setPreferredSize(SCREEN_SIZE);

        mainThread = new Thread(this);
        mainThread.start();

        clientList = new ClientList();
        tableList = new TableList();

        walls = new RestWalls();

        tableList.intiTables();
        clientList.initClients(tableList.getTableList());
    }

    @Override
    public void run () {
        while (isRun) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        walls.draw(g);
        clientList.draw(g);
        tableList.draw(g);

        Toolkit.getDefaultToolkit().sync();
    }
}

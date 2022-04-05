package wlankasper.com.restaurant.gui;

import wlankasper.com.restaurant.objects.threads.WaiterThread;
import wlankasper.com.restaurant.objects.statics.ChairList;
import wlankasper.com.restaurant.objects.statics.TableList;
import wlankasper.com.restaurant.objects.threads.ChefThread;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class RestPanel extends JPanel implements Runnable {

    private static final Dimension SCREEN_SIZE = new Dimension(RestFrame.RESTAURANT_WIDTH, RestFrame.RESTAURANT_HEIGHT);
    // Можно попробовать конвертировать в img и отправить на рендер
    Thread mainThread;

    RestWalls walls;
    ChairList clientList;
    TableList tableList;

    ChefThread chef;
    WaiterThread waiter;

    Image image;
    Graphics graphics;

    public boolean isRun = true;

    public RestPanel() {
        this.setFocusable(true);
        this.setPreferredSize(SCREEN_SIZE);

        mainThread = new Thread(this);
        mainThread.start();

        clientList = new ChairList();
        tableList = new TableList();
        walls = new RestWalls();

        chef = new ChefThread();
        chef.start();

        waiter = new WaiterThread();
        waiter.start();

        tableList.intiTables();
        clientList.initClients(tableList.getTableList());
    }

    @Override
    public void run() {
        while (isRun) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        walls.draw(g);
        clientList.draw(g);
        tableList.draw(g);
        chef.draw(g);
        waiter.draw(g);

        Toolkit.getDefaultToolkit().sync();
    }
}

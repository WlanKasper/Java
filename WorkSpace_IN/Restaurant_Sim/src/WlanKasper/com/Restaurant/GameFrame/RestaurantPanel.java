package WlanKasper.com.Restaurant.GameFrame;

import WlanKasper.com.Restaurant.List.*;
import WlanKasper.com.Restaurant.Objects.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RestaurantPanel extends JPanel implements Runnable {

    // ---------- General Settings ---------- 
    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = 700;
    private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    private boolean isRun = true;

    // ---------- Graphics ---------- 
    private Image image;
    private Graphics graphics;

    // ---------- Treads ---------- 
    Thread restaurantThread;


    Client client;
    ClientList clientList;
    TableList tableList;


    // ---------- Constructor ---------- 
    public RestaurantPanel() {
        this.setFocusable(true);
        this.setPreferredSize(SCREEN_SIZE);

        clientList = new ClientList();
        tableList = new TableList();
        
        restaurantThread = new Thread(this);
        restaurantThread.start();

        tableList.intiTables();
        clientList.initClients(tableList.getTableList());
    }

    @Override
    public void run() {
        while(isRun) {
            try {
                Thread.sleep(100);
                repaint();
            } catch (InterruptedException e) {
                isRun = false;
                e.printStackTrace();
            }

            for (Client iterable_element : clientList.getClientList()) {

                if (new Random().nextBoolean()) {
                    // Добавить

                    // проблема в том что объекту client из списка не присваивается новый объект
                    // возможное решение обращаться из корневого класса списка и менять ссылку объекта на новый
                    if (iterable_element != client){
                        switch ((int) (Math.random() * (1 + 2)) + 1) {
                            case 1 -> {
                                iterable_element = new Omnivorous(iterable_element.x, iterable_element.y, 0);
                            }
                            case 2 -> {
                                iterable_element = new Vegan(iterable_element.x, iterable_element.y, 0);
                            }
                            case 3 -> {
                                iterable_element = new Muslim(iterable_element.x, iterable_element.y, 0);
                            }
                            default -> System.out.println("ERROR!!!!!!!!!!!!!");
                    }
                } else {
                    // Удалить
                        clientList.removeClient(iterable_element.getId());
                }
            }
        }
    }
}

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        clientList.draw(g);
        tableList.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    

    public void init_v1(){
        
    }
}
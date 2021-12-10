package WlanKasper.com.Restaurant.GameFrame;

import WlanKasper.com.Restaurant.Objects.Client;
import WlanKasper.com.Restaurant.Objects.List.ClientList;
import WlanKasper.com.Restaurant.Objects.Muslim;
import WlanKasper.com.Restaurant.Objects.Omnivorous;
import WlanKasper.com.Restaurant.Objects.Vegan;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RestaurantPanel extends JPanel implements Runnable {

    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = 700;
    private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    // Graphics
    private Image image;
    private Graphics graphics;

    // Treads
    Thread gameThread;

    // Objects
    Client client;

    // Objects List
    ClientList clientList;

    public RestaurantPanel () {
        this.setFocusable(true);
        this.setPreferredSize(SCREEN_SIZE);

        clientList = new ClientList();
//        autoCreateClients(20);

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run () {
        int x = 0, y = 0, i = 0, id = 0;
        while (i < 20) {
            try {
                Thread.sleep(100);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (new Random().nextBoolean()) {
                if (x > GAME_WIDTH) {
                    x = 50;
                    y += 50 + 25;

                } else {
                    x = 50*i;
                }
                switch ((int) (Math.random() * (1 + 2)) + 1) {
                    case 1 -> {
                        client = new Omnivorous(x, y, "Artur", id);
                        clientList.addNewClient(client);
                    }
                    case 2 -> {
                        client = new Vegan(x, y, "Artur", id);
                        clientList.addNewClient(client);
                    }
                    case 3 -> {
                        client = new Muslim(x, y, "Artur", id);
                        clientList.addNewClient(client);
                    }
                    default -> System.out.println("ERROR!!!!!!!!!!!!!");
                }
                i++;
            } else {
                // не удоляет самого первого
//                clientList.remove((int) ( Math.random() * i ));
                clientList.remove(i);
                if (i > 0) {
                    i--;
                }
            }
            id++;
        }
    }

    public void paint (Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw (Graphics g) {
        clientList.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

}

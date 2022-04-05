package wlankasper.com.restaurant.objects.statics;

import wlankasper.com.restaurant.objects.StandardGraphicsObject;

import java.awt.*;
import java.util.ArrayList;

public class ChairList {

    private static final int INDENT = 10;

    ArrayList<Chair> clientList;

    public ChairList() {
        clientList = new ArrayList<>();
    }

    public void draw (Graphics g) {
        if (!clientList.isEmpty()) {
            for (Chair client : clientList) {
                client.draw(g);
            }
        }
    }


    public void addClient (Chair client) {
        clientList.add(client);
    }

    public void removeClient (int position) {
        clientList.remove(position);
    }

    public void initClients (ArrayList<TableList.Table> tableList) {
        Chair client;
        int i = 0;
        for (TableList.Table table : tableList) {
            // Верхний
            client = new Chair(table.x + (table.width / 4), table.y - (table.height / 2) - INDENT, i);
            clientList.add(client);
            i++;

            // Нижний
            client = new Chair(table.x + (table.width / 4), table.y + (table.height) + INDENT, i);
            clientList.add(client);
            i++;

            // Левый
            client = new Chair(table.x - client.width - INDENT, table.y + (table.height / 4), i);
            clientList.add(client);
            i++;

            // Правый
            client = new Chair(table.x + table.width + INDENT, table.y + (table.height / 4), i);
            clientList.add(client);
            i++;
        }
    }

    public ArrayList<Chair> getClientList () {
        return clientList;
    }

    public class Chair extends StandardGraphicsObject {
        public static final int WIDTH = 50;
        public static final int HEIGHT = 50;

        public Chair(int x, int y, int id) {
            super(x, y, WIDTH, HEIGHT,1, id);
        }
    }
}

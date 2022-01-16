package wlankasper.com.restaurant.objects;

import java.awt.*;
import java.util.ArrayList;

public class ClientList extends Rectangle {

    private static final int INDENT = 10;

    ArrayList<Client> clientList;

    public ClientList () {
        clientList = new ArrayList<>();
    }

    public void draw (Graphics g) {
        if (!clientList.isEmpty()) {
            for (Client client : clientList) {
                client.draw(g);
            }
        }
    }


    public void addClient (Client client) {
        clientList.add(client);
    }

    public void removeClient (int position) {
        clientList.remove(position);
    }

    public void initClients (ArrayList<TableList.Table> tableList) {
        Client client;
        int i = 0;
        for (TableList.Table table : tableList) {
            // Верхний
            client = new Client(table.x + (table.width / 4), table.y - (table.height / 2) - INDENT, i);
            clientList.add(client);
            i++;

            // Нижний
            client = new Client(table.x + (table.width / 4), table.y + (table.height) + INDENT, i);
            clientList.add(client);
            i++;

            // Левый
            client = new Client(table.x - client.width - INDENT, table.y + (table.height / 4), i);
            clientList.add(client);
            i++;

            // Правый
            client = new Client(table.x + table.width + INDENT, table.y + (table.height / 4), i);
            clientList.add(client);
            i++;
        }
    }

    public ArrayList<Client> getClientList () {
        return clientList;
    }

    public class Client extends Rectangle {
        public static final int WIDTH = 50;
        public static final int HEIGHT = 50;

        private final int id;

        public Client (int x, int y, int id) {
            super(x, y, WIDTH, HEIGHT);
            this.id = id;
        }

        public void draw (Graphics g) {
            g.setColor(Color.gray);
            g.fillRect(x, y, width, height);
        }


        public int getId() {
            return id;
        }
    }
}

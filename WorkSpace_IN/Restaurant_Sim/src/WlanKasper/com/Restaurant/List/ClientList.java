package WlanKasper.com.Restaurant.List;

import WlanKasper.com.Restaurant.Objects.Client;
import WlanKasper.com.Restaurant.Objects.Table;

import java.awt.*;
import java.util.ArrayList;

public class ClientList {

    private static final int INDENT = 10;

    ArrayList<Client> clientList;
    
    public ClientList () {
        clientList = new ArrayList<>();
    }

    public void draw(Graphics g){
        if (!clientList.isEmpty()){
            for (Client client: clientList) {
                client.draw(g);
            }
        }
    }


    public void addClient (Client client){
        clientList.add(client);
    }

    public void removeClient (int position){
        clientList.remove(position);
    }

    public void initClients (ArrayList<Table> tableList) {
        Client client;
        int i = 0;
        for (Table table : tableList) {
            // Верхний
            client = new Client(table.x + (table.width / 4), table.y - (table.height / 2) - INDENT, i);
            clientList.add(client);
            i++;

            // Нижний
            client = new Client(table.x + (table.width / 4), table.y + (table.height) + INDENT, i);
            clientList.add(client);
            i++;

            // Левый
            client = new Client(table.x - client.width - INDENT , table.y + (table.height / 4), i);
            clientList.add(client);
            i++;

            // Правый
            client = new Client(table.x + table.width + INDENT , table.y + (table.height / 4), i);
            clientList.add(client);
            i++;
        }
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }
}

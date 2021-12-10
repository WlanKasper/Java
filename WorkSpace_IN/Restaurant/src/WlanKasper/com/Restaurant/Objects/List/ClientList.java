package WlanKasper.com.Restaurant.Objects.List;

import WlanKasper.com.Restaurant.Objects.Client;

import java.awt.*;
import java.util.ArrayList;

public class ClientList {
    ArrayList<Client> clientList;

    public ClientList () {
        clientList = new ArrayList<>();
    }

    public void addNewClient (Client client){
        clientList.add(client);
    }

    public void remove (int position){
        if (position > 0 && position < clientList.size()){
            clientList.remove(position);
        }
    }

    public void draw(Graphics g){
        if (!clientList.isEmpty()){
            for (Client client: clientList) {
                client.draw(g);
            }
        }
    }
}

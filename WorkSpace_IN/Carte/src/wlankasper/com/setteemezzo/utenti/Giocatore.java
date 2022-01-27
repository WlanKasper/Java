package wlankasper.com.setteemezzo.utenti;

import wlankasper.com.setteemezzo.mazzo.Carta;

import java.util.ArrayList;
import java.util.Collection;

public class Giocatore {
    ArrayList<Carta> mano = null;
    
    public Giocatore () {
        mano = new ArrayList<>();
    }
    
    public void aggiungiCarta(Carta carta){
        mano.add(carta);
    }

    public double contaPunti (){
        double punti = 0;
        for (Carta carta : mano){
            punti += carta.daiValore();
        }
        return punti;
    }
    

}

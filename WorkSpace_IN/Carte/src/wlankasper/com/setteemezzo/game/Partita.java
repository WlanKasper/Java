package wlankasper.com.setteemezzo.game;

import wlankasper.com.setteemezzo.exception.MazzoTerminatoException;
import wlankasper.com.setteemezzo.layout.Console;
import wlankasper.com.setteemezzo.mazzo.Carta;
import wlankasper.com.setteemezzo.mazzo.Mazzo;
import wlankasper.com.setteemezzo.mazzo.MazzoNapoletano;
import wlankasper.com.setteemezzo.mazzo.MazzoNormale;
import wlankasper.com.setteemezzo.utenti.Giocatore;

import java.util.Locale;

public class Partita {

    Console console = null;
    Mazzo mazzo = null;
    Giocatore utente = null;
    Giocatore computer = null;
    Boolean staGiocando = true;

    public Partita() {
        console = new Console();
        utente = new Giocatore();
        computer = new Giocatore();

        console.outputString("Ciao!\nBenvenuto in Sette e Mezzo in Java di @WlanKasper | Artur ;)");
        boolean temp;
        do{
            console.outputString("Adesso devi scegliere il mazzo:\n1 - Napoletano\n2 - Normale");
            temp = setMazzo(console.inputString());
        }while (!temp);
        gioca();
    }

    public void gioca() {
        while (staGiocando) {
            mazzo.mescola();

            console.outputString("Tuo punteggio: " + utente.contaPunti());
            console.outputString("Vuoi prendere ancora una? (Si/No)");
            String str = console.inputString();
            str = str.toLowerCase(Locale.ROOT);

            if (str.equals("s") || str.equals("si")) {
                try {
                    Carta cartaU = mazzo.carta();
                    Carta cartaC = mazzo.carta();
                    console.outputString(cartaU.toString());
                    utente.aggiungiCarta(cartaU);
                    computer.aggiungiCarta(cartaC);
                } catch (MazzoTerminatoException e) {
                    e.printStackTrace();
                    console.outputString("Mazzo e' finito, quindi anche la partita!");
                    staGiocando = false;
                }

                if (controllaPunti(utente.contaPunti()) || controllaPunti(computer.contaPunti())) {
                    staGiocando = false;
                }
            } else if (str.equals("n") || str.equals("no")) {
                staGiocando = false;
            } else {
                console.outputString("L'input incorretto, riprova!");
            }
        }
        contaTotale();
    }

    public boolean controllaPunti(double num) {
        return (num > 7.5);
    }

    public void contaTotale() {
        console.outputString("Utente punteggio: " + utente.contaPunti());
        console.outputString("Computer punteggio: " + computer.contaPunti());
    }

    public boolean setMazzo(String str) {
        switch (str) {
            case "1": {
                mazzo = new MazzoNapoletano();
                return true;
            }
            case "2": {
                mazzo = new MazzoNormale();
                return true;
            }
            default: {
                console.outputString("Hai sbagliato, riprova!");
                return false;
            }
        }
    }
}

package wlankasper.com.setteemezzo.mazzo;

import wlankasper.com.setteemezzo.exception.MazzoTerminatoException;

import java.util.*;

public abstract class Mazzo {

    final int numCarte;
    Carta[] mazzoCarte;
    int prossimaCarta;

    public Mazzo(int dimensione) {
        mazzoCarte = new Carta[dimensione];
        numCarte = dimensione;
    }

    public Carta carta() throws MazzoTerminatoException {
        if (prossimaCarta >= numCarte)
            throw new MazzoTerminatoException();
        else if (mazzoCarte[prossimaCarta].isEstratta()) {
            prossimaCarta++;
            return carta();
        } else {
            Carta proxCarta = mazzoCarte[prossimaCarta];
            proxCarta.cartaEstratta();
            prossimaCarta++;
            return proxCarta;
        }
    }

    public void mescola() {
        prossimaCarta = 0;

        int j = 0;
        Carta temp = null;
        Random numGen = new Random();

        for (int i = 0; i < numCarte; i++) {
            j = numGen.nextInt(numCarte);

            if (i != j) {
                temp = mazzoCarte[i];
                mazzoCarte[i] = mazzoCarte[j];
                mazzoCarte[j] = temp;

                mazzoCarte[i].cartaNonEstratta();
                mazzoCarte[j].cartaNonEstratta();
            }
        }
    }

    abstract void associaValore();
    abstract void popolaMazzo();
}
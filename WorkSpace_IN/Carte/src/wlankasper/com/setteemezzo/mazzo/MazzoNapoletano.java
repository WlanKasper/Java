package wlankasper.com.setteemezzo.mazzo;

import java.util.*;

public class MazzoNapoletano extends Mazzo {

    static final String nome = "Napoletano";
    static final int NUMERO_CARTE = 40;
    final HashMap<TipoCartaNap, Double> valore = new HashMap<>();
    final static Carta MATTA = new Carta(Seme.Denari, TipoCartaNap.Re, 0.5);

    public MazzoNapoletano() {
        super(NUMERO_CARTE);
        associaValore();
        popolaMazzo();
    }

    @Override
    void associaValore() {
        for (int i = 0, j = 1; i < 8; i++, j++)
            valore.put(TipoCartaNap.values()[i], (double) j);

        valore.put(TipoCartaNap.Donna, 0.5);
        valore.put(TipoCartaNap.Fante, 0.5);
        valore.put(TipoCartaNap.Re, 0.5);
    }

    @Override
    void popolaMazzo() {
        for (int i = 0; i < TipoCartaNap.values().length; i++) {
            TipoCartaNap tmp = TipoCartaNap.values()[i];

            mazzoCarte[i] = new Carta(Seme.Denari, tmp, valore.get(tmp));
            mazzoCarte[i + 10] = new Carta(Seme.Coppe, tmp, valore.get(tmp));
            mazzoCarte[i + 20] = new Carta(Seme.Bastoni, tmp, valore.get(tmp));
            mazzoCarte[i + 30] = new Carta(Seme.Spade, tmp, valore.get(tmp));
        }
    }

}

enum TipoCartaNap {
    Asso, Due, Tre, Quattro, Cinque, Sei, Sette, Donna, Fante, Re
}
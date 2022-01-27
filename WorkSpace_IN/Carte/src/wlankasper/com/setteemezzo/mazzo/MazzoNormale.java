package wlankasper.com.setteemezzo.mazzo;

import java.util.HashMap;

public class MazzoNormale extends Mazzo {

    static final String nome = "Normale";
    static final int NUMERO_CARTE = 52;
    final HashMap<TipoCartaNorm, Double> valore = new HashMap<>();
    final static Carta MATTA = new Carta(Seme.Denari, TipoCartaNorm.Re, 0.5);

    public MazzoNormale() {
        super(NUMERO_CARTE);
        associaValore();
        popolaMazzo();
    }

    @Override
    void associaValore() {
        for (int i = 0, j = 1; i < 8; i++, j++)
            valore.put(TipoCartaNorm.values()[i], (double) j);

        valore.put(TipoCartaNorm.Donna, 0.5);
        valore.put(TipoCartaNorm.Fante, 0.5);
        valore.put(TipoCartaNorm.Re, 0.5);
    }

    @Override
    void popolaMazzo() {
        for (int i = 0; i < TipoCartaNorm.values().length; i++) {
            TipoCartaNorm tmp = TipoCartaNorm.values()[i];

            mazzoCarte[i] = new Carta(Seme.Denari, tmp, valore.get(tmp));
            mazzoCarte[i + 10] = new Carta(Seme.Coppe, tmp, valore.get(tmp));
            mazzoCarte[i + 20] = new Carta(Seme.Bastoni, tmp, valore.get(tmp));
            mazzoCarte[i + 30] = new Carta(Seme.Spade, tmp, valore.get(tmp));
        }
    }

}

enum TipoCartaNorm {
    Due, Tre, Quattro, Cinque, Sei, Sette, Otto, Nove, Dieci, Fante, Donna, Re, Asso
}

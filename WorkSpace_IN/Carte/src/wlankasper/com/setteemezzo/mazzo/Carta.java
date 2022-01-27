package wlankasper.com.setteemezzo.mazzo;

public class Carta {

    final Seme seme;
    final Enum tipoCarta;
    final double valore;
    boolean estratta;

    public Carta(Seme aSeme, Enum e, double aValore) {
        seme = aSeme;
        tipoCarta = e;
        valore = aValore;
        estratta = false;
    }

    public Seme daiSeme() {
        return seme;
    }

    public Enum daiTipoCarta() {
        return tipoCarta;
    }

    public double daiValore() {
        return valore;
    }

    public void cartaEstratta() {
        estratta = true;
    }

    public void cartaNonEstratta() {
        estratta = false;
    }

    public boolean isEstratta() {
        return estratta;
    }

    public String toString() {
        return tipoCarta + " di " + seme + ". Valore: " + valore;
    }

    @Override
    public boolean equals(Object carta) {
        Carta tmp = (Carta) carta;

        return tmp.seme == this.seme &&
                tmp.tipoCarta == this.tipoCarta && tmp.valore == this.valore;
    }

}
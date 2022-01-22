package wlankasper.com.carte.decks;

import java.util.ArrayList;

enum SuitIT {SPADE, COPPE, DENARI, BASTONI};
enum SuitFR {CUORI, QUADRI, FIORI, PICCHE};

public enum TypeDeck {
    FRANCESE(52,10) {
        @Override
        public int getCards() {
            return super.getCards();
        }
        @Override
        public int getnSuits() {
            return super.getnSuits();
        }
        @Override
        public String getSuit(int i) {
            return super.getSuit(i);
        }
        @Override
        public ArrayList<String> getSuits() {
            return super.getSuits();
        }
        @Override
        public void initSuit(ArrayList<String> suits) {
            SuitFR[] suit = SuitFR.values();
            for (SuitFR tempSuit: suit) {
                suits.add(tempSuit.name());
            }
        }
    },
    ITALIAN(40,7) {
        @Override
        public int getCards() {
            return super.getCards();
        }
        @Override
        public int getnSuits() {
            return super.getnSuits();
        }
        @Override
        public String getSuit(int i) {
            return super.getSuit(i);
        }
        @Override
        public ArrayList<String> getSuits() {
            return super.getSuits();
        }
        @Override
        public void initSuit(ArrayList<String> suits) {
            SuitIT[] suit = SuitIT.values();
            for (SuitIT tempSuit: suit) {
                suits.add(tempSuit.name());
            }
        }
    };

    private final int cards;
    private final int nSuits;
    private final ArrayList<String> suits = new ArrayList<>();

    TypeDeck(int cards, int nSuits) {
        this.cards = cards;
        this.nSuits = nSuits;
        initSuit(suits);
    }

    public abstract void initSuit( ArrayList<String> suits);

    public int getCards() {
        return cards;
    }
    public int getnSuits() {
        return nSuits;
    }
    public ArrayList<String> getSuits() {
        return suits;
    }
    public String getSuit(int i){
        return suits.get(i);
    }
}

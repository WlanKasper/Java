package wlankasper.com.carte.objects;

public class Card {
    private final String suit;
    private final String name;
    private final float value;

    public Card (String suit, String name, float value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }
    public String getName() {
        return name;
    }
    public float getValue() {
        return value;
    }
}
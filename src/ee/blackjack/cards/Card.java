package ee.blackjack.cards;

import ee.blackjack.enums.Suit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tõnis on 12.10.2016.
 */
public class Card {

    private int value;
    private Suit suit;
    private static Map<Integer, String> valueStrings = new HashMap<Integer, String>();
    static {
        valueStrings.put(1, "Ace");
        valueStrings.put(2, "Two");
        valueStrings.put(3, "Three");
        valueStrings.put(4, "Four");
        valueStrings.put(5, "Five");
        valueStrings.put(6, "Six");
        valueStrings.put(7, "Seven");
        valueStrings.put(8, "Eight");
        valueStrings.put(9, "Nine");
        valueStrings.put(10, "Ten");
        valueStrings.put(11, "Boy");
        valueStrings.put(12, "Mom");
        valueStrings.put(13, "King");
    }

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return valueStrings.get(value) + " of " + suit;
    }
}

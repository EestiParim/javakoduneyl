package ee.blackjack.npcs;

import ee.blackjack.cards.Card;
import ee.blackjack.enums.Suit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sannu on 12.10.2016.
 */
public class Dealer {

    private List<Card> deck;

    public Dealer() {
        resetDeck();
    }

    public void resetDeck() {
        deck = new LinkedList<>();
        for(int i = 1; i < 14; i++) {
            deck.add(new Card(i, Suit.clubs));
            deck.add(new Card(i, Suit.diamonds));
            deck.add(new Card(i, Suit.spades));
            deck.add(new Card(i, Suit.hearts));
        }
        Collections.shuffle(deck);
    }

    public Card pullCardFromDeck() {
        Card drawnCard = deck.get(0);
        deck.remove(drawnCard);
        return drawnCard;
    }
}

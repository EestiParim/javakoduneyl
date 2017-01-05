package ee.blackjack.gameengine;

import ee.blackjack.cards.Card;
import ee.blackjack.npcs.Dealer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sannu on 12.10.2016.
 */
public class GameEngine {

    private Dealer dealer = new Dealer();
    private List<Card> userCards = new LinkedList<>();
    private boolean gameOn = true;

    public void run() {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line;
        Card drawnCard;
        int score;
        System.out.println("Hi! Welcome to the game of blackjack, I am your dealer today, press [+] to draw the cards");
        System.out.println("type help to see all the commands!");
        while(input.hasNextLine()) {
            line = input.nextLine();
            if(gameOn) {
                if (line.equals("help")){
                    helpPrint();
                }
                if(line.equals("+")) {
                    drawnCard = dealer.pullCardFromDeck();
                    System.out.println("You pulled " + drawnCard + " from the deck.");
                    userCards.add(drawnCard);
                    score = calculateTotalPointsOfDrawnCards(userCards);
                    System.out.println("you currently have: " + score + " points");
                    if(score > 21) {
                        System.out.println("You bursted with score " + calculateTotalPointsOfDrawnCards(userCards));
                        gameOn = false;
                    }
                } else if (line.equals("-")) {
                    System.out.println("Your final score is " + calculateTotalPointsOfDrawnCards(userCards));
                    gameOn = false;
                } else {
                    System.out.println("Sorry, can You repeat that?");
                }
            } else {
                if (line.equals("help")){
                    helpPrint();
                }
                if(line.equals("new")) {
                    dealer.resetDeck();
                    userCards = new LinkedList<>();
                    gameOn = true;
                } else if (line.equals("quit")) {
                    break;
                } else {
                    System.out.println("Sorry, can You repeat that?");
                }
            }
        }
    }
    private void helpPrint(){
        System.out.println("1. To draw cards, type [+]\n" +
                "2. To stay, type [-] \n" +
                "3. after the game, type [new] to start the new game\n" +
                "4. type [quit] to stop the program");
    }

    private int calculateTotalPointsOfDrawnCards(List<Card> cards) {
        int sum = 0, cardValue;
        int nrOfAces = 0;
        for(Card card : cards) {
            cardValue = card.getValue();
            sum += cardValue;
            if(cardValue == 1) {
                nrOfAces++;
            }
        }
        while (nrOfAces > 0){
            if(sum + 10 < 22) {
                sum += 10;
            }
            nrOfAces--;
        }
        return sum;
    }
}

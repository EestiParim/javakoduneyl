package ee.blackjack;

import ee.blackjack.gameengine.GameEngine;

/**
 * Created by Sannu on 12.10.2016.
 */
public class Main {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.run();
    }
}

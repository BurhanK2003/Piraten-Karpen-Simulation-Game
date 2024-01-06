package pk;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public ArrayList<CardObject> Cards() {
        // arraylist to store card object
        ArrayList<CardObject> cards = new ArrayList<>();
        // add the nop cards, they don't have any points or sabers associated to them
        for (int i = 0; i <= 25; i++) {
            cards.add(new CardObject("0","0","nop"));
        }

        // add the monkey business cards, they don't have any points or sabers associated to them
        for (int i=0; i<=4; i++){
            cards.add(new CardObject("0","0","monkey business"));
        }
        //add the sea battle cards with their associated saber and scores
        for (int i = 0; i <= 2; i++) {
            cards.add(new CardObject("2","300","sea battle"));
            cards.add(new CardObject("3","500","sea battle"));
            cards.add(new CardObject("4","1000","sea battle"));
        }

        // return the final arraylist
        return cards;
    }

    public static CardObject Draw(ArrayList<CardObject> cards) {
        // randomly draw a card from the deck
        // same function as shuffling the cards and picking them one by one
        Random draw = new Random();
        int card = draw.nextInt(cards.size());
        CardObject card_drawn = cards.get(card);

        //return the final card drawn
        return card_drawn;
    }

}

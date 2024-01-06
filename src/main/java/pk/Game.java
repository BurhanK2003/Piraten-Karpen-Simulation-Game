package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    public static final Logger log = LogManager.getLogger(Game.class);

    public static double[] game(String arg1, String arg2){
        // initialize arraylist to store the percentages
        double[] percentages = new double[3];
        //initialize all classes required
        Dice d = new Dice();
        Player p = new Player();
        Deck deck = new Deck();
        // get cards
        ArrayList<CardObject> cards = deck.Cards();
        //initialize game count
        int game;
        int game_tie = 0;

        // run loop for 42 games
        for (game = 1; game < 43; ++game) {
            // reinitialize score for every game
            int score_p1 = 0;
            int score_p2 = 0;
            // keep playing untill either player wins by scoring 6000 points
            while (score_p1 < 6000 && score_p2 < 6000) {
                //draw cards for both players in each round
                CardObject card_p1 = Deck.Draw(cards);
                CardObject card_p2 = Deck.Draw(cards);

                log.info("Player 1: Card type: "+card_p1.card_type+". Saber count: "+card_p1.num_saber);
                log.info("Player 2: Card type: "+card_p2.card_type+". Saber count: "+card_p2.num_saber);
                // check command line args to check for stratergy
                if (Objects.equals(arg1, "random") && Objects.equals(arg2, "combo")) {
                    Player.player1 = d.DiceRoll(card_p1.card_type,card_p1.num_saber);
                    Player.player2 = d.ComboRoll(card_p2.card_type,card_p2.num_saber);
                }
                else if (Objects.equals(arg1, "random") && Objects.equals(arg2, "random")) {
                    Player.player1 = d.DiceRoll(card_p1.card_type,card_p1.num_saber);
                    Player.player2 = d.DiceRoll(card_p2.card_type,card_p2.num_saber);
                }
                else if (Objects.equals(arg1, "combo") && Objects.equals(arg2, "random")){
                    Player.player1 = d.ComboRoll(card_p1.card_type,card_p1.num_saber);
                    Player.player2 = d.DiceRoll(card_p2.card_type,card_p2.num_saber);
                }
                else if (Objects.equals(arg1, "combo") && Objects.equals(arg2, "combo")) {
                    Player.player1 = d.ComboRoll(card_p1.card_type,card_p1.num_saber);
                    Player.player2 = d.ComboRoll(card_p2.card_type,card_p2.num_saber);
                }
                // keep adding score
                score_p1 += p.score(Player.player1,card_p1.num_saber,card_p1.card_type);
                score_p2 += p.score(Player.player2,card_p2.num_saber,card_p2.card_type);
                log.info("Player 1 score: "+score_p1+" Player 2 score: "+score_p2);

            }
            // check who won
            if (score_p1 >= 6000 && score_p1 > score_p2) {
                Player.wins_p1+=1;

            }
            else if (score_p2 >= 6000 && score_p2 > score_p1) {
                Player.wins_p2+=1;
            }

            else{
                game_tie += 1;
            }

            log.trace("Finished "+game+" game. Player 1 wins: "+Player.wins_p1+". Player 2 wins:  "+Player.wins_p2);

        }
        // calculate percentages
        double total_wins_p1 = Player.wins_p1;
        double total_wins_p2 = Player.wins_p2;
        double total_game_tie = game_tie;

        double player1_average = total_wins_p1*100/42;
        double player2_average = total_wins_p2*100/42;
        double tie_average = total_game_tie*100/42;

        // add to the list
        percentages[0] = player1_average;
        percentages[1] = player2_average;
        percentages[2] = tie_average;
        //return the list with all percentages
        return percentages;
    }

}

import org.apache.logging.log4j.Level;
import pk.*;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class PiratenKarpen {
    public static final Logger log = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {
        log.debug("Welcome to Piraten Karpen Simulator!");
        log.debug("I'm rolling 8 dice");
        //store args as string
        String args1 = args[0];
        String args2 = args[1];
        //call game class
        Game g = new Game();
        // run simulater
        double[] percentages = g.game(args1,args2);
        // print the player's win percentages
        log.info("Game tie average: "+percentages[2]);
        System.out.println("Player 1 wins average: "+percentages[0]);
        System.out.println("Player 2 wins average: "+percentages[1]);

    }






    }



    


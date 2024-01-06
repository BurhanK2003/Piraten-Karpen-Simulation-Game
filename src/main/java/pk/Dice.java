package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

// this class takes care of all the strategies
public class Dice {
    public static final Logger log = LogManager.getLogger(Dice.class);
    public static Faces roll() {
        int howManyFaces = Faces.values().length;

        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    //Randomly rerolling function
    public static ArrayList<Faces> DiceRoll(String num_saber, String card_type) {
        // takes in the card type and num of sabers as parameters.
        //initializes an arraylist to add the rolls for all 8 dice
        ArrayList<Faces> rolls = new ArrayList<Faces>();
        // initialize skull, reroll and before (the skull count before rerolling)
        int skulls = 0;
        int rerolls = 8;
        int before;
        //Object skull class takes care of counting the skulls
        Skulls s = new Skulls();
        //Randomly generates a boolean
        Random bol = new Random();

        // Roll each faces 8 times and add to an arraylist
        for (int i = 0; i < rerolls; i++) {
            rolls.add(roll());
        }
        // original set of 8 dice
        log.trace("Original: " + rolls);
        // check if card is sea battle
        if (card_type == "sea battle") {
            // check the count of saber
            // call sea battle strat and roll
            if (num_saber == "4"){
                rolls=Seabattle_strat( rolls, "4");

            }
            else if (num_saber == "3"){
                rolls=Seabattle_strat( rolls, "3");
            }
            else if (num_saber == "2"){
               rolls=Seabattle_strat( rolls, "2");
            }

        }

        else {

            // else randomly reroll
            // check how many skulls before
            before = s.SkullCount(rolls);
            //reroll until boolean is true, skulls are less than 3 and before is less than 3
            while (bol.nextBoolean() == true && skulls < 3 && before < 3) {
                // Change random index of array list
                Random random = new Random();
                // keep randomly rerolling random dies as long as it isn't a skull
                for (int i = 0; i < rolls.size(); i++) {
                    if ((random.nextInt(3) == 0 || random.nextInt(3) == 1 || random.nextInt(3) == 2) && rolls.get(i) != Faces.SKULL) {
                        rolls.set(i, roll());
                    }
                }
                // check for skull count in every roll
                skulls = s.SkullCount(rolls);

            }


        }
        // trace final set of die and return
        log.trace("Modified: " + rolls);
        return rolls;


    }
    //Combo rerolling function
    public static ArrayList<Faces> ComboRoll(String card_type, String num_saber) {
        // takes in the card type and num of sabers as parameters.
        //initializes an arraylist to add the rolls for all 8 dice
        ArrayList<Faces> combo = new ArrayList<Faces>();
        // initialize skull, reroll and before (the skull count before rerolling)
        int skulls = 0;
        int rerolls = 8;
        int before;
        //initialize max face count and common face
        int max_face_count=0;
        Faces common_face = null;
        //Object skull class takes care of counting the skulls
        Skulls s = new Skulls();
        // Roll each faces 8 times and add to an arraylist
        for (int i = 0; i < rerolls; i++) {
            combo.add(roll());
        }
        // original set of 8 dice
        log.trace("Original: " + combo);
        //check if sea battle
        if (card_type == "sea battle") {
            // check the count of saber
            // call sea battle strat and roll
            if (num_saber == "4"){
                combo=Seabattle_strat( combo, "4");

            }
            else if (num_saber == "3"){
                combo=Seabattle_strat( combo, "3");
            }
            else if (num_saber == "2"){
                combo=Seabattle_strat( combo, "2");
            }

        }
        else {
            // else randomly reroll
            // check how many skulls before
            before = s.SkullCount(combo);
            //reroll skulls are less than 3 and before is less than 3 and the combos are maximized
            for (Faces face : Faces.values()) {
                //check which face appears the most and add the count
                int face_count = Collections.frequency(combo, face);
                //keep doing for all the dies and find max face count and face the appears the most
                if (face_count > max_face_count) {
                    max_face_count = face_count;
                    common_face = face;
                }

            }

            // Keep rerolling untill the player atleast has 3 common faces
            // as the player gets happy with a minimum of atleast one combo
            while (skulls < 3 && max_face_count < 4 && before < 3) {
                // randomly reroll the faces that are either not a skull or a max face
                for (int i = 0; i < combo.size(); i++) {
                    if (combo.get(i) != Faces.SKULL && combo.get(i) != common_face) {
                        combo.set(i, roll());
                    }
                }
                // check for skull count in every roll
                skulls = s.SkullCount(combo);
                // check again the count of the face
                max_face_count = Collections.frequency(combo, common_face);
            }
        }
        // trace final set of die and return
        log.trace("Modified: " + combo);
        return combo;
    }

    public static ArrayList<Faces> Seabattle_strat(ArrayList<Faces> rolls, String num_saber){
        // reapeat some things from the above functions
        int before;
        int saber_count=0;
        int skulls=0;
        Skulls s = new Skulls();

        before = s.SkullCount(rolls);
        // check the current saber count
        for (int i = 0; i < rolls.size(); i++) {
            if (rolls.get(i) == Faces.SABER) {
                saber_count++;
            }
        }
        // if the saber count is not the required one to win then you reroll
        if (saber_count < Integer.parseInt(num_saber)) {
            // keep rerolling until skulls and before are less than 3 and the required skulls are present
            while (saber_count < Integer.parseInt(num_saber) && skulls < 3 && before < 3) {
                // Change random index of array list

                Random random = new Random();
                // randomly reroll everything except saber and skull
                for (int i = 0; i < rolls.size(); i++) {
                    if (((random.nextInt(3) == 0 || random.nextInt(3) == 1 )) && rolls.get(i) != Faces.SKULL && rolls.get(i) != Faces.SABER) {
                        rolls.set(i, roll());
                    }
                }
                // count saber count
                saber_count =0;
                for (int i = 0; i < rolls.size(); i++) {
                    if (rolls.get(i) == Faces.SABER) {
                        saber_count++;
                    }
                }

                // check for skull
                skulls = s.SkullCount(rolls);

            }
        }
        // return final set of die
        return rolls;

    }




}

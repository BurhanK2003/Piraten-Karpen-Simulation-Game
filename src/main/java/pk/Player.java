package pk;

import java.util.ArrayList;

public class Player {
    //player 1 object
    public static ArrayList<Faces> player1;
    //player 2 object
    public static ArrayList<Faces>  player2;
    // player 1 wins
    public static int wins_p1=0;
    //player 2 wins
    public static int wins_p2=0;

    //player score function
    public static int score(ArrayList < Faces > dice_roll,String num_saber, String card_type){
        //initialize score, face count, skull and objects from classes
        int score = 0;
        int face_count;
        int skulls;
        Skulls s = new Skulls();
        // check number of skulls
        skulls = s.SkullCount(dice_roll);

        if (skulls>=3){
            score=0;
            // if more than 3 skulls than score is 0
            // if sea battle card then bonus subtracted as the player had kept
            // rerolling untill he either got desired saber or lost turn due to skulls
            if (card_type == "sea battle"){
                if (num_saber == "4"){
                    score+=(-1000);
                }
                else if (num_saber == "3"){
                    score+=(-500);
                }
                else if (num_saber == "2") {
                    score+=(-300);
                }
            }

        }
        else {
            // check every face and make a count of the face
            for (Faces face : Faces.values()) {
                face_count = 0;
                // if monkey business card is drwan then conditions applied
                if (card_type=="monkey business") {
                    for (Faces current : dice_roll) {
                        if (current == face || ((current == Faces.MONKEY && face == Faces.PARROT))) {
                            face_count++;
                        }
                    }
                }
                // else each faces is unique and count gotten
                else {
                    for (Faces current : dice_roll) {
                        if (current == face) {
                            face_count++;
                        }
                    }
                }
                // check how many faces and asscociate a score.
                if (face_count > 2) {
                    if (face_count == 3) {
                        score += 100;
                    } else if (face_count == 4) {
                        score += 200;
                    } else if (face_count == 5) {
                        score += 500;
                    } else if (face_count == 6) {
                        score += 1000;
                    } else if (face_count == 7) {
                        score += 2000;
                    } else if (face_count == 8) {
                        score += 6000;
                    }
                }
                // if diamond or gold, then add points regardless of combo
                if (face == Faces.DIAMOND || face == Faces.GOLD) {
                    score += face_count * 100;
                }
            }
            //if sea battle then add bonus after all scores
            if (card_type == "sea battle"){
                if (num_saber == "4"){
                    score+=1000;
                }
                else if (num_saber == "3"){
                    score+=500;
                }
                else if (num_saber == "2") {
                    score+=300;
                }
            }
        }
        // return final score
        return score;


    }


}

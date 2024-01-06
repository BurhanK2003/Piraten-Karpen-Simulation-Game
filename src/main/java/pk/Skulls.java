package pk;

import java.util.ArrayList;

public class Skulls {

    public static int SkullCount(ArrayList< Faces > dice_roll){
        // initialize skull count
        int skulls = 0;
        for (Faces face : dice_roll) {
            // check if skull and add
            if (face == Faces.SKULL) {
                skulls += 1;
            }
        }
        // return num of skulls
        return skulls;

    }


}

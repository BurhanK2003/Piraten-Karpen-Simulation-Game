package pk;

public class CardObject {
    // Each card has been associated with Card type, number of saber and score on the card
    // This initializes it
    public String num_saber;
    public String card_score;
    public String card_type;

    // This assigns it
    public CardObject(String num_saber,String card_score,String card_type) {
        this.num_saber = num_saber;
        this.card_score = card_score;
        this.card_type = card_type;
    }

}


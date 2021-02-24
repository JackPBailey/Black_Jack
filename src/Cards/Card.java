package Cards;

public abstract class Card {

    protected int value;
    protected String name;
    protected String suit;


    public Card(int value, String suit) {
        if (value == 11) {
            this.value = 10;
            this.name = "Jack";

        } else if (value == 12) {
            this.value = 10;
            this.name = "Queen";

        }else if (value==13){
            this.value=10;
            this.name="king";

        } else {
            this.value = value;
            this.name = String.valueOf(value);

        }
        this.suit = suit;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return this.name + " of " + this.suit;
    }
}

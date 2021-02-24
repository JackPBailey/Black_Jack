package CardContainers;

import Cards.*;

import java.util.ArrayList;


public abstract class CardContainer {

    protected ArrayList<Card> held;

    public CardContainer() {
        this.held = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Card i : this.held)
            out.append(i.toString() + ", ");
        return out.toString();
    }


    public void addCard(Card newCard) {
        this.held.add(newCard);
    }


    public Card getCard() {
        Card out =this.held.get(0);
        this.held.remove(0);
        return out;
    }

    public Card getCard(String name, String suit) {
        int index=-1;
        Card toCheck;

        for (int i = 0; i < this.held.size(); i++) {
            toCheck = this.held.get(i);
            if (toCheck.getName().equals(name) && toCheck.getSuit().equals(suit)) {
                index = i;
            }
        }

        return this.held.get(index);
    }

    public void removeCards(){
        this.held.clear();
    }
}


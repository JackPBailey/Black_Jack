package CardContainers;

import Cards.*;

import java.util.Random;

public class Deck extends CardContainer {

    public Deck() {
        for (int i = 1; i <= 13; i++) {

            this.held.add(new Hearts(i));
            this.held.add(new Clubs(i));
            this.held.add(new Diamonds(i));
            this.held.add(new Spades(i));
        }

    }

    public Deck(int numOfDecks) {

        for (int i = 0; i != numOfDecks; i++) {

            for (int j = 1; j <= 13; j++) {

                this.held.add(new Hearts(j));
                this.held.add(new Clubs(j));
                this.held.add(new Diamonds(j));
                this.held.add(new Spades(j));
            }
        }

    }


    public void shuffle() {
        Random rand = new Random();
        Card temp;
        int randomNum;
        for (int i = 0; i != this.held.size(); i++) {
            randomNum = rand.nextInt(held.size());
            temp = this.held.get(i);
            this.held.set(i, this.held.get(randomNum));
            this.held.set(randomNum, temp);
        }

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void returnToDeck(Hand toReturn){
        this.held.addAll(toReturn.getHeld());
        toReturn.removeCards();
    }

    public static void main(String[] args) {
        Deck test = new Deck(2);
        test.shuffle();
        System.out.println(test);

    }
}

package CardContainers;

import Cards.Card;

import java.util.ArrayList;

public class Hand extends CardContainer{

    String name;

    public Hand(String name){
        super();
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Card> getHeld(){
        return this.held;
    }

    public String getHeldCardNames(){
       StringBuilder out = new StringBuilder();
       for (Card i : this.held){
           out.append(i.getName()+" of "+i.getSuit()+", ");
       }
       out.trimToSize();
       out.deleteCharAt(out.length()-2);
       return out.toString();
    }

    public int getHandValue(){
        int total=0;

        for(Card i: this.held){
            total=total+i.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.name+"=");
        for (Card i : this.held)
            out.append(i.toString() + ", ");
        return out.toString();
    }

    public String handToString() {
        return "In " + getName() + "'s hand:" + System.lineSeparator() +
                getHeldCardNames() + "totaling: " + getHandValue();
    }


    public void playForPc(Deck pack){
        this.held.add(pack.getCard());
        this.held.add(pack.getCard());
        while (getHandValue()<17){
            this.held.add(pack.getCard());
        }
    }
}

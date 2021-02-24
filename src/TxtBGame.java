import CardContainers.Deck;
import CardContainers.Hand;
import CardContainers.Pile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TxtBGame {

    Scanner userIP = new Scanner(System.in);
    int roundsPerGame;
    Deck pack;
    Hand[] hPlayers;
    Hand[] pcPlayers;
    int totalNumberOfPlayers;
    Pile usedCards;

    public TxtBGame(int roundsPerGame, int hPlayers, int pcPlayers) {
        this.roundsPerGame = roundsPerGame;
        this.pack = new Deck();
        this.pack = new Deck();
        this.hPlayers = createPlayerArray(hPlayers);
        this.pcPlayers = createPcPlayerArray(pcPlayers);
        this.totalNumberOfPlayers=hPlayers+pcPlayers;
    }

    public Hand[] getHPlayers() {
        return hPlayers;
    }

    public Hand[] getPcPlayers() {
        return pcPlayers;
    }

    private void play() {
        int round = 0;
        while (round < this.roundsPerGame) {
            if (round == 0) {
                int pNum = 0;
                for (Hand i : this.hPlayers) {
                    pNum++;
                    System.out.print("Player " + pNum + " enter your name :");
                    i.setName(this.userIP.next());
                }
            }//naming the players

            this.pack.shuffle();

            for (Hand i : this.hPlayers) {// humans play the game.
                i.addCard(this.pack.getCard());
                i.addCard(this.pack.getCard());

                System.out.println(i.handToString());
                System.out.print("Do you want another card? (y/n) :");
                String in = this.userIP.next();
                while (in.equals("y") && i.getHandValue() < 22) {
                    i.addCard(this.pack.getCard());
                    System.out.println(i.handToString());
                    System.out.print("Do you want another card? (y/n) :");
                    in = this.userIP.next();

                }
                System.out.println(i.getName() + " finished with:" + i.getHandValue());
                in ="";
                while (in.equals("")){
                    System.out.print("Enter y to end your turn. ");
                    in=this.userIP.next();
                }
            }

            for (Hand i : this.pcPlayers) {// pcs play the game.
                i.playForPc(this.pack);
                System.out.println(i.handToString());
            }

            Hand[][] ranking=calculateRankings();


            round++;
        }
    }



    @Override
    public String toString() {
        return "TxtBGame{" +
                "roundsPerGame=" + roundsPerGame +
                ", pack=" + pack +
                ", hPlayers=" + Arrays.toString(hPlayers) +
                ", pcPlayers=" + Arrays.toString(pcPlayers) +
                '}';
    }

    private Hand[] createPcPlayerArray(int noOfPlayers) {
        Hand[] out = new Hand[noOfPlayers];

        for (int i = 0; i < noOfPlayers; i++) {
            out[i] = new Hand("pc" + (i + 1));
        }
        return out;
    }

    private Hand[] createPlayerArray(int noOfPlayers) {
        Hand[] out = new Hand[noOfPlayers];

        for (int i = 0; i < noOfPlayers; i++) {
            out[i] = new Hand("temp");
        }
        return out;
    }

    public static void main(String[] args) {
        TxtBGame g1 = new TxtBGame(1, 0, 10);
        g1.play();
        //System.out.println(g1);
    }

    private Hand[][] calculateRankings(){
        ArrayList<Hand> winner = new ArrayList<>();
        ArrayList<Hand> losers = new ArrayList<>();

        for (Hand i: this.hPlayers) {
            if (i.getHandValue() > 21) {
                losers.add(i);
            } else {
                winner.add(i);
            }
        }

        for (Hand i: this.pcPlayers) {
            if (i.getHandValue() > 21) {
                losers.add(i);
            } else {
                winner.add(i);
            }
        }
        Collections.sort(winner);


    }

}

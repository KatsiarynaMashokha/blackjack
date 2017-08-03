package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/3/17.
 */
public class BlackJack {
    ArrayList<Player> players = new ArrayList<>();
    Deck deck;
    Player activePlayer;
    //Computer computer;
    boolean gameRunning = true;
    int activePlayerIndex;


    public BlackJack() {
        deck = new Deck();

    }

    public void addPlayer(String name){
        players.add(new Player(name));
    }

    public void addComputer(){
        players.add(new Player("Mr. Robot"));
    }

    public void drawHands() {
        for (Player player : players) {
            player.getHand(deck);
        }
    }

    public boolean isGameRunning(){
        for(Player player: players){
            if (player.isPlaying()) {
                return true;
            }
        }
        return false;
    }

    public String nextTurn(){
        activePlayer = players.get(activePlayerIndex);
//        if(activePlayer.name.equals("Mr. Robot")){
//            computer.roboTurn(activePlayer);
//        }
        String hand = activePlayer.printHand();
        activePlayerIndex++;
        if(activePlayerIndex == players.size()){
            activePlayerIndex = 0;
        }
        return activePlayer.name + "'s hand. They have: \n" + hand;
    }

    public void playerHit(){
        activePlayer.drawCard(deck);
    }

    public void playerHold(){
        activePlayer.holdHand();
    }

    public boolean isPlayerPlaying(){
        return activePlayer.isPlaying();
    }

    public String currentPlayerHand(){
        return activePlayer.printHand();
    }

    public String getWinner() {
        Integer winningScore = 0;
        ArrayList<Integer> index = new ArrayList<>();
        for (Integer i = 0; i < players.size(); i++) {
            if(players.get(i).calculateScore() >= winningScore && players.get(i).calculateScore() < 22) {
                if(players.get(i).calculateScore() > winningScore){
                    index.clear();
                }
                winningScore = players.get(i).calculateScore();
                index.add(i);
            }
        }
        if (index.isEmpty()) {
            return "Nobody wins!";
        } else if(index.size() == 1) {
            return "There is a winner! " + players.get(index.get(0)).name + " wins with a score of: " + winningScore;
        } else {
            String winners = "";
            for (int i = 0; i < index.size(); i++) {
                winners += players.get(index.get(i)).name;
            }
            return winners;
        }
    }

}

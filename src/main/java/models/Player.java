package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/3/17.
 */
public class Player {
    String name;
    public ArrayList<Card> currentCards;
    boolean active = true;

    public Player(String name) {
        this.name = name;
        currentCards = new ArrayList<>();
    }

    public ArrayList<Card> getHand(Deck thisDeck){
        currentCards.add(thisDeck.getRandomCardAndRemove());
        currentCards.add(thisDeck.getRandomCardAndRemove());
        return currentCards;
    }

    public ArrayList<Card> drawCard(Deck thisDeck){
        currentCards.add(thisDeck.getRandomCardAndRemove());
        return currentCards;
    }

    public void holdHand(){
        active = false;
    }

    public String printHand(){
        String cards = "";
        for(Card oneCard: currentCards){
            cards += oneCard.printName() + "\n";
        }
        return cards;
    }

    public Integer calculateScore() {
        Integer score = 0;
        int aceCount = 0;
        for (Card card : currentCards){
            score += card.getRealVal();
            if(card.value.equals("ace")){
                aceCount++;
            }
        }
        while(score > 21 && aceCount > 0){
            score -= 10;
            aceCount--;
        }
        return score;
    }

    public boolean isPlaying() {
        if (calculateScore() > 21) {
            active = false;
            return active;
        } else {
            return active;
        }

    }
}

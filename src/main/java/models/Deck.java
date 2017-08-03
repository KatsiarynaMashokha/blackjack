package models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Guest on 8/3/17.
 */
public class Deck {
    ArrayList<Card> cardDeck;
    Integer cardsLeft;

    public Deck(){
        cardDeck = new ArrayList<>();
        cardsLeft = 52;
        String[] suits = {"hearts", "diamonds", "clubs", "spades"};
        String[] values = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
        Integer[] realValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10 ,10, 11};
        for(int i=0; i < suits.length; i++){
            for(int j = 0; j < values.length; j++){
                cardDeck.add(new Card(suits[i], values[j], realValues[j]));
            }
        }
    }

    public void printDeck(){
        for(Card oneCard: cardDeck){
            System.out.println(oneCard.printName());
        }
    }

    public Card getRandomCardAndRemove() {
        Random random = new Random();
        int randomNum = random.nextInt(cardsLeft);
        Card cardOut = cardDeck.get(randomNum);
        cardDeck.remove(randomNum);
        cardsLeft--;
        return cardOut;
    }
}

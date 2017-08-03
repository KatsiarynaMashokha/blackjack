package models;

/**
 * Created by Guest on 8/3/17.
 */
public class Card {
    public String suit;
    public String value;
    public Integer realVal;

    public Card(String suit, String value, Integer realVal) {
        this.suit = suit;
        this.value = value;
        this.realVal = realVal;
    }

    public Integer getRealVal() {
        return realVal;
    }

    public String printName(){
        String cardName = value + " of " + suit;
        return cardName;
    }

    public void aceLow(){
        realVal = 1;
    }

}


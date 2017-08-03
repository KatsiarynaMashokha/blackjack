import models.BlackJack;
import models.Deck;
import models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Guest on 8/3/17.
 */
public class Main {
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How many players?");
        try {
            Integer numOfPlayers = Integer.parseInt(reader.readLine());
            for(int i = 0; i < numOfPlayers; i++) {
                System.out.println("Please enter player " + (i+1) + " name");
                String name = reader.readLine();
                blackJack.addPlayer(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        blackJack.drawHands();
        while(blackJack.isGameRunning()) {
            System.out.println(blackJack.nextTurn());
            while(blackJack.isPlayerPlaying()){
                System.out.println("Do you want to hit or hold?");
                try {
                    String userChoice = reader.readLine();
                    if(userChoice.equals("hold")) {
                        blackJack.playerHold();
                    } else if(userChoice.equals("hit")) {
                        blackJack.playerHit();
                    } else {
                        System.out.println("Enter hit or hold");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(blackJack.currentPlayerHand());
            }


        }
        System.out.println(blackJack.getWinner());



//
//        thisPlayer.getHand(thisDeck);
//        System.out.println("Your hand is: \n" + thisPlayer.printHand() + " You scored " + thisPlayer.calculateScore());
//
//        while (isRunning) {
//            System.out.println("Do you want to hit or hold?");
//            try {
//                userChoice = reader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (userChoice.equals("hold"))  {
//                System.out.println("Your score is " + thisPlayer.calculateScore());
//                isRunning = false;
//            } else if (userChoice.equals("hit")) {
//                thisPlayer.drawCard(thisDeck);
//                System.out.println("Your hand now is \n" + thisPlayer.printHand() + " You scored " +thisPlayer.calculateScore());
//                isRunning = thisPlayer.isPlaying();
//            } else {
//                System.out.println("Invalid input. Enter 'hit' or 'hold");
//            }
//
//        }
//        if(blackJack.isPlayerPlaying()){
//            System.out.println("You win!");
//        }else{
//            System.out.println("You're bust!");
//        }
//        System.out.println("Thanks for playing!");
    }

}

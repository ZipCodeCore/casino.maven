package com.github.zipcodewilmington.casino.games.games.craps;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

//GambleableGame and GamblingPlayer
public class CrapsGame {

    public static void main(String[] args)  {
        int wins = 0;
        int loss = 0;



        //for (int i = 0; i < 10; i++) {
            System.out.println("roll the die");
            int score = roll();
        //System.out.println("\n score " + score);

            if (score == 7 || score == 11) {
                System.out.println("\n Score = " + score);
                System.out.println("you win");


            } else if (score == 2 || score == 3 || score == 12) {
                System.out.println("\n Score = " + score);
                System.out.println("you lose");


            } else {
                int point = score;
                System.out.println("\n Point = " + point);
                while (true) {
                    System.out.println("\n Next Roll");
                    score = roll();
                    System.out.println("\n New Point = " + score);
                    if (score == point) {
                        System.out.println("\n  You win");
                        break;
                    }
                    if (score == 7) {
                        System.out.println("\n  You lose");
                        break;
                    }
                }
            }
        //}
    }

    public static int roll() {
        Random randomGenerator = new Random();
        int dice1 = randomGenerator.nextInt(6) + 1;
        int dice2 = randomGenerator.nextInt(6) + 1;
        System.out.println("\n dice1 = " + dice1 + " dice2 = " + dice2);
        return dice1 +  dice2; // this will make roll return sum of die
    }

}








    /* Rolling two dice each time, typically presented with 5 dice
    * Player is the shooter
    * Both dice must be tossed in one throw
    * Some of these games do have rounds
    * If a shooter craps out they may keep rolling until they roll a 7 after a point has been established
    * there are at least 7 different games.craps games within games.craps
    * each game or mini game has different odds
    * the different odds will result in different pay out amounts
    * Game 1- Starting with Passline, you are betting on the outcome of a round.
    * Each round has two different phases "come out" and "point"
    * A come out roll of 2, 3, or 12 is called craps, you are crapping out and you automatically lose,
    * if you get 7 or 11 a "natural" on the first roll then you automatically win.
    * if you roll a point number such as 4, 5, 6, 8, 9, or 10 then you continue to roll
    * on subsequent rolls you must roll the point number value again before rolling a 7 to win
    * you do not need to roll a point number value in the same way
    * if you roll a 7 before your point number, you lose
    * Dealer will flip a button to "ON" and it will be on the point number, signifying the second phase of the round
    * Game 2- Don't pass, similar to game one, but when you get 2 or 3 on a come out you win, you tie if you get 12
    * -in point, if the seven comes out before the point then that Don't Pass line wins
    *
    * 2, 3, 11, or 12 do not have an affect on the pass or don't pass lines after the point has been established
    * */

//    public class Craps extends Game implements TableGame {
//        private ArrayList<Player> players;
//        private double betMinimum;
//        private double betMaximum;
//
//        @Override
//        public void play(ArrayList<Player> players) {
//            play(players, BigDecimal.valueOf(5, 2), BigDecimal.valueOf(1000, 2));
//        }
//
//        @Override
//        public void play(ArrayList<Player> players, BigDecimal betMinimum,
//                         BigDecimal betMaximum) {
//            this.players = players;
//            this.betMinimum = betMinimum;
//            this.betMaximum = betMaximum;
//        }

package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


import static com.github.zipcodewilmington.casino.objects.Dice.roll;

public class CrapsTable implements GambleableGame {

    private final IOConsole console = new IOConsole(AnsiColor.CYAN);

//    Dice dice;
//    CrapsPlayer player;
//    double amountWon;
//
//    public CrapsTable () {
//        this.dice = new Dice();
//        this.player = new CrapsPlayer();
//        this.amountWon = 0;
//    };


    //Double bet = console.getDoubleInput("How much would you like to bet?");
//        System.out.println("Your bet is " + bet + "\nThe dealer will now shuffle and deal out your cards.");
    public void playCraps() {
        
        console.println("     ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        console.println("         ∆ Welcome to Cauldron Craps ∆ ");
        console.println("     ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        console.println("A fun dice game for wizards and witches of age." +
                "\n" +
                " \nYou will roll two dice each time you take a turn." +
                "\n" +
                "\nTo win on your first roll, you must roll either a 7 or an 11." +
                "\n" +
                "\nBe careful though! " +
                "\nIf you roll a 2, 3, or 12 on your first roll you will lose the game and be cursed!!" +
                "\n" +
                "\nIf you roll a 4, 5, 6, 8, 9, or 10 this is called your point number." +
                "\n" +
                "\nYour objective is to roll repeatedly until you roll your point number again." +
                "\n" +
                "\nWatch out though! If you roll a 7 before you make your point, you will eat slugs! And lose the game.");


        //Double amountWagered = console.getDoubleInput("How many galleons would you like to wager?");
        //System.out.println("You've wagered " + amountWagered);
        console.println("\nShooter, Roll The Dice!");
        console.getStringInput("\nWave your wand and enter a number to roll");
        int score = roll();

        if (score == 7 || score == 11) {
            System.out.println("\nScore = " + score);
            //amountWon += amountWagered;
            System.out.println("\nNatural! You Win!");


        } else if (score == 2 || score == 3 || score == 12) {
            System.out.println("\n Score = " + score);
            System.out.println("\nCraps! You Lose");


        } else {
            int point = score;
            System.out.println("\nPoint = " + point);
            while (true) {
                console.getStringInput("\nWave your wand and enter a number to roll again");

                score = roll();

                System.out.println("\nNew Score = " + score);
                if (score == point) {
                    //amountWon += amountWagered;
                    System.out.println("\nYou made your point, You Win!");
                    break;
                }
                if (score == 7) {
                    System.out.println("\nYou rolled a 7, House Wins");
                    break;
                }
            }
        }
    }
//System.out.println("TOTAL REWARDS: " + playerReward + "\n>");
    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        return false;
    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    @Override
    public void clearGame() {

    }

    @Override
    public void run() {

    }
}

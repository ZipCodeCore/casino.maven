package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    public static void main(String[] args) {

    }
    Random random = new Random();
    IOConsole console = new IOConsole(AnsiColor.BLUE);
    int guessedNumber = 0;
    int randomNumberFromOneToOneHundred = random.nextInt(100) + 1;


    @Override
    public void add(PlayerInterface player) {
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
    guessedNumber = console.getIntegerInput("Guess a number between 1 and 100");
    while(guessedNumber >= 1 && guessedNumber<=100) {
        if (guessedNumber == randomNumberFromOneToOneHundred) {
            console.print("Whoa!!! You've won 100 tokens!");
        } else {
            console.print("Better luck next time...");
        }
    }

    }
}
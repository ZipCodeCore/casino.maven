package com.github.zipcodewilmington.casino.games.slots;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    public static void main(String[] args) {

    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        Random generator = new Random();
        IOConsole console = new IOConsole(AnsiColor.BLUE);
        String slot1, slot2, slot3;
        int input = 0;
        // this is where the funds will be added
        while(input == 1){
            console.println("Welcome to the Slot Machine!");
            console.println("You need 10 tokens to play!" + "\n");

            input = console.getIntegerInput("Press 1 to pull or press 2 to quit"); //this will be where the funds are added

            String[] slotValues = {"watermelon", "grape", "lemon", "orange", "bar", "7", "BIGWIN", "cherry","banana"};
            slot1 = slotValues[generator.nextInt(slotValues.length)];
            slot2 = slotValues[generator.nextInt(slotValues.length)];
            slot3 = slotValues[generator.nextInt(slotValues.length)];


            console.print(slot1 + " " + slot2 + " " + slot3 + "\n");

            if (slot1 == "BIG WIN" && slot1 == slot2 && slot1 == slot3) {
               console.print("Jackpot! You win 50 tokens!" + "\n");
            } else if (slot1 == slot2 && slot1 == slot3) {
                console.print("Congrats! You win 10 tokens." + "\n");
            } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
                console.print("Congrats! You win 5 tokens." + "\n");
            } else {
                console.print("Sorry! Better luck next time." + "\n");
            }
        }
    }
}

package com.github.zipcodewilmington.casino.games.slots;


import java.util.*;

public class SlotReels {
    private static String BROOMSTICK = "BROOMSTICK";
    private static String GOLDENSNITCH = "GOLDENSNITCH";
    private static String DOBBYSSOCK = "DOBBYSSOCK";


    // Making randomizer //
    static List<String> reelValue = Collections.unmodifiableList(Arrays.asList(BROOMSTICK,GOLDENSNITCH,DOBBYSSOCK));
    static int size = reelValue.size();
    static Random randomizer = new Random();

    public void playSlots() {
        //Random randomizer = new Random();
        Scanner scanner = new Scanner(System.in);

        int playerInput = 0; // research how to use enums to substitute for numbers
        float playerReward = 0; // non gambling game, if player wins they get a few cents towards their account balance?
        String slot1;  // Dobby's Sock
        String slot2; // Broom Stick
        String slot3; // Golden Snitch

        System.out.println("Welcome to Dobby's Sock Slots");
        //System.out.println("How lucky are you?\n" +
        //"Total Rewards: " + playerReward);

        // Pull lever!
        do {
            System.out.println("Enter 1 to pull the lever\n" +
                    "Enter 2 to quit game"); // throw exceptions if they try to break game
            System.out.println("Total Rewards: " + playerReward + "\n>");

            playerInput = scanner.nextInt();

            slot1 = reelValue.get(randomizer.nextInt(size));
            slot2 = reelValue.get(randomizer.nextInt(size));
            slot3 = reelValue.get(randomizer.nextInt(size));

            System.out.println(slot1 + " " + slot2 + " " + slot3);

            // Game Sequence
            if (slot1 == slot2 && slot1 == slot3) {
                System.out.println("getPlayerName() " + " You Win 50 Cents");
                playerReward += 0.50;

            } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
                System.out.println("getPlayerName() " + "You Win 25 Cents");
                playerReward += 0.25;

            } else {
                System.out.println("getPlayerName() " + "No Luck... Dobby says try again?");
            }
        }
        while (playerInput == 1);
    }
}
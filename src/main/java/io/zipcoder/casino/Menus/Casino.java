package io.zipcoder.casino.Menus;

import io.zipcoder.casino.CasinoArt;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;

public class Casino {
    private Player currentPlayer;
    Console console = new Console(System.in, System.out);
    CasinoArt art = new CasinoArt();
    boolean running = true;

    public void runCasinoMenu(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        while(running) {
            displayCasinoMenu();
            Integer playerInput = getPlayerInput();
            casinoMenuLogic(playerInput);
        }
    }

    public void displayCasinoMenu(){
        Console.clearScreen();
        console.println(art.getCasinoArt(CasinoArt.Art.CASINOLOBBY));
        console.println(String.format("Welcome to The Notorious B.I.G. 3 Casino, %s!",currentPlayer.getName()));
        console.println("What would you like to do?");
        console.println("(1) - Display Game Menu");
        console.println("(2) - Check your Balance");
        console.println("(3) - See your History");
        console.println("(4) - Return to Player Menu");
    }

    public void goToGameMenu(){
        GameMenu gameMenu = new GameMenu();
        gameMenu.runGameMenu(currentPlayer);
    }

    public void exitCasino(){
        console.print("Thank you for visiting The Notorious B.I.G. 3!");

    }

    public Integer getPlayerInput(){
        Integer playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public void casinoMenuLogic(Integer playerInput){
        switch (playerInput){
            case 1:
                GameMenu gameMenu = new GameMenu();
                gameMenu.runGameMenu(currentPlayer);
                break;
            case 2:
                console.println(String.format("Your current balance is $%d.00.\n\n", currentPlayer.getBalance()));
                console.getStringInput("Press Enter to return to menu");
                break;
            case 3:
                if(currentPlayer.getHistory().isEmpty()){
                    console.println("Sorry! You do not yet have a gaming history. Play some games to get one!\n\n");
                    console.getStringInput("Press Enter to return to menu");
                } else {
                    console.println(currentPlayer.printHistory());
                    console.getStringInput("Press Enter to return to menu");
                }
                break;
            case 4:
                running = false;
                break;
        }
    }
}
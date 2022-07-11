package com.github.zipcodewilmington.casino.games.plinko;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class REPlinko implements GameInterface {
    private PlayerInterface playerInt;
    private Boolean isRunning = false;
    public List<Integer> winningValues;
    Integer userBet;
    Integer userInput;
    Integer actualWinnings = 0;
    IOConsole input = new IOConsole();
    IOConsole green = new IOConsole(AnsiColor.GREEN);
    IOConsole red = new IOConsole(AnsiColor.RED);
    IOConsole cyan = new IOConsole(AnsiColor.CYAN);

    public void run() {
        printWelcome();
        while(!isRunning) {
            playerInt.getArcadeAccount().alterAccountBalance(actualWinnings);
            green.println("Your current account balance is " + playerInt.getArcadeAccount().getAccountBalance() + "\n");
            userInput = cyan.getIntegerInput("Wanna play?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n");
            switch (userInput) {
                case 1:
                    askForBet();
                    userBetCondition();
                    playerInt.getArcadeAccount().alterAccountBalance(userBet * (-1));
                    startGame();
                    break;
                case 2:
                    isRunning = true;
            }
        }
    }

    public void startGame() {
        createBoard();
        shuffleBoard();
        calculateWinnings(checkWin(), userBet);
        printWinnings();
    }

    public Integer checkWin () {
        return winningValues.get(0);
    }

    public void createBoard () {
        winningValues = new ArrayList<>();
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(1);
        winningValues.add(1);
        winningValues.add(2);
        winningValues.add(3);
        winningValues.add(5);
    }

    public void shuffleBoard () {
        Collections.shuffle(winningValues);
    }

    private void userBetCondition() {
        while (userBet > playerInt.getArcadeAccount().getAccountBalance()) {
            red.println("Oh no! You're trying to place a bet with more money than you have..." + "\n");
            askForBet();
        }
    }

    private void printWelcome() {
        input.println("Welcome!");
    }

    public void askForBet () {
        userBet = (green.getIntegerInput("How much would you like to bet?" + "\n"));
    }

    public void printWinnings () {
        if (actualWinnings > 0) {
            green.println("You've won " + actualWinnings + "!!" + "\n");
        } else {
            red.println("Ahhh, better luck next time! You lost... " + "\n");
        }
    }

    public void add(PlayerInterface player) {
        this.playerInt = player;
    }

    public void remove(PlayerInterface player) {
        this.playerInt = null;
    }

    public Integer calculateWinnings(Integer multiplier, Integer userBet) {
        actualWinnings = multiplier * userBet;
        return actualWinnings;
    }

    public void subtractBetFromBalance(Integer betAmount) {
        playerInt.getArcadeAccount().alterAccountBalance(betAmount * (-1));
    }

    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        Player.getArcadeAccount().alterAccountBalance(winnings);
    }

    public PlayerInterface getPlayerInt() {
        return playerInt;
    }

    public Boolean getRunning() {
        return isRunning;
    }

    public void setRunning(Boolean running) {
        isRunning = running;
    }

    public Integer getUserBet() {
        return userBet;
    }

    public void setUserBet(Integer amt){
        this.userBet = amt;
    }

    public List<Integer> getWinningValues() {
        return winningValues;
    }
}
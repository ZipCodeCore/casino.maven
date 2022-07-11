package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashSet;

public class KenoGameRE implements GameInterface {
    private final IOConsole Red = new IOConsole(AnsiColor.RED);
    private final IOConsole Green = new IOConsole(AnsiColor.GREEN);
    private final IOConsole Yellow = new IOConsole(AnsiColor.YELLOW);
    private final IOConsole Blue = new IOConsole(AnsiColor.BLUE);
    private final IOConsole Purple = new IOConsole(AnsiColor.PURPLE);
    private final IOConsole Cyan = new IOConsole(AnsiColor.CYAN);
    private IOConsole console = new IOConsole(AnsiColor.BLUE);
    private PlayerInterface currentPlayer;
    private Integer userBet;
    private Integer currentUserChoice;
    private HashSet<Integer> tenChoices;
    private HashSet<Integer> twentyOneRandom;
    private HashSet<Integer> matches;
    private Integer multiplier;
    private Integer winnings;

    //---------------------------------------------------------------------

    public KenoGameRE(){
    }

    @Override
    public void run() {
        //Display welcome
        Yellow.println(printWelcome());
        //Display instruction
        console.setWait(1000);
        Blue.println(displayInstruction());
        Boolean quit = false;
        while(!quit) {
            //Print user current balance
            console.setWait(1000);
            Green.println("Your Current Balance: " + getPlayerBalance());
            //Ask user for bet amount
            console.setWait(1000);
            userBet = Purple.getIntegerInput("How much do you want to bet?");
            //Subtract bet amount from user's balance
            subtractBetFromBalance(userBet);
            //Ask user to pick 10 numbers between 1-80 and add to array
            getUserChoices();
            //Display user's picks
            console.setWait(1000);
            Purple.println("Your chose: " + tenChoices);
            //Generate 21 random numbers and add to array
            setTwentyOneRandom(twentyOneRandomNum());
            //Display the 21 random numbers
            console.setWait(1000);
            console.println("Game chose:" + twentyOneRandom);
            //Find matches b/w user choice and random 21
            setMatches(findMatches());
            //Print matched array
            console.setWait(1000);
            Yellow.println("Matches: " + matches);
            //Calculate multiplier then set multiplier
            Integer multiply = calculateMultiplier();
            setMultiplier(multiply);
            //Calculate winnings and set it
            Integer win = calculateWinnings(multiplier, userBet);
            setWinnings(win);
            //Print winnings
            console.setWait(1000);
            Green.println("You won:   $" + winnings);
            //Add winnings to player's account balance
            addMoneyToBalance(currentPlayer, winnings);
            //Print user current balance
            console.setWait(1000);
            Green.println("Your Current Balance:   $" + getPlayerBalance());
            //Ask user to play again
            quit = playAgain();
        }
    }

    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }
    @Override
    public void remove(PlayerInterface player) {
        this.currentPlayer = null;
    }
    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return multiplier * betAmount;
    }
    @Override
    public void subtractBetFromBalance(Integer betAmount) {
        currentPlayer.getArcadeAccount().alterAccountBalance(betAmount * (-1));
    }
    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        Player.getArcadeAccount().alterAccountBalance(winnings);
    }

    //-------------------------- Getters and Setters -----------------------

    public PlayerInterface getCurrentPlayer() {
        return currentPlayer;
    }

    public void setUserBet(Integer userBet) {
        this.userBet = userBet;
    }

    public void setTwentyOneRandom(HashSet<Integer> twentyOneRandom) {
        this.twentyOneRandom = twentyOneRandom;
    }

    public HashSet<Integer> getTwentyOneRandom() {
        return twentyOneRandom;
    }

    public HashSet<Integer> getMatches() {
        return matches;
    }

    public void setMatches(HashSet<Integer> matches) {
        this.matches = matches;
    }

    public HashSet<Integer> getTenChoices() {
        return tenChoices;
    }

    public void setTenChoices(HashSet<Integer> tenChoices) {
        this.tenChoices = tenChoices;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }

    public Integer getWinnings() {
        return winnings;
    }

    public void setWinnings(Integer winnings) {
        this.winnings = winnings;
    }

    //-------------------------- My own methods ----------------------------

    public String printWelcome() {
        return "***********************************\n" +
                "***                             ***\n" +
                "******    WELCOME TO KENO    ******\n" +
                "***                             ***\n" +
                "***********************************";

    }

    public String displayInstruction(){
        return "Pick 10 numbers between 1 and 80!\n" +
                "The more numbers matched the more you win!";
    }

    public Integer getPlayerBalance(){
        return currentPlayer.getArcadeAccount().getAccountBalance();
    }

    public void getUserChoices(){
        HashSet choices = new HashSet();
        Integer count = 0;
        while(choices.size() < 10){
            currentUserChoice = Cyan.getIntegerInput("Choose your #" + (count+1) +" number");
            if(choices.contains(currentUserChoice)){
                Cyan.println("You already chose that number! Try again!");
            } else {
                choiceCondition();
                choices.add(currentUserChoice);
                count++;
            }
        }
        this.tenChoices = choices;
    }

    public void choiceCondition(){
        while(currentUserChoice < 1 || currentUserChoice > 80){
            currentUserChoice = Blue.getIntegerInput("Please choose number between 1 - 80");
        }
    }

    public HashSet twentyOneRandomNum(){
        HashSet<Integer> twentyOne = new HashSet();
        while(twentyOne.size() < 21){
            Integer input = (int) ((Math.random() * (81 - 1)) + 1);
            twentyOne.add(input);
        }
        return twentyOne;
    }

    public HashSet findMatches(){
        HashSet<Integer> matched = new HashSet<>();
        for(Integer element: tenChoices){
            if(twentyOneRandom.contains(element)){
                matched.add((element));
            }
        }
        return matched;
    }

    public Integer calculateMultiplier(){
        return multiplier = matches.size();
    }

    public Boolean playAgain(){
        if(getPlayerBalance() == 0) {
            console.setWait(1000);
            Red.println("Oh No! You've ran out of money. Goodbye");
            return true;
        } else {
            //Continue game?
            console.setWait(1000);
            Integer userInput = Cyan.getIntegerInput("Would you like to play again?\n" +
                    "1. Yes   2. No");
            if(userInput.equals(2)){
                return true;
            }
        }
        return false;
    }
}

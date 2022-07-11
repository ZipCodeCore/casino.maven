package com.github.zipcodewilmington.utils;


import com.github.zipcodewilmington.casino.GameScoreboardInterface;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private GameScoreBoard blackjackScores = new GameScoreBoard("Blackjack");
    private GameScoreBoard beetleScores = new GameScoreBoard("Beetle");
    private GameScoreBoard numberGuessScores = new GameScoreBoard("Number Guess");
    private GameScoreBoard kenoScores = new GameScoreBoard("Keno");
    private GameScoreBoard plinkoScores = new GameScoreBoard("Plinko");
    private GameScoreboardInterface[] boards = new GameScoreboardInterface[5];

    public Scoreboard(){
        this.boards[0] = beetleScores;
        this.boards[1] = blackjackScores;
        this.boards[2] = kenoScores;
        this.boards[3] = numberGuessScores;
        this.boards[4] = plinkoScores;
    }


    public GameScoreBoard getBlackJackScores() {
        return blackjackScores;
    }

    public GameScoreBoard getBeetleScores() {
        return beetleScores;
    }

    public GameScoreBoard getNumberGuessScores() {
        return numberGuessScores;
    }

    public GameScoreBoard getKenoScores() {
        return kenoScores;
    }

    public GameScoreBoard getPlinkoScores() {
        return plinkoScores;
    }

    public Integer lifetimeBets(){
        Integer totalBets = 0;
        totalBets += this.getPlinkoScores().getLifetimeBets();
        totalBets += this.getBeetleScores().getLifetimeBets();
        totalBets += this.getKenoScores().getLifetimeBets();
        totalBets += this.getBlackJackScores().getLifetimeBets();
        totalBets += this.getNumberGuessScores().getLifetimeBets();
        return totalBets;
    }

    public Integer lifetimeWinnings(){
        Integer totalBets = 0;
        totalBets += this.getPlinkoScores().getLifetimeWinnings();
        totalBets += this.getBeetleScores().getLifetimeWinnings();
        totalBets += this.getKenoScores().getLifetimeWinnings();
        totalBets += this.getBlackJackScores().getLifetimeWinnings();
        totalBets += this.getNumberGuessScores().getLifetimeWinnings();
        return totalBets;
    }

    public Integer lifetimeLosses(){
        Integer totalBets = 0;
        totalBets += this.getPlinkoScores().getLifetimeLosses();
        totalBets += this.getBeetleScores().getLifetimeLosses();
        totalBets += this.getKenoScores().getLifetimeLosses();
        totalBets += this.getBlackJackScores().getLifetimeLosses();
        totalBets += this.getNumberGuessScores().getLifetimeLosses();
        return totalBets;
    }

    public Integer[] createCSVArray(){
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < boards.length; i++){
            results.add(boards[i].getLifetimeBets());
            results.add(boards[i].getLifetimeWinnings());
            results.add(boards[i].getLifetimeLosses());
        }
        return results.toArray(new Integer[0]);
    }

    public GameScoreboardInterface[] getBoards() {
        return boards;
    }

    public String lifetimeStats(){
        String output = "Lifetime Stats";
        output += "\nBet  :$" + this.lifetimeBets();
        output += "\nWon  :$" + this.lifetimeWinnings();
        output += "\nLoss :$" + this.lifetimeLosses();

        return output;
    }

    public String printAllScores(){
        String output = this.lifetimeStats() + "\n\n";

        for(int i = 0; i < this.boards.length; i++){
            output += boards[i].printScores() + "\n\n";
        }

        return output;
    }

}

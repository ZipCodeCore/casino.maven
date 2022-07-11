package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.casino.GameScoreboardInterface;

public class GameScoreBoard implements GameScoreboardInterface {
    private Integer lifetimeBets = 0;
    private Integer lifetimeWinnings = 0;
    private Integer lifetimeLosses = 0;
    private String gameName;

    public GameScoreBoard(String name){
        this.gameName = name;
    }

    public Integer getLifetimeBets() {
        return lifetimeBets;
    }


    public void addToLifetimeBets(Integer betAmt) {
        this.lifetimeBets += betAmt;
    }

    public Integer getLifetimeWinnings() {
        return lifetimeWinnings;
    }

    public void addToLifetimeWinnings(Integer winnings) {
        this.lifetimeWinnings += winnings;
    }

    public Integer getLifetimeLosses() {
        return lifetimeLosses;
    }

    public void addToLifetimeLosses(Integer losses) {
        this.lifetimeLosses += losses;
    }

    public String getGameName(){ return this.gameName; }

    public String printScores(){
        String output = "";
        output += this.getGameName();
        output += "\nBet  :$" + this.getLifetimeBets();
        output += "\nWon  :$" + this.getLifetimeWinnings();
        output += "\nLost :$" + this.getLifetimeLosses();

        return output;
    }
}

package com.github.zipcodewilmington.casino;


import com.github.zipcodewilmington.utils.GameScoreBoard;

public interface GameScoreboardInterface {
    Integer getLifetimeBets();
    Integer getLifetimeWinnings();
    Integer getLifetimeLosses();
    void addToLifetimeWinnings(Integer winnings);
    void addToLifetimeLosses(Integer losses);
    void addToLifetimeBets(Integer bets);
    String getGameName();
    String printScores();
}

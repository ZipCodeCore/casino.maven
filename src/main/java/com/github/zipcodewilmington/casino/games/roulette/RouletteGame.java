
package com.github.zipcodewilmington.casino.games.roulette;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;


import com.github.zipcodewilmington.casino.objects.RouletteBet;
import com.github.zipcodewilmington.casino.objects.Wheel;


public class RouletteGame implements GambleableGame {
    String gameName;
    Wheel wheel;
    RoulettePlayer player;


    public RouletteGame(String gameName, RoulettePlayer player) {
        this.gameName = gameName;
        this.player = player;

    }


    @Override
    public void run() {


    }

    public int spinWheel(){
        int winningNumber = wheel.getSpinValue();
        return winningNumber;
    }


    public String getColorValue(int winningNum){
        return null;

    }



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

        //return (userInput == wheel.getSpinValue());
        return false;

    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    public int evaluateInsideBet(int bet){
        return 0;


    }

    public float calculateWinnings(RouletteBet bet){
       return 0;
    }


    @Override
    public void clearGame() {

    }
}

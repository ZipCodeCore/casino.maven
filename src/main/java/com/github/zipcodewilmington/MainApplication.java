package com.github.zipcodewilmington;


import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {


        new Casino().run();


//RouletteGame rouletteGame = new RouletteGame(new CasinoAccount("j","j", 100.0));
//rouletteGame.run();



    }
}

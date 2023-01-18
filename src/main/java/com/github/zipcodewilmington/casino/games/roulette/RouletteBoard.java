package com.github.zipcodewilmington.casino.games.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouletteBoard {
    public int ball;
    List<Integer> boardBlack;
    List<Integer> boardRed;
    Integer[] red;
    Integer[] black;

    public RouletteBoard(){

        ball= (int)(Math.random()*36+1);
    }
    public void blackAndRedArrays(){
            List<Integer> boardBlack = Arrays.asList(black);
            List<Integer> boardRed = Arrays.asList(red);
    }






}

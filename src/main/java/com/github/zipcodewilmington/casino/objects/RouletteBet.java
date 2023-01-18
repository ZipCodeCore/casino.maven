package com.github.zipcodewilmington.casino.objects;

public class RouletteBet {

    private int bet;

    public RouletteBet() {
        this.bet = 0;

    }


    public Integer[] winningStreetArray(int insideBet) {
        Integer[] array = new Integer[3];
        int j = 0;
        if (insideBet > 0 && insideBet <= 3){
                for (int i = 0; i < 3; i++) {
                    array[i] = i + 1;
                }
        } else if (insideBet > 3 && insideBet <= 6){
            for (int i = 3; i < 6 ; i++) {
                array[i-3] = i+1;
            }
        } else if (insideBet > 6 && insideBet <= 9){
            for (int i = 6; i < 9 ; i++) {
                array[i-6] = i +1;
            }
        } else if (insideBet > 9 && insideBet <= 12){
            for (int i = 9; i < 12 ; i++) {
                array[i-9] = i +1;
            }
        } else if(insideBet > 12 && insideBet <= 15){
            for (int i = 12; i < 15 ; i++) {
                array[i-12] = i +1;
            }
        } else if(insideBet > 15 && insideBet <= 18){
            for (int i = 15; i < 18 ; i++) {
                array[i-15] = i +1;
            }
        } else if (insideBet > 18 && insideBet <= 21){
            for (int i = 18; i < 21 ; i++) {
                array[i-18] = i +1;
            }
        } else if (insideBet > 21 && insideBet <= 24){
            for (int i = 21; i < 24 ; i++) {
                array[i-21] = i +1;
            }
        } else if (insideBet > 24 && insideBet <= 27){
            for (int i = 24; i < 27 ; i++) {
                array[i-24] = i +1;
            }
        } else if (insideBet > 27 && insideBet <= 30){
            for (int i = 27; i < 30 ; i++) {
                array[i-27] = i +1;
            }
        } else if (insideBet > 30 && insideBet <= 33){
            for (int i = 30; i < 33 ; i++) {
                array[i-30] = i +1;
            }
        } else if (insideBet > 33 && insideBet <= 36){
            for (int i = 33; i < 36 ; i++) {
                array[i-33] = i +1;
            }
        }
        return array;
    }
    public Integer[] winningColumn(int outsideBet){
    return null;
    }
}

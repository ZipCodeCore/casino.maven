package io.zipcoder.casino;

public class Craps extends DiceGame {
    int gameRound = 1;
    String betStatus;
    Integer[] roundOnePass = new Integer[]{7, 11};
    Integer[] roundOneNotPass = new Integer[]{2, 3, 12};
    Integer[] rollAgain = new Integer[]{4, 5, 6, 8, 9, 10};
    int pointer;

    public void addToPot(int numOfChips) {
        pot += numOfChips;
    }

    public int getPot() {
        return pot;
    }


    //1: player wins, 2: dealer wins, 3: move to next round
    public int checkWinnerRoundOne(int sumOfDice) {
        int outcome = 0;
        if (getBetStatus().equalsIgnoreCase("Pass")) {
            for (int i : roundOnePass) {
                if (sumOfDice == i) {
                    outcome = 1;
                }
            }
            for (int i : roundOneNotPass) {
                if (sumOfDice == i) {
                    outcome = 2;
                }
            }
            for (int i : rollAgain) {
                if (sumOfDice == i) {
                    outcome = 3;
                }
            }
        } else if (getBetStatus().equalsIgnoreCase("Not Pass")) {
            for (int i : roundOnePass) {
                if (sumOfDice == i) {
                    outcome = 2;
                }
            }
            for (int i : roundOneNotPass) {
                if (sumOfDice == i) {
                    outcome = 1;
                }
            }
            for (int i : rollAgain) {
                if (sumOfDice == i) {
                    outcome = 3;
                }
            }
        }
        return outcome;
    }



    //1: player wins, 2: player loses, 3: roll again
    public int checkWinnerRoundTwo(int sumOfDice) {
        int outcome;
        if (getBetStatus().equalsIgnoreCase("Pass")) {
            if (sumOfDice == getPointer()) {
                outcome = 1;
            } else if (sumOfDice == 7) {
                outcome = 2;
            } else {
                outcome = 3;
            }
        } else {
            //catches "NotPass" status
            if (sumOfDice == 7) {
                outcome = 1;
            } else if (sumOfDice == getPointer()) {
                outcome = 2;
            } else {
                outcome = 3;
            }
        }
        return outcome;
    }

    public int sumOfDice() {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += rollDice();
        }
        return sum;
    }

    public void setGameRound(int round) {
        gameRound = round;
    }

    public int getGameRound() {
        return gameRound;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getPointer() {
        return this.pointer;
    }

    public void setBetStatus(String betStatus) {
        this.betStatus = betStatus;
    }

    public String getBetStatus() {
        return this.betStatus;
    }
}
package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Set;

public class KenoPlayer implements PlayerInterface {

    IOConsole console = new IOConsole();
    CasinoAccount casinoAccount;
    KenoGame gameCurrentlyPlaying;
    Integer amountToBet;
    Integer prizeMoney;
    Set<Integer> chosenNumbers;

    public KenoPlayer(CasinoAccount casinoAccount, KenoGame gameCurrentlyPlaying) {
        this.casinoAccount = casinoAccount;
        this.gameCurrentlyPlaying = gameCurrentlyPlaying;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    @Override
    public void play() {
        chosenNumbers = gameCurrentlyPlaying.getChosenNumbers();
        checkHowManyMatch();
        amountToBet = gameCurrentlyPlaying.getBet();
        casinoAccount.reduceBalance(amountToBet);
    }

    public Integer checkHowManyMatch() {
        Integer numberOfMatches = 0;
        for (Integer chosenNumber : chosenNumbers) {
            if (gameCurrentlyPlaying.randomNumbers.contains(chosenNumber)) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

    public Integer outcomeOfGame(Integer amountBet) {
        Integer numberOfMatches = checkHowManyMatch();
        switch (numberOfMatches) {
            case 1:
                console.println("You got 1 match! You win $%s", amountBet * 2);
                prizeMoney = amountBet * 2;
                return prizeMoney;

            case 2:
                console.println("You got 2 matches! You win $%s", amountBet * 5);
                prizeMoney = amountBet * 5;
                return prizeMoney;

            case 3:
                console.println("You got 3 matches! You win $%s", amountBet * 10);
                prizeMoney = amountBet * 10;
                return prizeMoney;

            case 4:
                console.println("You got 4 matches! You win $%s", amountBet * 20);
                prizeMoney = amountBet * 20;
                return prizeMoney;

            case 5:
                console.println("You got 5 matches! You win $%s", amountBet * 40);
                prizeMoney = amountBet * 40;
                return prizeMoney;

            case 6:
                console.println("You got 6 matches! You win $%s", amountBet * 80);
                prizeMoney = amountBet * 80;
                return prizeMoney;

            case 7:
                console.println("You got 7 matches! You win $%s", amountBet * 200);
                prizeMoney = amountBet * 200;
                return prizeMoney;

            case 8:
                console.println("You got 8 matches! You win $%s", amountBet * 500);
                prizeMoney = amountBet * 500;
                return prizeMoney;

            case 9:
                console.println("You got 9 matches! You win $%s", amountBet * 4000);
                prizeMoney = amountBet * 4000;
                return prizeMoney;

            case 10:
                console.println("You got 10 matches! You win $%s", amountBet * 10000);
                prizeMoney = amountBet * 10000;
                return prizeMoney;
        }
        return null;
    }
}

package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class KenoPlayerTest {

    @Test
    public void constructorTest() {
        // Given
        CasinoAccount expectedCasinoAccount = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer kenoPlayer = new KenoPlayer(expectedCasinoAccount, kenoGame);

        // When
        CasinoAccount actualCasinoAccount = kenoPlayer.getArcadeAccount();

        // Then
        Assert.assertEquals(expectedCasinoAccount, actualCasinoAccount);
    }

    @Test
    public void checkHowManyMatchTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer kenoPlayer = new KenoPlayer(casinoAccount1, kenoGame);

        // When
        kenoPlayer.chosenNumbers = kenoGame.generateRandomNumbers();
        Integer numberOfMatches = kenoPlayer.checkHowManyMatch();

        // Then
        Assert.assertTrue(numberOfMatches >= 0 && numberOfMatches <= 10);
    }

    @Test
    public void outcomeOfGameTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer kenoPlayer = new KenoPlayer(casinoAccount1, kenoGame);

        // When
        kenoPlayer.chosenNumbers = kenoGame.generateRandomNumbers();
        kenoPlayer.checkHowManyMatch();
        Integer prizeMoney = kenoPlayer.outcomeOfGame(1);

        // Then
        Assert.assertTrue(prizeMoney >= 2 && prizeMoney <= 10000);
    }
}

package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RandomNumberGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashSet;
import java.util.Set;

public class KenoGameTest {

    @Test
    public void addTest() {
        // Given
        CasinoAccount casinoAccount = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        PlayerInterface expectedPlayer = new KenoPlayer(casinoAccount, kenoGame);

        // When
        kenoGame.add(expectedPlayer);
        PlayerInterface actualPlayer = kenoGame.getPlayer(casinoAccount.getUsername());

        // Then
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void removeTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        PlayerInterface player1 = new KenoPlayer(casinoAccount1, kenoGame);
        PlayerInterface player2 = new KenoPlayer(casinoAccount2, kenoGame);
        Integer expectedAmountOfPlayers = 1;

        // When
        kenoGame.add(player1);
        kenoGame.add(player2);
        kenoGame.remove(player1);
        Integer actualAmountOfPlayers = kenoGame.getPlayers().size();

        // Then
        Assert.assertEquals(expectedAmountOfPlayers, actualAmountOfPlayers);
    }

    /*@Test
    public void runTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer player1 = new KenoPlayer(casinoAccount1, kenoGame);
        KenoPlayer player2 = new KenoPlayer(casinoAccount2, kenoGame);
        Integer expectedPlayer1SetOfNumbersSize = 10;
        Integer expectedPlayer2SetOfNumbersSize = 10;

        // When
        kenoGame.add(player1);
        kenoGame.add(player2);
        kenoGame.run();
        Integer actualPlayer1SetOfNumbersSize = player1.chosenNumbers.size();
        Integer actualPlayer2SetOfNumbersSize = player2.chosenNumbers.size();

        // Then
        Assert.assertEquals(expectedPlayer1SetOfNumbersSize, actualPlayer1SetOfNumbersSize);
        Assert.assertEquals(expectedPlayer2SetOfNumbersSize, actualPlayer2SetOfNumbersSize);
    }*/

    @Test
    public void getPlayerTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer player1 = new KenoPlayer(casinoAccount1, kenoGame);
        KenoPlayer player2 = new KenoPlayer(casinoAccount2, kenoGame);
        KenoPlayer expectedPlayer = player1;

        // When
        kenoGame.add(player1);
        kenoGame.add(player2);
        KenoPlayer actualPlayer = kenoGame.getPlayer("Zach");


        // Then
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void getPlayersTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer player1 = new KenoPlayer(casinoAccount1, kenoGame);
        KenoPlayer player2 = new KenoPlayer(casinoAccount2, kenoGame);
        Set<KenoPlayer> expectedPlayers = new HashSet<>();
        expectedPlayers.add(player1); expectedPlayers.add(player2);

        // When
        kenoGame.add(player1);
        kenoGame.add(player2);
        Set<KenoPlayer> actualPlayers = kenoGame.getPlayers();

        // Then
        Assert.assertEquals(expectedPlayers, actualPlayers);
    }
}

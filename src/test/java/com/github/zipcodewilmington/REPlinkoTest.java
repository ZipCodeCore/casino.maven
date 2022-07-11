package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.plinko.REPlinko;
import org.junit.Assert;
import org.junit.Test;

public class REPlinkoTest {

    @Test
    public void calculateWinningsTest () {
        REPlinko game = new REPlinko();
        Integer expected = 12;

        Integer multiplier = 3;
        Integer betAmount = 4;
        Integer actual = game.calculateWinnings(multiplier, betAmount);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subtractTest() {
        REPlinko game = new REPlinko();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        game.add(player);
        player.getArcadeAccount().alterAccountBalance(200 * -1);
        Integer expected = 300;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void runTest () {
        REPlinko game = new REPlinko();
        game.setRunning(true);
        game.run();

        Integer actual = game.getUserBet();
        Integer expected = null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRunningTest () {
        REPlinko game = new REPlinko();
        boolean expected = false;
        boolean actual = game.getRunning();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removePlayerTest () {
        REPlinko game = new REPlinko();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        game.add(player);
        game.remove(player);
        Boolean expected = false;
        Boolean actual = game.getPlayerInt() != null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addPlayerTest () {
        REPlinko game = new REPlinko();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        game.add(player);
        Boolean expected = true;
        Boolean actual = game.getPlayerInt() != null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createBoardTest () {
        REPlinko game = new REPlinko();
        Integer expected = 10;

        game.createBoard();
        Integer actual = game.winningValues.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinTest () {
        REPlinko game = new REPlinko();
        Integer expected = 0;

        game.createBoard();
        Integer actual = game.checkWin();

        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void startGameTest () {
//        REPlinko game = new REPlinko();
//        Integer expected = 0;
//
//        game.startGame();
//        Integer actual = game.calculateWinnings(game.checkWin(), 100);
//
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void shuffleTest () {
        REPlinko game = new REPlinko();
        Boolean runner = false;
        Integer actual = 5;

        game.createBoard();

        while (!runner) {
            game.shuffleBoard();
            Integer expected = game.winningValues.get(0);
            if (expected == actual) {
                runner = true;
            }
        }
        Assert.assertTrue(runner);
    }

    @Test
    public void subtractMoneyTest () {
        REPlinko game = new REPlinko();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        game.add(player);
        game.subtractBetFromBalance(200);
        Integer expected = 300;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addingMoneyTest () {
        REPlinko game = new REPlinko();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        game.add(player);
        game.addMoneyToBalance(player,200);
        Integer expected = 700;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void startGameTest(){
        REPlinko game = new REPlinko();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        game.setUserBet(100);
        game.add(player);
        game.startGame();

        Integer expected = 10;
        Integer actual = game.getWinningValues().size();

        Assert.assertEquals(expected, actual);
    }
}

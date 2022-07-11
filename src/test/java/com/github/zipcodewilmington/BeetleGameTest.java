package com.github.zipcodewilmington;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Beetle.Beetle;
import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import com.github.zipcodewilmington.casino.games.Beetle.BeetlePlayer;
import org.junit.Assert;
import org.junit.Test;

public class BeetleGameTest {
    @Test
    public void constructorTest(){
        BeetleGame beetleGame = new BeetleGame();
        Beetle game = beetleGame.getGame();
        Boolean actual = game instanceof Beetle;

        Assert.assertTrue(actual);

    }

    @Test
    public void addTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        beetleGame.add(player);
        Boolean expected = true;
        Boolean actual = beetleGame.getPlayer() != null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        beetleGame.add(player);
        beetleGame.remove(player);
        Boolean expected = false;
        Boolean actual = beetleGame.getPlayer() != null;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isGameOverTest1(){
        BeetleGame beetleGame = new BeetleGame();
        beetleGame.setRunning(true);
        beetleGame.isGameOver(false);
        Boolean actual = beetleGame.getIsRunning();

        Assert.assertTrue(actual);
    }

    @Test
    public void isGameOverTest2(){
        BeetleGame beetleGame = new BeetleGame();
        beetleGame.setRunning(true);
        beetleGame.isGameOver(true);
        Boolean actual = beetleGame.getIsRunning();

        Assert.assertFalse(actual);
    }

    @Test
    public void determinePayout1(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        beetleGame.add(player);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.setBetAmt(200);
        beetleGame.getGame().setCurrentPlayer(0);
        beetleGame.determinePayout();
        Boolean actual = player.getArcadeAccount().getAccountBalance() > 500;

        Assert.assertTrue(actual);
    }

    @Test
    public void determinePayout2(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        beetleGame.add(player);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.setBetAmt(200);
        beetleGame.getGame().setCurrentPlayer(1);
        beetleGame.determinePayout();
        Boolean actual = player.getArcadeAccount().getAccountBalance() == 500;

        Assert.assertTrue(actual);
    }

    @Test
    public void calculateWinningsTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        beetleGame.add(player);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.setBetAmt(200);
        beetleGame.getGame().setCurrentPlayer(0);

        Integer actual = beetleGame.calculateWinnings(2, 200);
        Integer expected = 400;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void subtractTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.add(player);
        beetleGame.subtractBetFromBalance(200);
        Integer expected = 300;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addMoneyToBalance(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.add(player);
        beetleGame.addMoneyToBalance(player,200);
        Integer expected = 700;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printWelcomeTest(){
        BeetleGame beetleGame = new BeetleGame();

        String actual = beetleGame.printWelcome();
        String expected = "\u001B[33m***********************************\n" +
                "***                             ***\n" +
                "******   WELCOME TO BEETLE   ******\n" +
                "***                             ***\n" +
                "***********************************";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getDemoTest(){
        BeetleGame beetleGame = new BeetleGame();

        Boolean actual = beetleGame.getDemo();

        Assert.assertFalse(actual);
    }

    @Test
    public void printEndingGameMessage(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.add(player);
        beetleGame.setBetAmt(100);
        String actual = beetleGame.printEndingGameMessage();
        String expected = "\nFinal Beetle results: \n" +
                "\u001B[32mYour last dice roll: 0  Your Beetle:  \n" +
                "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                "\u001B[32mDealer's last dice roll: 0  Dealer's Beetle:  \n" +
                "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                "You win!You win!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printEndingGameMessage2(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.add(player);
        beetleGame.setBetAmt(100);
        beetleGame.getGame().setCurrentPlayer(1);
        String actual = beetleGame.printEndingGameMessage();
        String expected = "\nFinal Beetle results: \n" +
                "\u001B[32mYour last dice roll: 0  Your Beetle:  \n" +
                "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                "\u001B[32mDealer's last dice roll: 0  Dealer's Beetle:  \n" +
                "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                "Dealer wins...Dealer wins...";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printNextTurnMessage(){
        BeetleGame beetleGame = new BeetleGame();

        String actual = beetleGame.printNextTurnMessage();
        String expected =
                "\u001B[32mYour last dice roll: 0  Your Beetle:  \n" +
                "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                "\u001B[32mDealer's last dice roll: 0  Dealer's Beetle:  \n" +
                "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                "Press enter to roll next dice";
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setDemoTest(){
        BeetleGame beetleGame = new BeetleGame();

        beetleGame.setDemo(true);
        Boolean actual = beetleGame.getDemo();

        Assert.assertTrue(actual);
    }

    @Test
    public void getBetTest(){
        BeetleGame game = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        game.add(player);
        game.setBetAmt(100);

        Integer expected = 100;
        Integer actual = game.getBetAmt();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printBalanceAndBetTextTest(){
        BeetleGame game = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        game.add(player);
        game.setBetAmt(100);

        String actual = game.printBalanceAndBetText();
        String expected = "\u001B[35m Current account balance:        " + player.getArcadeAccount().getAccountBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nextPlayerTest(){
        BeetleGame game = new BeetleGame();

        game.nextPlayer();

        Integer expected = 1;
        Integer actual = game.getGame().getCurrentPlayer();

        Assert.assertEquals(expected, actual);
    }
}

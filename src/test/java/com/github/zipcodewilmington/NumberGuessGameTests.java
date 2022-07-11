package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

public class NumberGuessGameTests {

    @Test
    public void constructorTest1(){
        NumberGuessGame game = new NumberGuessGame();
        Integer actual = game.getMaxNumber();
        Integer expected = 20;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printWelcomeTest(){
        NumberGuessGame game = new NumberGuessGame();
        String expected = "************************************\n" +
                "***                              ***\n" +
                "******   !!  WELCOME TO  !!   ******\n" +
                "******  !!! GUESS NUMBER !!!  ******\n" +
                "***                              ***\n" +
                "************************************\n";
        String actual = game.printWelcome();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printInstructions(){
        NumberGuessGame game = new NumberGuessGame();
        game.printInstructions();
        //check output
    }

    @Test
    public void subtractBetFromBalanceTest(){
        //given
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        NumberGuessGame game = new NumberGuessGame();
        game.add(player1);
        Integer expected = 300;
        //when
        account.alterAccountBalance(500);
        game.subtractBetFromBalance(200);
        Integer actual = player1.getArcadeAccount().getAccountBalance();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calcPotentialEarningsTest(){
        //given
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        NumberGuessGame game = new NumberGuessGame();
        game.setBetAmount(10);
        Integer[] expected = {20,30,40,50};
        //when
        game.calcPotentialEarnings();
        Integer[] actual = game.getPotentialEarnings();
        //then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setMultiplierTest(){
        //given
        NumberGuessGame game = new NumberGuessGame();
        game.setMultiplier(20);
        Integer expected = 2;
        Integer actual = game.getMultiplier();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void pickRandomNumber(){
        //given
        NumberGuessGame game = new NumberGuessGame();
        game.pickRandomNumber();
        Integer first = game.getRandomNumber();
        game.pickRandomNumber();
        Integer second = game.getRandomNumber();
        Assert.assertNotEquals(first, second);
    }

    @Test
    public void getGuessRange(){
        NumberGuessGame game = new NumberGuessGame();
        Integer guessedNumber = 10;
        Integer actualNumber = 5;
        Integer actual = game.getGuessRange(guessedNumber, actualNumber);
        Integer expected = 25;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculatePayoutTest(){
        //given
        NumberGuessGame game = new NumberGuessGame();
        Integer expected = 50;
        Integer actual = game.calculatePayout(5,0,10);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addMoneyToBalance(){
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        NumberGuessGame game = new NumberGuessGame();
        game.add(player1);
        game.addMoneyToBalance(player1,10);

        Integer expected = 10;
        Integer actual = player1.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMaxNumberTest(){
        NumberGuessGame game = new NumberGuessGame();
        game.setMaxNumber(50);
        Integer actual = game.getMaxNumber();
        Integer expected = 50;

        Assert.assertEquals(actual, expected);
    }



    @Test
    public void getGuessPercentage(){
        NumberGuessGame game = new NumberGuessGame();
        Integer guessedNumber = 10;
        Integer max = game.getMaxNumber();
        Integer actualNumber = 5;
        Integer range = Math.abs(guessedNumber - actualNumber);
        Integer actual = game.guessRangePercentage(range);
        Integer expected = 25;

        Assert.assertEquals(actual, expected);
    }

}

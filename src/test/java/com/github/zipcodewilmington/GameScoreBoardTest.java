package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.GameScoreboardInterface;
import com.github.zipcodewilmington.utils.GameScoreBoard;
import com.github.zipcodewilmington.utils.Scoreboard;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreBoardTest {

    @Test
    public void constructorTest(){
        Scoreboard scoreboard = new Scoreboard();
        GameScoreboardInterface[] boards = new GameScoreboardInterface[5];
        boards[0] = scoreboard.getBeetleScores();
        boards[1] = scoreboard.getBlackJackScores();
        boards[2] = scoreboard.getNumberGuessScores();
        boards[3] = scoreboard.getKenoScores();
        boards[4] = scoreboard.getPlinkoScores();
        Boolean isScoreboard = false;

        for(int i = 0; i < boards.length; i++){
            if(boards[i] instanceof GameScoreboardInterface){
                isScoreboard = true;
            } else {
                isScoreboard = false;
                break;
            }
        }

        Assert.assertTrue(isScoreboard);
    }

    @Test
    public void lifetimeBetsTest(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeBets(100);

        Integer actual = scoreboard.getPlinkoScores().getLifetimeBets();
        Integer expected = 100;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lifetimeWinningsTest(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeWinnings(400);

        Integer actual = scoreboard.getPlinkoScores().getLifetimeWinnings();
        Integer expected = 400;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lifetimeLossesTest(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeLosses(400);

        Integer actual = scoreboard.getPlinkoScores().getLifetimeLosses();
        Integer expected = 400;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void scoreboardLifetimeBets(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeBets(300);

        Integer actual = scoreboard.lifetimeBets();
        Integer expected = 300;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void scoreboardLifetimeWinnings(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeWinnings(300);

        Integer actual = scoreboard.lifetimeWinnings();
        Integer expected = 300;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void scoreboardLifetimeLosses(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeLosses(300);

        Integer actual = scoreboard.lifetimeLosses();
        Integer expected = 300;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void scoreboardCSVArrayTest(){
        Scoreboard scoreboard = new Scoreboard();
        Integer[] expected = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
        Integer[] actual = scoreboard.createCSVArray();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getBoardsTest(){
        Scoreboard scoreboard = new Scoreboard();

        GameScoreboardInterface[] boards = scoreboard.getBoards();
        Boolean actual = boards[0] instanceof GameScoreboardInterface;

        Assert.assertTrue(actual);
    }

    @Test
    public void printScoreTest(){
        Scoreboard scoreboard = new Scoreboard();

        String actual = scoreboard.printAllScores();
        String expected = "Lifetime Stats\n" +
                "Bet  :$0\n" +
                "Won  :$0\n" +
                "Loss :$0\n" +
                "\n" +
                "Beetle\n" +
                "Bet  :$0\n" +
                "Won  :$0\n" +
                "Lost :$0\n" +
                "\n" +
                "Blackjack\n" +
                "Bet  :$0\n" +
                "Won  :$0\n" +
                "Lost :$0\n" +
                "\n" +
                "Keno\n" +
                "Bet  :$0\n" +
                "Won  :$0\n" +
                "Lost :$0\n" +
                "\n" +
                "Number Guess\n" +
                "Bet  :$0\n" +
                "Won  :$0\n" +
                "Lost :$0\n" +
                "\n" +
                "Plinko\n" +
                "Bet  :$0\n" +
                "Won  :$0\n" +
                "Lost :$0\n\n";

        Assert.assertEquals(expected, actual);
    }
}

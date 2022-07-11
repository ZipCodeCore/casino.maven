package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.keno.KenoGameRE;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.stream.Stream;

public class KenoGameRETest {

    @Test
    public void addPlayerTest(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        keno.add(player1);
        PlayerInterface retrievedPlayer = keno.getCurrentPlayer();
        Assert.assertEquals(player1,retrievedPlayer );
    }

    @Test
    public void removePlayerTest() {
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        keno.remove(player1);
        Assert.assertNull(keno.getCurrentPlayer());
    }

    @Test
    public void printWelcome(){
        KenoGameRE keno = new KenoGameRE();
        String expected = "***********************************\n" +
                "***                             ***\n" +
                "******    WELCOME TO KENO    ******\n" +
                "***                             ***\n" +
                "***********************************";
        String actual = keno.printWelcome();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void displayInstructions(){
        KenoGameRE keno = new KenoGameRE();
        String expected = "Pick 10 numbers between 1 and 80!\n" +
                "The more numbers matched the more you win!";
        String actual = keno.displayInstruction();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPlayerBalance(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        account.alterAccountBalance(100);
        Player player1 = new Player(null, account);
        keno.add(player1);
        keno.setUserBet(20);
        keno.subtractBetFromBalance(20);
        Integer actual = player1.getArcadeAccount().getAccountBalance();
        Integer exp = 80;
        Assert.assertEquals(exp,actual);
    }

    @Test
    public void twentyOneRandomNum(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        account.alterAccountBalance(100);
        Player player1 = new Player(null, account);
        keno.add(player1);
        keno.setTwentyOneRandom(keno.twentyOneRandomNum());
        Integer actual = keno.getTwentyOneRandom().size();
        Integer expected = 21;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findMatches(){
        KenoGameRE keno = new KenoGameRE();
        HashSet<Integer> userChoices = new HashSet<>();
        Stream.of(1,2,3,4,5,6,7,8,9,10).forEach(e -> userChoices.add(e));
        HashSet<Integer> twentyOne = new HashSet<>();
        Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21).forEach(e -> twentyOne.add(e));

        keno.setTenChoices(userChoices);
        keno.setTwentyOneRandom(twentyOne);
        keno.setMatches(keno.findMatches());

        Assert.assertEquals(userChoices,keno.getMatches());
    }

    @Test
    public void multiplier(){
        KenoGameRE keno = new KenoGameRE();
        HashSet<Integer> matches = new HashSet<>();
        Stream.of(1,2,3,4,5,6,7,8,9,10).forEach(e -> matches.add(e));
        keno.setMatches(matches);
        Integer actual = keno.calculateMultiplier();
        Integer expected = 10;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculateWinning(){
        KenoGameRE keno = new KenoGameRE();
        Integer actual = keno.calculateWinnings(10, 5);
        Integer exp = 50;
        Assert.assertEquals(exp,actual);
    }

    @Test
    public void addMoneyToBalance(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        keno.add(player1);
        keno.addMoneyToBalance(player1,500);
        Integer exp = 500;
        Integer act = keno.getPlayerBalance();
        Assert.assertEquals(exp,act);
    }

    @Test
    public void playAgain(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        keno.add(player1);
        Boolean quit = keno.playAgain();
        Assert.assertTrue(quit);
    }

    @Test
    public void getWinningsTest(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        keno.add(player1);
        keno.setWinnings(100);
        Integer actual = keno.getWinnings();
        Integer expected = 100;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setMultiplierTest(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        keno.add(player1);
        keno.setMultiplier(10);
        Integer actual = keno.getMultiplier();
        Integer expected = 10;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTenChoices(){
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        keno.add(player1);
        HashSet<Integer> expected = new HashSet<>();
        expected.add(1);
        keno.setTenChoices(expected);
        HashSet<Integer> actual = keno.getTenChoices();


        Assert.assertTrue(expected.equals(actual));
    }

}

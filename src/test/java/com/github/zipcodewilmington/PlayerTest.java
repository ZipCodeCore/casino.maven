package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Beetle.BeetlePlayer;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void constructorTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        Assert.assertNotNull(player);

    }

    @Test
    public void getNameTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        Player player = new Player("Bjork", account);

        String actual = player.getName();
        String expected = "Bjork";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setCurrentBetTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        Player player = new Player("Bjork", account);
        player.setCurrentBet(200);

        Integer actual = player.getCurrentBet();
        Integer expected = 200;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setBalanceTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        Player player = new Player("Bjork", account);
        player.setBalance(2000);

        Integer actual = player.getBalance();
        Integer expected = 2000;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void makeBetTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        Player player = new Player("Bjork", account);
        player.setBalance(2000);

        player.makeBet(1000);

        Integer expected = 1000;
        Integer actual = player.getCurrentBet();

        Assert.assertEquals(expected, actual);
    }
}

package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Beetle.BeetlePlayer;
import org.junit.Assert;
import org.junit.Test;

public class BeetlePlayerTest {

    @Test
    public void constructorTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        BeetlePlayer beetlePlayer = new BeetlePlayer(player);

        PlayerInterface expected = player;
        PlayerInterface actual = beetlePlayer.getPlayer();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        BeetlePlayer beetlePlayer = new BeetlePlayer(player);

        CasinoAccount actual = beetlePlayer.getArcadeAccount();
        CasinoAccount expected = account;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        BeetlePlayer beetlePlayer = new BeetlePlayer(player);
        beetlePlayer.setArcadeAccount(account);

        CasinoAccount actual = beetlePlayer.getArcadeAccount();
        CasinoAccount expected = account;

        Assert.assertEquals(actual, expected);

    }
}

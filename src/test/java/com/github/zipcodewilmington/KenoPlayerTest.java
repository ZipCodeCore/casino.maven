package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;
import org.junit.Assert;
import org.junit.Test;

public class KenoPlayerTest {
    @Test
    public void constructorTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        KenoPlayer keno = new KenoPlayer(player);

        PlayerInterface expected = player;
        PlayerInterface actual = keno.getPlayer();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        KenoPlayer keno = new KenoPlayer(player);

        CasinoAccount actual = keno.getArcadeAccount();
        CasinoAccount expected = account;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        KenoPlayer keno = new KenoPlayer(player);
        keno.setArcadeAccount(account);

        CasinoAccount actual = keno.getArcadeAccount();
        CasinoAccount expected = account;

        Assert.assertEquals(actual, expected);

    }
}


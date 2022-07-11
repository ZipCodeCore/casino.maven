package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackPlayerTest {

    @Test
    public void constructorTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        BlackJackPlayer bj = new BlackJackPlayer(player);

        PlayerInterface expected = player;
        PlayerInterface actual = bj.getPlayer();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        BlackJackPlayer bj = new BlackJackPlayer(player);

        CasinoAccount actual = bj.getArcadeAccount();
        CasinoAccount expected = account;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        BlackJackPlayer bj = new BlackJackPlayer(player);
        bj.setArcadeAccount(account);

        CasinoAccount actual = bj.getArcadeAccount();
        CasinoAccount expected = account;

        Assert.assertEquals(actual, expected);

    }
}

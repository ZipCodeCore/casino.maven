package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import org.junit.Assert;
import org.junit.Test;

public class NumberGuessPlayerTest {
    @Test
    public void numberGuessPlayerTest(){
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        PlayerInterface player = new Player("john",account);
        NumberGuessPlayer gp = new NumberGuessPlayer(player);
        //when
        PlayerInterface expected = player;
        PlayerInterface actual = gp.getPlayer();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getArcadeAccountTest(){
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        PlayerInterface player = new Player("john",account);
        NumberGuessPlayer gp = new NumberGuessPlayer(player);
        //when
        CasinoAccount retrieved = gp.getArcadeAccount();
        //then
        Assert.assertEquals(account, retrieved);

    }

    @Test
    public void setArcadeAccountTest(){
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        CasinoAccount account2 = new CasinoAccount("ddd", "eee");
        PlayerInterface player = new Player("john",account);
        NumberGuessPlayer gp = new NumberGuessPlayer(player);
        //when
        gp.setArcadeAccount(account2);
        CasinoAccount retrieved = gp.getArcadeAccount();
        //then
        Assert.assertEquals(account2, retrieved);
    }

    @Test
    public void getPlayerTest(){
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        PlayerInterface player = new Player("john",account);
        NumberGuessPlayer gp = new NumberGuessPlayer(player);
        //when
        PlayerInterface retrieved = gp.getPlayer();
        //then
        Assert.assertEquals(player, retrieved);
    }
}

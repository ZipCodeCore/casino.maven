package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class SlotsPlayerTest {

    @Test
    public void constructorTest(){
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        PlayerInterface player = new Player("john",account);
        SlotsPlayer slotPlayer = new SlotsPlayer(player);
        //when
        PlayerInterface expected = player;
        PlayerInterface actual = slotPlayer.getPlayer();
        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getArcadeAccount() {
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        PlayerInterface player = new Player("john",account);
        SlotsPlayer slotPlayer = new SlotsPlayer(player);
        //when
        CasinoAccount retrieved = slotPlayer.getArcadeAccount();
        //then
        Assert.assertEquals(account, retrieved);
    }

    @Test
    public void setArcadeAccount() {
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        CasinoAccount account2 = new CasinoAccount("ddd", "eee");
        PlayerInterface player = new Player("john",account);
        SlotsPlayer slotPlayer = new SlotsPlayer(player);
        //when
        slotPlayer.setArcadeAccount(account2);
        CasinoAccount retrieved = slotPlayer.getArcadeAccount();
        //then
        Assert.assertEquals(account2, retrieved);

    }

    @Test
    public void getPlayer() {
        //given
        CasinoAccount account = new CasinoAccount("aaa", "bbb");
        PlayerInterface player = new Player("john",account);
        SlotsPlayer slotPlayer = new SlotsPlayer(player);
        //when
        PlayerInterface retrieved = slotPlayer.getPlayer();
        //then
        Assert.assertEquals(player, retrieved);
    }
}

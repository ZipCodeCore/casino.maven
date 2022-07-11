package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.plinko.PlinkoPlayer;
import org.junit.Assert;
import org.junit.Test;

public class PlinkoPlayerTest {

    @Test
    public void constructorTest(){
        CasinoAccount account = new CasinoAccount("zz", "ss");
        Player player = new Player("brep", account);
        PlinkoPlayer plinkoPlayer = new PlinkoPlayer(player);

        Assert.assertNotNull(plinkoPlayer);
    }

    @Test
    public void getArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("zz", "ss");
        Player player = new Player("brep", account);
        PlinkoPlayer plinkoPlayer = new PlinkoPlayer(player);
        CasinoAccount playerAccount = plinkoPlayer.getArcadeAccount();
        Assert.assertEquals(account, playerAccount);
    }

    @Test
    public void setArcadeAccountTest(){
        CasinoAccount account = new CasinoAccount("zz", "ss");
        Player player = new Player("brep", account);
        PlinkoPlayer plinkoPlayer = new PlinkoPlayer(player);
        plinkoPlayer.setArcadeAccount(account);
        CasinoAccount playerAccount = plinkoPlayer.getArcadeAccount();
        Assert.assertEquals(account, playerAccount);
    }
}

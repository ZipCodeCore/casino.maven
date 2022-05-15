package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardGames.BlackJack;
import com.github.zipcodewilmington.casino.games.cardGames.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import org.junit.Assert;
import org.junit.Test;

public class RoulettePlayerTest {

    @Test
    public void implementationTest(){
      //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1200.);
        RoulettePlayer roulettePlayer = new RoulettePlayer(casinoAccount);

      //when

      //then
        Assert.assertTrue(roulettePlayer instanceof PlayerInterface);
    }





}

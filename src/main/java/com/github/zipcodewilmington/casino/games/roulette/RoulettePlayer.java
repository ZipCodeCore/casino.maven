package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {
    private CasinoAccount arcadeAccount;

    public  RoulettePlayer(){
        this.arcadeAccount = new CasinoAccount();
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.arcadeAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

   public Double getBalance(){
        return this.getArcadeAccount().getBalance();
   }
}
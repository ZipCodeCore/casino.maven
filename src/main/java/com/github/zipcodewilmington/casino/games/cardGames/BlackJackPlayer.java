package com.github.zipcodewilmington.casino.games.cardGames;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BlackJackPlayer implements PlayerInterface {
    private CasinoAccount arcadeAccount;

    public  BlackJackPlayer( CasinoAccount casinoAccount){
        this.arcadeAccount = casinoAccount;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.arcadeAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}

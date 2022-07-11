package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by Nathan 7/12/2021
 */
public class NumberGuessPlayer implements PlayerInterface {
    private PlayerInterface player;

    public NumberGuessPlayer(PlayerInterface player){
        this.player = player;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return player.getArcadeAccount();
    }

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {
        this.player.setArcadeAccount(casinoAccount);
    }

    public PlayerInterface getPlayer() {
        return this.player;
    }
}
package com.github.zipcodewilmington.casino.games.Beetle;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BeetlePlayer implements PlayerInterface {
    private PlayerInterface player;

    public BeetlePlayer(PlayerInterface player){
        this.player = player;
    }


    public CasinoAccount getArcadeAccount() {
        return player.getArcadeAccount();
    }

    public void setArcadeAccount(CasinoAccount casinoAccount) {
        this.player.setArcadeAccount(casinoAccount);
    }

    public PlayerInterface getPlayer() {
        return player;
    }
}

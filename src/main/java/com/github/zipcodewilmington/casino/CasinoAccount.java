package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.Scoreboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private String password;
    private String accountName;
    private Integer accountBalance = 0;
    private Scoreboard scoreboard;

    public CasinoAccount(String accountName, String accountPassword){
        this.accountName = accountName;
        this.password = accountPassword;
        this.scoreboard = new Scoreboard();
    }

    public CasinoAccount(String accountName, String accountPassword, Scoreboard scoreboard){
        this.accountName = accountName;
        this.password = accountPassword;
        this.scoreboard = scoreboard;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountName() {
        return accountName;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void alterAccountBalance(Integer value) {
        this.accountBalance += value;
    }

    public Scoreboard getScoreboard(){ return scoreboard; }
}

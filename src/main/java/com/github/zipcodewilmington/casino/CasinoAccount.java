package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {


    // todo get acct info from casino.java into here


    private String username;
    private String password;
    private Double balance;


    public CasinoAccount(String username, String password, Double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }



    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

//    public void addBalance(Double amountToAdd) {
//        this.balance += amountToAdd;
//    }
//    public void reduceBalance(Double amountToReduce) {
//        this.balance -= amountToReduce;
//    }

}



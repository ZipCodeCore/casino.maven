package com.github.zipcodewilmington.casino;


public class Player implements PlayerInterface{

    private String name;
    private Integer balance = 0;
    private Integer currentBet = 0;
    private CasinoAccount arcadeAccount;

    public Player(String name, CasinoAccount account) {
        this.name = name;
        this.arcadeAccount = account;
    }

    public String getName() {
        return name;
    }


    public Integer getBalance() {
        return balance;
    }

    public void setCurrentBet(Integer currentBet) {
        this.currentBet = currentBet;
    }

    public void setBalance(Integer deposit) {
        this.balance = balance + deposit;
    }


    public Integer makeBet(Integer betAmount) {
        currentBet = betAmount;
        balance = balance - currentBet;
        return currentBet;
    }

    public Integer getCurrentBet() {
        return currentBet;
    }

    public CasinoAccount getArcadeAccount(){
        return this.arcadeAccount;
    }

    public void setArcadeAccount(CasinoAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }
}

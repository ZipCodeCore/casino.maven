package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;

//import javax.smartcardio.Card;


public class BlackJack {
    private Player user;
    private int answerHitOrStay;
    private int wageBucket;
    private int blackJackDeck;

    public BlackJack(Player player) {
        this.user = player;
    }

    public void startGame() {}

    public void promptHitOrStay(){

    }

    public void dealerHitOrStay(){}  //

    public void hit(Player deck, Player player) {}

    public void stay(){}

    public void distributeWinnings(){}

    public void checkCardValue(Card firstCard, Card secondCard){}

    public void getWinner (CardHand dealer, CardHand player){}

    public void promptLeaveGame() {}

    public void displayResults() {}







}
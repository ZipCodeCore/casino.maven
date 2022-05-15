package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardGames.*;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackTest {
    @Test
    public void testRules() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        String expected = "Blackjack is played with one or more standard 52-card decks, with each denomination assigned a\n " +
                "point value. The cards 2 through 10 are worth their face value. Kings, queens, and jacks are each\n" +
                " worth 10, and aces may be used as either 1 or 11. The object for the player is to draw cards\n" +
                " totaling closer to 21, without going over, than the dealer's cards.\n";

        //when
        String actual = blackJack.rules();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinnerTest1() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Integer totalPlayerValue = 0;
        Integer totalDealerValue = 22;
        Double balance = 1200.0;
        Double wager = 200.0;
        String expected = "You are the winner!";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue, balance, wager);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinnerTest2() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        Double balance = 1200.0;
        Double wager = 200.0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue, balance, wager);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerActionTest1() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank rank = Rank.JACK;
        Suit suit = Suit.SPADES;
        Cards card = new Cards(suit, rank);
        Integer totalDealerValue = 15;
        String expected = "The dealer drew a " + card + ".";

        //when
        String actual = blackJack.dealerAction(totalDealerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerActionTest2() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank rank = Rank.KING;
        Suit suit = Suit.SPADES;
        Cards card = new Cards(suit, rank);
        Integer totalDealerValue = 18;
        String expected = "The dealer has a " + card + ".";

        //when
        String actual = blackJack.dealerAction(totalDealerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking1() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.ACE;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.SIX;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 1;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 1;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking2() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.ACE;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.SIX;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 11;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 11;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking3() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.JACK;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.SIX;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 1;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 10;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking4() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.QUEEN;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.SIX;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 1;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 10;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking5() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.KING;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.SIX;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 1;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 10;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking6() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.SIX;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.JACK;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 1;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 10;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking7() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.SIX;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.QUEEN;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 1;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 10;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking8() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Rank pRank = Rank.SIX;
        Suit pSuit = Suit.SPADES;
        Rank dRank = Rank.KING;
        Suit dSuit = Suit.SPADES;
        Integer ACEValue = 1;
        Cards dealer = new Cards(dSuit, dRank);
        Cards player = new Cards(pSuit, pRank);
        Integer expected = 10;

        //when
        Integer actual = blackJack.valueChecking(dealer, player, ACEValue);

        //then
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void dealCardsTest() {
//        //given
//        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
//        BlackJack blackJack = new BlackJack(casinoAccount);
//        Cards dealer = new Cards(Suit.SPADES, Rank.SIX);
//        Cards player = new Cards(Suit.CLUBS, Rank.FIVE);
//        String expected = "The dealer drew a " + dealer + "\n" + "You drew a " + player;
//
//        //when
//        String actual = blackJack.dealCards(dealer, player);
//
//        //then
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void valueOfACETest1() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Integer expected = 1;
        String choice = "1";

        //when
        Integer actual = blackJack.valueOfACE(choice);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueOfACETest2() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Integer expected = 11;
        String choice = "11";

        //when
        Integer actual = blackJack.valueOfACE(choice);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void continuePlayingTest1() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Boolean expected = true;
        String choice = "yes";

        //when
        Boolean actual = blackJack.continuePlaying(choice);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void continuePlayingTest2() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Boolean expected = false;
        String choice = "no";

        //when
        Boolean actual = blackJack.continuePlaying(choice);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void userActionTest1() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        createDeck deck = new createDeck();
        Cards dealer = new Cards(Suit.SPADES, Rank.SIX);
        Cards player = new Cards(Suit.CLUBS, Rank.FIVE);
        Integer ACEValue = 1;
        Double wager = 200.0;
        String expected = "You said hit.";
        String choice = "hit";

        //when
        String actual = blackJack.userAction(choice, player, dealer, deck, ACEValue, wager);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void userActionTest2() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        createDeck deck = new createDeck();
        Cards dealer = new Cards(Suit.SPADES, Rank.SIX);
        Cards player = new Cards(Suit.CLUBS, Rank.FIVE);
        Integer ACEValue = 1;
        Double wager = 200.0;
        String expected = "You said stand.";
        String choice = "stand";

        //when
        String actual = blackJack.userAction(choice, player, dealer, deck, ACEValue, wager);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void userActionTest3() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        createDeck deck = new createDeck();
        Cards dealer = new Cards(Suit.SPADES, Rank.SIX);
        Cards player = new Cards(Suit.CLUBS, Rank.FIVE);
        Integer ACEValue = 1;
        Double wager = 200.0;
        String expected = "You said double down.";
        String choice = "double down";

        //when
        String actual = blackJack.userAction(choice, player, dealer, deck, ACEValue, wager);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleDeckTest() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        createDeck deck = new createDeck();
        createDeck expected = new createDeck();

        //when
        createDeck actual = blackJack.shuffleDeck(deck);

        //then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void rankValueTest() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        Cards dealer = new Cards(Suit.SPADES, Rank.SIX);
        Integer expected = 6;

        //when
        Integer actual = dealer.value();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        PlayerInterface player = new BlackJackPlayer(casinoAccount);

        //when
        blackJack.add(player);
        CasinoAccount actual = player.getArcadeAccount();

        //then
        Assert.assertNotNull(actual);
    }

    @Test
    public void removeTest() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("j", "j", 1500.0);
        BlackJack blackJack = new BlackJack(casinoAccount);
        PlayerInterface player = new BlackJackPlayer(casinoAccount);

        //when
        blackJack.remove(player);
        CasinoAccount actual = player.getArcadeAccount();

        //then
        Assert.assertNotNull(actual);
    }
}

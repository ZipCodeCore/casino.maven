package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJackTest {
    @Test
    public void generateNewDeckTest() {
        BlackJack bj = new BlackJack();
        Integer expected = 52;

        Integer actual1 = bj.generateNewDeck().size();
        List<Integer> actual = bj.generateNewDeck();
        System.out.println(actual);

        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void givePlayerCardTest() {
        BlackJack bj = new BlackJack();
        Integer expected = 2;

        bj.givePlayerCard();
        bj.givePlayerCard();
        Integer actual = bj.getPlayersHand().size();

        System.out.println(bj.getPlayersHand());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveDealerCardTest () {
        BlackJack bj = new BlackJack();
        Integer expected = 2;

        bj.giveDealerCard();
        bj.giveDealerCard();
        Integer actual = bj.getDealersHand().size();

        System.out.println(bj.getDealersHand());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playersCurrentValueTest () {
        BlackJack bj = new BlackJack();

        // Solid stopping point = need to populate array for test
        bj.givePlayerCard();
        bj.givePlayerCard();
        System.out.println(bj.playersCurrentValue());

        List<Integer> expected = bj.getPlayersHand();

        bj.playersCurrentValue();
        Integer actual = bj.playersCurrentValue();

        System.out.println(expected);
        System.out.println(actual);
    }

    @Test
    public void dealersCurrentValueTest () {
        BlackJack bj = new BlackJack();
        List<Integer> expected = bj.getDealersHand();

        bj.dealersCurrentValue();
        Integer actual = bj.dealersCurrentValue();

        System.out.println(expected);
        System.out.println(actual);
    }

    @Test
    public void givePlayerCardOnSplitTest () {
        BlackJack bj = new BlackJack();
        List<Integer> expected = bj.getPlayersHandOnSplit();

        List<Integer> actual = bj.givePlayerCardOnSplit();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void splitPlayersCurrentValueTest () {
        BlackJack bj = new BlackJack();
        Integer expected = 0;

        bj.getPlayersHandOnSplit().add(0);
        Integer actual = bj.splitPlayersCurrentValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPlayersHandTest(){
        BlackJack bj = new BlackJack();
        List<Integer> playersHand = new ArrayList<>();

        playersHand.add(10);
        bj.setPlayersHand(playersHand);
        List<Integer> actual = bj.getPlayersHand();

        Assert.assertArrayEquals(playersHand.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    @Test
    public void setDealersHandTest(){
        BlackJack bj = new BlackJack();
        List<Integer> playersHand = new ArrayList<>();

        playersHand.add(10);
        bj.setDealersHand(playersHand);
        List<Integer> actual = bj.getDealersHand();

        Assert.assertArrayEquals(playersHand.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    @Test
    public void setPlayersHandOnSplitTest(){
        BlackJack bj = new BlackJack();
        List<Integer> playersHand = new ArrayList<>();
        playersHand.add(11);
        playersHand.add(11);
        bj.setPlayersHandOnSplit(playersHand);
        Integer actual = bj.getPlayersHandOnSplit().size();
        Integer expected = 2;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void playerBreaks21Test1(){
        BlackJack bj = new BlackJack();
        List<Integer> playersHand = new ArrayList<>();
        playersHand.add(11);
        playersHand.add(9);
        playersHand.add(9);

        bj.setPlayersHand(playersHand);
        Boolean actual = bj.playerBreaks21();
        Boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerBreaks21Test2(){
        BlackJack bj = new BlackJack();
        List<Integer> playersHand = new ArrayList<>();
        playersHand.add(9);
        playersHand.add(9);

        bj.setPlayersHand(playersHand);
        Boolean actual = bj.playerBreaks21();
        Boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealersCurrentValueTest2(){
        BlackJack bj = new BlackJack();
        List<Integer> dealersHand = new ArrayList<>();

        dealersHand.add(10);
        bj.setDealersHand(dealersHand);

        Integer expected = 10;
        Integer actual = bj.dealersCurrentValue();

       Assert.assertEquals(expected, actual);
    }
}

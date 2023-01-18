package com.github.zipcodewilmington.casino.objects;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    public void populateDeck() {
       Deck deck = new Deck(1);
       deck.populateDeck();
       deck.shuffleDeck();
       ArrayList<Card> hand = new ArrayList<>();
       hand.add(deck.dealCard());
        System.out.println();
    }
}
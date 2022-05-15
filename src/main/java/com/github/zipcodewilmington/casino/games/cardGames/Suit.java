package com.github.zipcodewilmington.casino.games.cardGames;

public enum Suit {
    HEARTS("♡"),
    CLUBS("♧"),
    DIAMONDS("♢"),
    SPADES("♤");

    private final String graphic;

    Suit(String graphic) {
        this.graphic = graphic;
    }
}

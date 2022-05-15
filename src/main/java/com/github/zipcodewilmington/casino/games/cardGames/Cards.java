package com.github.zipcodewilmington.casino.games.cardGames;

public class Cards {
    private final Suit suit;
    private final Rank rank;

    public Cards(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Integer value() {
        return rank.getFirstValue();
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

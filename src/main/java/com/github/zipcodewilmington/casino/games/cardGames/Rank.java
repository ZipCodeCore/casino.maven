package com.github.zipcodewilmington.casino.games.cardGames;

public enum Rank {
    ACE(1, 11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);


    private final Integer firstValue;
    private final Integer secondValue;

    Rank(Integer value) {
        this.firstValue = value;
        this.secondValue = value;
    }

    Rank(Integer firstValue, Integer secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public Integer getSecondValue() {
        return secondValue;
    }
}

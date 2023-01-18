package com.github.zipcodewilmington.casino.games.CardGame;

public enum FaceValueOfCard {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

    private Integer faceValueOfCard;

    FaceValueOfCard(Integer faceValueOfCard) {
        this.faceValueOfCard =faceValueOfCard ;
    }
    public Integer getCardIntegerValue() {
        return faceValueOfCard;
    }

}


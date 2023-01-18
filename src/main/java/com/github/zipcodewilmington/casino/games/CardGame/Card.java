package com.github.zipcodewilmington.casino.games.CardGame;

public class Card{
    FaceValueOfCard faceValueOfCard;
    Suit suit;
    public Card(){

    }
    public Card(FaceValueOfCard value, Suit suit){
        this.faceValueOfCard=value;
        this.suit=suit;
    }

    public FaceValueOfCard getFaceValueOfCard() {
        return faceValueOfCard;
    }

    public void setFaceValueOfCard(FaceValueOfCard faceValueOfCard) {
        this.faceValueOfCard = faceValueOfCard;
    }

    public Suit getSuit() {
        return suit;
    }
    public String getFaceValueAndSuit() {
        StringBuilder sb = new StringBuilder();
        sb.append(faceValueOfCard+"-"+suit);
        sb.append("\n");
        return sb.toString();
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}


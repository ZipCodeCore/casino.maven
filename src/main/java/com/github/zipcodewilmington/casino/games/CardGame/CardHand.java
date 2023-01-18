package com.github.zipcodewilmington.casino.games.CardGame;
import java.util.ArrayList;
import java.util.Comparator;

public class CardHand{
    ArrayList<Card> userHand = new ArrayList<Card>();
    public CardHand(ArrayList<Card> dealtCards){
        userHand.addAll(dealtCards);
    }

    public String displayHand() {

        userHand.sort(Comparator.comparing(Card::getFaceValueOfCard));
        StringBuilder sb = new StringBuilder();
        for (Card card: userHand
        ) { sb.append(card.getFaceValueAndSuit());
        }
        return sb.toString();
    }



}


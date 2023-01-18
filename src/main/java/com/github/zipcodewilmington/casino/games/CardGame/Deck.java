package com.github.zipcodewilmington.casino.games.CardGame;
import com.github.zipcodewilmington.casino.games.CardGame.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> cardDeck = new Stack<>();


    public Deck(int numberOfDecks) {
        for (int index = 0; index < numberOfDecks; index++) {
            for (FaceValueOfCard value : FaceValueOfCard.values()) {
                for (Suit cardSuit : Suit.values()) {

                    Card card = new Card(value, cardSuit);
                    this.cardDeck.add(card);
                }

            }
            Collections.shuffle(cardDeck);
        }
    }

    public Deck() {

    }

    public void shuffle() {
        Collections.shuffle(cardDeck);
    }

    public Integer getSize() {
        return cardDeck.size();
    }

    public ArrayList<Card> dealCards(int numberOfCards) {

        ArrayList<Card> dealingCards = new ArrayList<Card>();

        for (int index = 0; index < numberOfCards; index++) {
            dealingCards.add(cardDeck.pop());
        }
        return dealingCards;
    }


    public Card drawCard() {
        if (!cardDeck.isEmpty()) {
            Card drawnCard = cardDeck.pop();
            return drawnCard;

        } else
            System.out.println("Deck is empty");

        return null;
    }

    public void setDeck(Stack<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public Stack<Card> getDeck() {
        return cardDeck;
    }

}
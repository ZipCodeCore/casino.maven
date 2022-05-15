package com.github.zipcodewilmington.casino.games.cardGames;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class createDeck {
    Stack<Cards> cardsStack = new Stack<>();

    public createDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardsStack.add(new Cards(suit, rank));
            }
        }
    }
}

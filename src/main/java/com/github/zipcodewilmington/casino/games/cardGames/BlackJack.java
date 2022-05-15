package com.github.zipcodewilmington.casino.games.cardGames;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Collections;

public class BlackJack implements GameInterface {
    private IOConsole input = new IOConsole(AnsiColor.BLUE);
    createDeck deck = new createDeck();
    private Cards dealer;
    Integer ACEValue = 1;
    private Rank dealerRank;
    private Integer dealerValue = 0;
    Integer totalDealerValue = 0;
    private Cards player;
    private Rank playerRank;
    private Integer playerValue = 0;
    Integer totalPlayerValue = 0;
    private PlayerInterface blackJackPlayer;
    private Double balance;
    private Double wager;
    private String choice;

    public BlackJack(CasinoAccount casinoAccount) {
        blackJackPlayer = new BlackJackPlayer(casinoAccount);
        balance = blackJackPlayer.getArcadeAccount().getBalance();
        dealer = deck.cardsStack.pop();
        player = deck.cardsStack.pop();
    }

    public String rules() {
        return "Blackjack is played with one or more standard 52-card decks, with each denomination assigned a\n " +
                "point value. The cards 2 through 10 are worth their face value. Kings, queens, and jacks are each\n" +
                " worth 10, and aces may be used as either 1 or 11. The object for the player is to draw cards\n" +
                " totaling closer to 21, without going over, than the dealer's cards.\n";
    }

    public createDeck shuffleDeck(createDeck deck) {
        Collections.shuffle(this.deck.cardsStack);

        return deck;
    }

    public String dealCards(Cards dealer, Cards player) {
        dealer = deck.cardsStack.pop();
        player = deck.cardsStack.pop();

        System.out.println("\nThe dealer drew a " + dealer + "\n" + "You drew a " + player);
        return "The dealer drew a " + dealer + "\n" + "You drew a " + player;
    }

    public Integer valueOfACE(String choice) {
        if (choice.equals("1")) {
            ACEValue = 1;
        } else if (choice.equals("11")) {
            ACEValue = 11;
        } else {
            System.out.println("\nPlease choose 1 or 11.");
            valueOfACE(choice);
        }

        return ACEValue;
    }

    public Integer valueChecking(Cards dealer, Cards player, Integer ACEValue) {
        dealerRank = dealer.getRank();
        dealerValue = dealerRank.getFirstValue();
        playerRank = player.getRank();
        playerValue = playerRank.getFirstValue();
        Integer value = 0;

        if (dealerRank.equals(Rank.ACE)) {
            if ((totalDealerValue + 11) < 17) {
                dealerValue = Rank.ACE.getFirstValue();
                value = dealerValue;
            } else if ((totalDealerValue + 11) <= 21) {
                dealerValue = Rank.ACE.getSecondValue();
                value = dealerValue;
            }
        }

        if (playerRank.equals(Rank.ACE)) {
            if (ACEValue == 1) {
                playerValue = Rank.ACE.getFirstValue();
                value = playerValue;
            } else if (ACEValue == 11) {
                playerValue = Rank.ACE.getSecondValue();
                value = playerValue;
            }
        }

        if (dealerRank.equals(Rank.JACK) || dealerRank.equals(Rank.QUEEN) || dealerRank.equals(Rank.KING)) {
            dealerValue = Rank.TEN.getFirstValue();
            value = dealerValue;
        }

        if (playerRank.equals(Rank.JACK) || playerRank.equals(Rank.QUEEN) || playerRank.equals(Rank.KING)) {
            playerValue = Rank.TEN.getFirstValue();
            value = playerValue;
        }

        return value;
    }

    public String userAction(String choice, Cards player, Cards dealer, createDeck deck, Integer ACEValue, Double wager) {
        switch (choice.toLowerCase()) {
            case "hit":
                player = deck.cardsStack.pop();
                valueChecking(dealer, player, ACEValue);
                System.out.println("\nYou drew a " + player + ".");
                return "You said hit.";
            case "stand":
                return "You said stand.";
            case "double down":
                wager = (wager * 2);
                System.out.println("\nYour new wager is " + wager + ".");
                return "You said double down.";
            default:
                System.out.println("\nPlease choose a valid option.");
                userAction(choice, player, dealer, deck, ACEValue, wager);
        }

        return choice;
    }

    public String dealerAction(Integer totalDealerValue) {
        String action = "";

        if (totalDealerValue <= 16) {
            dealer = deck.cardsStack.pop();
            valueChecking(dealer, player, ACEValue);
            System.out.println("\nThe dealer drew a " + dealer + ".");
            action = "The dealer drew a " + dealer + ".";
        } else {
            System.out.println("\nThe dealer has a " + dealer + ".");
            action = "The dealer has a " + dealer + ".";
        }

        return action;
    }

    public String checkWinner(Integer totalDealerValue, Integer totalPlayerValue, Double balance, Double wager) {
        String winner = "";
        totalDealerValue += dealerValue;
        totalPlayerValue += playerValue;

        if (totalDealerValue > 21 || (totalDealerValue >= 17 && totalPlayerValue > totalDealerValue)) {
            totalDealerValue = 0;
            totalPlayerValue = 0;
            blackJackPlayer.getArcadeAccount().setBalance(balance += wager);

            System.out.println("\nYou are the winner!");
            System.out.println("\nYour new balance is " + balance + ".\n");
            winner = "You are the winner!";
        } else if (totalPlayerValue > 21) {
            totalDealerValue = 0;
            totalPlayerValue = 0;
            blackJackPlayer.getArcadeAccount().setBalance(balance -= wager);

            System.out.println("\nThe dealer won this game.");
            System.out.println("\nYour new balance is " + balance + ".\n");
            winner = "The dealer won this game.";
        } else {
            System.out.println("\nThe total value of your cards is: " + totalPlayerValue);
            System.out.println("The total value of the dealer's cards is: " + totalDealerValue);
            choice = input.getStringInput("\nWhat do you want to do?\n" +
                    "[HIT], [STAND], [DOUBLE DOWN]");
            userAction(choice, player, dealer, deck, ACEValue, wager);
            dealerAction(totalDealerValue);
            checkWinner(totalDealerValue, totalPlayerValue, balance, wager);
        }

        return winner;
    }

    public boolean continuePlaying(String choice) {
        boolean answer = false;

        if (choice.equalsIgnoreCase("yes")) {
            answer = true;
        } else if (choice.equalsIgnoreCase("no")) {
            answer = false;
            System.out.println("\nThank you for playing.\n");
        } else {
            System.out.println("\nPlease say yes or no.");
            continuePlaying(choice);
        }

        return answer;
    }

    @Override
    public void add(PlayerInterface player) {
        this.blackJackPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.blackJackPlayer = player;
    }

    @Override
    public void run() {
        BlackJack blackJack = new BlackJack(blackJackPlayer.getArcadeAccount());

        System.out.println("   ___     _       ___     ___    _  __       _    ___     ___    _  __  \n" +
                "  | _ )   | |     /   \\   / __|  | |/ /    _ | |  /   \\   / __|  | |/ /  \n" +
                "  | _ \\   | |__   | - |  | (__   | ' <    | || |  | - |  | (__   | ' <   \n" +
                "  |___/   |____|  |_|_|   \\___|  |_|\\_\\   _\\__/   |_|_|   \\___|  |_|\\_\\  \n" +
                "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| \n" +
                "\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' ");

        blackJack.rules();

        do {
            wager = input.getDoubleInput("How much would you like to wager: ");
            blackJack.shuffleDeck(deck = new createDeck());
            blackJack.dealCards(dealer, player);
            choice = input.getStringInput("\nIs the value of your ACE a 1 or an 11: ");
            blackJack.valueOfACE(choice);
            blackJack.valueChecking(dealer, player, ACEValue);
            blackJack.checkWinner(totalDealerValue, totalPlayerValue, balance, wager);
            choice = input.getStringInput("\nDo you want to play again: (Yes or No)");
        } while (blackJack.continuePlaying(choice));
    }
}

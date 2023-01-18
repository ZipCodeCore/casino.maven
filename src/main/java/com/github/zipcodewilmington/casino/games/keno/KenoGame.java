package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RandomNumberGenerator;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashSet;
import java.util.Set;

public class KenoGame extends RandomNumberGenerator implements GameInterface {

    IOConsole console = new IOConsole(AnsiColor.CYAN);
    Set<KenoPlayer> players = new HashSet<>();
    Set<Integer> randomNumbers = generateRandomNumbers();
    Integer playerNumber = 1;

    public KenoGame() {
        super(1,80, 20);
    }

    @Override
    public void add(PlayerInterface player) {
        players.add((KenoPlayer) player);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
    }

    @Override
    public void run() {
        Integer count = 1;
        for (KenoPlayer kenoPlayer : players) {
            kenoPlayer.play();
        }
        for (KenoPlayer kenoPlayer : players) {
            console.println("Congratulations Player #%s!  %s", count, kenoPlayer.chosenNumbers);
            kenoPlayer.outcomeOfGame(kenoPlayer.amountToBet);
            kenoPlayer.casinoAccount.addToBalance(kenoPlayer.prizeMoney);
            count++;
        }
        console.println("Keno Board: %s", randomNumbers);
    }

    public KenoPlayer getPlayer(String playerUsername) {
        for (KenoPlayer player : players) {
            if (player.getArcadeAccount().getUsername().equals(playerUsername)) {
                return player;
            }
        }
        return null;
    }

    public Set<KenoPlayer> getPlayers() {
        return players;
    }

    public Set<Integer> getChosenNumbers() {
        Integer count = 1;
        Set<Integer> chosenNumbers = new HashSet<>();
        console.println("Input 10 numbers between 1 and 80");
        while (chosenNumbers.size() < 10) {
            Integer numberInput = console.getIntegerInput("Player #%s numbers: %s\nInput number #%s",playerNumber, chosenNumbers, count);
            if (chosenNumbers.contains(numberInput)) {
                console.println("Number has already been chosen");
            }
            else if (numberInput < 1 || numberInput > 80) {
                console.println("That is not a valid number to chose");
            }
            else {
                chosenNumbers.add(numberInput);
                count++;
            }
        }
        playerNumber++;
        return chosenNumbers;
    }

    public Integer getBet() {
        return console.getIntegerInput("How much do you want to bet?");
    }
}

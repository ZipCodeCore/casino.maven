package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Arrays;
import java.util.List;

public class RouletteGame implements GameInterface {
    int ball;
    Integer[] red;
    Integer[] black;
    int money;
    int bet;
    int input;
    private PlayerInterface player;

    public RouletteGame() {
        ball = (int) (Math.random() * 36 + 1);
        red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
    }
    public int choosingABet() {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        console.println("Welcome to The Roulette Table!");
        console.println("Make your bets below <3");
        this.input = console.getIntegerInput("1.(Red) 2.(Black) 3.(Odds) 4.(Evens) 5.(Specific Number)");
    return input;
    }
    public int theRouletteGame(int input) {
        IOConsole console = new IOConsole(AnsiColor.AUTO);
        if (input == 1) {
            List<Integer> redNum = Arrays.asList(red);
            if (input == 1) {
                for (Integer num : redNum) {
                    if (ball == num) {
                        money = bet * 2;
                    }
                    money = bet - bet;
                }
            }

        } else if (input == 2) {
            List<Integer> blackNum = Arrays.asList(black);
            if (input == 2) {
                for (Integer num : blackNum) {
                    if (ball == num) {
                        money = bet + bet;
                    }
                    money = bet - bet;
                }
            }
        } else if (input == 3) {
            if (ball % 2 == 0) {
                money = bet - bet;
            }
            money = bet + bet;
        } else if (input == 4) {
            if (ball % 2 == 0) {
                money = bet + bet;
            }
            money = bet - bet;
        } else if (input == 5) {
            int num = 0;
            num = console.getIntegerInput("Pick a number between 1-36 that you would like to bet on!");
            if (ball == num) {
                money = bet + bet * 2;
            }
            money = bet - bet;

        }return money;
    }



        @Override
        public void add (PlayerInterface player){
            this.player = player;

        }

        @Override
        public void remove (PlayerInterface player){
            this.player = null;
        }

        @Override
        public void run () {
RouletteGame game = new RouletteGame();
int input=game.choosingABet();
int money=game.theRouletteGame(input);

        }
    }


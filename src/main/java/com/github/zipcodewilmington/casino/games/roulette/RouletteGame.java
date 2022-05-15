package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class RouletteGame implements GameInterface {
    private List<PlayerInterface> players = new ArrayList<>();
    private Integer[] red;
    private Integer[] black;
    private Integer choice;
    private Double betAmount;
    private String response;
    private Integer rouletteNumber;
    private PlayerInterface roulettePlayer;
    private Double balance;
    private String AnsiGreen = "\u001B[32m";
    private String AnsiReset = "\u001B[0m";
    private String AnsiRed = "\u001B[31m";
    private String welcomeMessage = "\n" +
            "░█──░█ ░█▀▀▀ ░█─── ░█▀▀█ ░█▀▀▀█ ░█▀▄▀█ ░█▀▀▀ 　 ▀▀█▀▀ ░█▀▀▀█ 　 ░█▀▀█ ░█▀▀▀█ ░█─░█ ░█─── ░█▀▀▀ ▀▀█▀▀ ▀▀█▀▀ ░█▀▀▀ █ █ █ \n" +
            "░█░█░█ ░█▀▀▀ ░█─── ░█─── ░█──░█ ░█░█░█ ░█▀▀▀ 　 ─░█── ░█──░█ 　 ░█▄▄▀ ░█──░█ ░█─░█ ░█─── ░█▀▀▀ ─░█── ─░█── ░█▀▀▀ ▀ ▀ ▀ \n" +
            "░█▄▀▄█ ░█▄▄▄ ░█▄▄█ ░█▄▄█ ░█▄▄▄█ ░█──░█ ░█▄▄▄ 　 ─░█── ░█▄▄▄█ 　 ░█─░█ ░█▄▄▄█ ─▀▄▄▀ ░█▄▄█ ░█▄▄▄ ─░█── ─░█── ░█▄▄▄ ▄ ▄ ▄";
    private String outOfMoneyMessage = "\n" +
            "█░░█ █▀▀█ █░░█ 　 █▀▀█ █▀▀█ █▀▀ 　 █▀▀▄ █▀▀█ █▀▀█ █░█ █▀▀ █ █ █ 　 　 　 　 　 　 　 　 　 \n" +
            "█▄▄█ █░░█ █░░█ 　 █▄▄█ █▄▄▀ █▀▀ 　 █▀▀▄ █▄▄▀ █░░█ █▀▄ █▀▀ ▀ ▀ ▀ 　 　 　 　 　 　 　 　 　 \n" +
            "▄▄▄█ ▀▀▀▀ ░▀▀▀ 　 ▀░░▀ ▀░▀▀ ▀▀▀ 　 ▀▀▀░ ▀░▀▀ ▀▀▀▀ ▀░▀ ▀▀▀ ▄ ▄ ▄ 　 　 　 　 　 　 　 　 　 \n" +
            "\n" +
            "█▀▀▀ █▀▀ ▀▀█▀▀ 　 █▀▀█ █░░█ ▀▀█▀▀ 　 █▀▀█ █▀▀ 　 █▀▄▀█ █░░█ 　 █▀▀ █▀▀█ █▀▀ ░▀░ █▀▀▄ █▀▀█ █ █ █ \n" +
            "█░▀█ █▀▀ ░░█░░ 　 █░░█ █░░█ ░░█░░ 　 █░░█ █▀▀ 　 █░▀░█ █▄▄█ 　 █░░ █▄▄█ ▀▀█ ▀█▀ █░░█ █░░█ ▀ ▀ ▀ \n" +
            "▀▀▀▀ ▀▀▀ ░░▀░░ 　 ▀▀▀▀ ░▀▀▀ ░░▀░░ 　 ▀▀▀▀ ▀░░ 　 ▀░░░▀ ▄▄▄█ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░░▀ ▀▀▀▀ ▄ ▄ ▄";


    private final IOConsole consolePurple = new IOConsole(AnsiColor.PURPLE);
    private final IOConsole consoleRed = new IOConsole(AnsiColor.RED);

    public RouletteGame(CasinoAccount casinoAccount) {
        roulettePlayer = new RoulettePlayer(casinoAccount);
        this.rouletteNumber = null;
        this.red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        this.black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        balance = roulettePlayer.getArcadeAccount().getBalance();
    }


    public String evenChoice(Integer randomNumber, Double betAmount) {
        consolePurple.println("Roulette Number: " + randomNumber);
        String result = "";

        if (randomNumber % 2 == 0) {
            roulettePlayer.getArcadeAccount().setBalance(balance += betAmount * 2);
            result = (AnsiGreen + "you won $" + betAmount * 2 + AnsiReset);

        } else {
            roulettePlayer.getArcadeAccount().setBalance(balance -= betAmount);
            result = (AnsiRed + "you lost $" + (betAmount) + AnsiReset);
        }
        return (result + "\nYour balance is: $" + getBalance());
    }


    public String oddChoice(Integer randomNumber, Double betAmount) {
        consolePurple.println("Roulette Number: " + randomNumber);
        String result = "";

        if (randomNumber % 2 == 1) {
            roulettePlayer.getArcadeAccount().setBalance(balance += betAmount * 2);
            result = (AnsiGreen + "you won $" + betAmount * 2 + AnsiReset);

        } else {
            roulettePlayer.getArcadeAccount().setBalance(balance -= betAmount);
            result = (AnsiRed + "you lost $" + (betAmount) + AnsiReset);
        }

        return (result + "\nYour balance is: $" + balance);
    }


    public String redChoice(Integer randomNumber, Double betAmount) {
        consolePurple.println("Roulette Number: " + randomNumber);
        String result = "";

        if (Arrays.asList(this.red).contains(randomNumber)) {
            roulettePlayer.getArcadeAccount().setBalance(balance += betAmount * 2);
            result = (AnsiGreen + "you won $" + betAmount * 2 + AnsiReset);
        } else {
            roulettePlayer.getArcadeAccount().setBalance(balance -= betAmount);
            result = (AnsiRed + "you lost $" + (betAmount) + AnsiReset);
        }

        return (result + "\nYour balance is: $" + balance);
    }

    public String blackChoice(Integer randomNumber, Double betAmount) {
        //  this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        String result = "";
        consolePurple.println("Roulette Number: " + randomNumber);

        if (Arrays.asList(this.black).contains(randomNumber)) {
            roulettePlayer.getArcadeAccount().setBalance(balance += betAmount * 2);
            result = (AnsiGreen + "you won $" + betAmount * 2 + AnsiReset);

        } else {
            roulettePlayer.getArcadeAccount().setBalance(balance -= betAmount);
            result = (AnsiRed + "you lost $" + (betAmount) + AnsiReset);

        }

        return (result + "\nYour balance is: $" + balance);
    }

    public String pickNumberChoice(Integer randomNumber, Double betAmount, Integer pickedNumber) {
        String result = "";
        Integer number = pickedNumber;

        if (randomNumber == number) {
            roulettePlayer.getArcadeAccount().setBalance(balance += betAmount * 35);
            result = (AnsiGreen + "you won $" + betAmount * 35 + AnsiReset);

        } else {
            roulettePlayer.getArcadeAccount().setBalance(balance -= betAmount);
            result = (AnsiRed + "you lost $" + (betAmount) + AnsiReset);

        }

        return (result + "\nYour balance is: $" + balance);
    }

    public String betweenOneAndEighteen(Integer randomNumber, Double betAmount) {
        //   this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        String result = "";
        consolePurple.println("Roulette Number: " + randomNumber);
        if (randomNumber >= 1 && randomNumber <= 18) {
            roulettePlayer.getArcadeAccount().setBalance(balance += betAmount * 2);
            result = (AnsiGreen + "you won $" + betAmount * 2 + AnsiReset);

        } else {
            roulettePlayer.getArcadeAccount().setBalance(balance -= betAmount);
            result = (AnsiRed + "you lost $" + (betAmount) + AnsiReset);
        }


        return (result + "\nYour balance is: $" + balance);
    }

    public String betweenNineteenAndThirtySix(Integer randomNumber, Double betAmount) {
        //  this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        String result = "";
        consolePurple.println("Roulette Number: " + randomNumber);

        if (randomNumber >= 19 && randomNumber <= 36) {
            roulettePlayer.getArcadeAccount().setBalance(balance += betAmount * 2);
            result = (AnsiGreen + "you won $" + betAmount * 2 + AnsiReset);

        } else {
            roulettePlayer.getArcadeAccount().setBalance(balance -= betAmount);
            result = (AnsiRed + "you lost $" + (betAmount) + AnsiReset);
        }

        return (result + "\nYour balance is: $" + balance);
    }


    public void rouletteGame() { // GAME ENGINE

        consolePurple.println(welcomeMessage);

        do {

            this.betAmount = consolePurple.getDoubleInput("Please enter amount you would like to bet");
            if (this.betAmount > this.balance) {
                consoleRed.println(outOfMoneyMessage);
                break;
            }
            consolePurple.println("PLease choose from the options below");
            choice = consolePurple.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6)Low 1 to 18  (7)High 19 to 36");

            while (choice < 0 || choice > 7) {
                consolePurple.println("PLease choose from the options below");
                choice = consolePurple.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6)Low 1 to 18  (7)High 19 to 36");
            }

            if (choice == 1) {
                this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
                consolePurple.println(redChoice(this.rouletteNumber, this.betAmount));

            } else if (choice == 2) {
                this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
                consolePurple.println(blackChoice(this.rouletteNumber, this.betAmount));

            } else if (choice == 3) {
                this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
                consolePurple.println(evenChoice(this.rouletteNumber, this.betAmount));

            } else if (choice == 4) {
                this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
                consolePurple.println(oddChoice(this.rouletteNumber, this.betAmount));

            } else if (choice == 5) {
                this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
                //System.out.println(rouletteNumber); //to test if number matches
                consolePurple.println(pickNumberChoice(this.rouletteNumber, this.betAmount, consolePurple.getIntegerInput("Place your bet on number(1-36): ")));

            } else if (choice == 6) {
                this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
                consolePurple.println(betweenOneAndEighteen(this.rouletteNumber, this.betAmount));

            } else if (choice == 7) {
                this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
                consolePurple.println(betweenNineteenAndThirtySix(this.rouletteNumber, this.betAmount));
            }


            response = consolePurple.getStringInput("Would you like to play another game? (Y/N) ");
            if (response.equals("N") || response.equals("n") || response.equals("NO") || response.equals("no")) {
                break;
            }

        } while (true);

        consolePurple.println("THANK YOU!!!");

    }


    public Double getBalance() {
        return balance;
    }


    @Override
    public void add(PlayerInterface player) {
        this.roulettePlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.roulettePlayer = null;
    }

    @Override
    public void run() {

        RouletteGame rouletteGame = new RouletteGame(roulettePlayer.getArcadeAccount());

        rouletteGame.rouletteGame();
    }
}

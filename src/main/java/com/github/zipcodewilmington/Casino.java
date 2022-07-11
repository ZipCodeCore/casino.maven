package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.keno.KenoGameRE;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.plinko.REPlinko;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.CSVUtils;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.IOException;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private CasinoAccount casinoAccount;
    private PlayerInterface player;
    @Override
    public void run() {
        Integer arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if (arcadeDashBoardInput.equals(2)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    Integer gameSelectionInput = getGameSelectionInput();
                    processGameSelection(gameSelectionInput);
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    //throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if (arcadeDashBoardInput.equals(1)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
                this.casinoAccount = newAccount;
                casinoAccount.alterAccountBalance(500);
                this.player = new Player(accountName, casinoAccount);
                this.player.setArcadeAccount(casinoAccount);
            } else if(arcadeDashBoardInput.equals(4)){
                try {
                    CSVUtils.csvFileSaver(this.player.getArcadeAccount());
                } catch (IOException e) {
                    e.printStackTrace();
                    console.println("Save unsuccessful, refer to error message above for more information");
                }
            } else if(arcadeDashBoardInput.equals(3)){
                this.casinoAccount = CSVUtils.loadData();
                this.player = new Player(this.casinoAccount.getAccountName(), this.casinoAccount);
                casinoAccountManager.registerAccount(this.casinoAccount);
            } else if(arcadeDashBoardInput.equals(5)){
                console.print(this.casinoAccount.getScoreboard().printAllScores());
            }

        } while (!arcadeDashBoardInput.equals(6));
    }

    private Integer getArcadeDashboardInput() {
        return console.getIntegerInput("Welcome to the Arcade Dashboard!\n" +
                "From here, you can select any of the following options:\n" +
                "\t[ 1. create-account ] [ 2. select-game ] [ 3. load-saved-account ] [ 4. save-account ] [ 5.scoreboard ] [ 6. logout ]");
    }

    private Integer getGameSelectionInput() {
        return console.getIntegerInput("Welcome to the Game Selection Dashboard!\n" +
                "From here, you can select any of the following options:\n" +
                "[ 1.SLOTS ] [ 2.NUMBERGUESS ] [ 3.PLINKO ] [ 4.BEETLE ] [ 5.BLACKJACK ] [ 6.KENO ]");
    }

    private void processGameSelection(Integer input){
        //input = input.toLowerCase(Locale.ROOT);
        GameInterface gameObject;
        switch(input){
            case 4:
                gameObject = new BeetleGame();
                break;
            case 1:
                gameObject = new SlotsGame();
                break;
            case 5:
                gameObject = new BlackJackGame();
                break;
            case 2:
                gameObject = new NumberGuessGame();
                break;
            case 3:
                gameObject = new REPlinko();
                break;
            case 6:
                gameObject = new KenoGameRE();
                break;
            default:
                gameObject = new BeetleGame();
        }

        play(gameObject, player);
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }


}

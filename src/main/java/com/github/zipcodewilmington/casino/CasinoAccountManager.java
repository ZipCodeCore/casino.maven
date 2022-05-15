package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    IOConsole console = new IOConsole();

    private List<CasinoAccount> accountList = new ArrayList<>();
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        for (CasinoAccount account: accountList) {
            String username = account.getUsername();
            String password = account.getPassword();
            if(username.equals(accountName)){
                if(password.equals(accountPassword)){
                    return  account;
                }
            }
        }
        console.println("Sorry your account doesn't exist");
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword , Double accountBalance) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));

        CasinoAccount createAcct = new CasinoAccount(accountName, accountPassword, accountBalance);

        return createAcct;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        this.accountList.add(casinoAccount);


    }
}

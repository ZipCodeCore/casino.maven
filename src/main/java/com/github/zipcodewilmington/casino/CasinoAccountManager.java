package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    private List<CasinoAccount> accountList = new ArrayList<CasinoAccount>();
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        for(int i = 0; i < accountList.size(); i++){
            CasinoAccount currentAccount = accountList.get(i);
            String pass = currentAccount.getPassword();
            String name = currentAccount.getAccountName();
            if(name.equals(accountName))
               if(pass.equals(accountPassword)){
                   return currentAccount;
            }
        }
        System.out.println("Account Name or Password does not match. Are you really you?");
        return null;
    }


    public CasinoAccount createAccount(String accountName, String accountPassword) {
        CasinoAccount myAccount = new CasinoAccount(accountName, accountPassword);
        return myAccount;
    }


    public void registerAccount(CasinoAccount casinoAccount) {
        this.accountList.add(casinoAccount);
    }
}

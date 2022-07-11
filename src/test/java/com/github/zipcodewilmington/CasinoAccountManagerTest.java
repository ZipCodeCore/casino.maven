package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountManagerTest {

    @Test
    public void createAccountTest(){
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("zz", "ss");

        Assert.assertNotNull(account);
    }

    @Test
    public void registerAndGetAccountTest(){
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("zz", "ss");
        cam.registerAccount(account);

        CasinoAccount actual = cam.getAccount("zz", "ss");
        Assert.assertNotNull(actual);
    }

    @Test
    public void getAccountTest(){
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("zz", "ss");
        cam.registerAccount(account);

        CasinoAccount actual = cam.getAccount("z2", "ss");
        Assert.assertNull(actual);
    }
}

package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.CSVUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class CSVUtilsTest {

    @Test
    public void csvSaveTest(){
        Boolean actual = true;
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        //PlayerInterface player = new Player("Bjork", account);
        account.alterAccountBalance(400);
        try {
            CSVUtils.csvFileSaver(account);
        } catch (IOException e) {
            actual = false;
        }

        Assert.assertTrue(actual);
    }

    @Test
    public void csvLoadTest(){
        CasinoAccount actual = CSVUtils.loadData();

        Assert.assertNotNull(actual);
    }
}


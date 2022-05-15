package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

public class CasinoManageTest {
    @Test

    public void casinoManagerCreateAccountTest(){
        //Given
       CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
       //When
       CasinoAccount actualAccount = casinoAccountManager.createAccount("Junior", "j", 1500.0);
     //Then
      Assert.assertNotNull(actualAccount);

    }


    @Test
    public void casinoManagerRegisterAccount(){
       //given
       CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
       CasinoAccount casinoAccount = casinoAccountManager.createAccount("Junior", "j", 1500.0);
        String expectedUser = "Junior";
        String expectedPassword = "j";
       //when
        casinoAccountManager.registerAccount(casinoAccount);
        CasinoAccount actual = casinoAccountManager.getAccount(expectedUser, expectedPassword);

       //then
        Assert.assertNotNull(actual);

    }
@Test

    public void casinoManagerGetAccountTest(){
      //given
    CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
    CasinoAccount casinoAccount = casinoAccountManager.createAccount("Junior", "j", 1500.0);
    casinoAccountManager.registerAccount(casinoAccount);
    String expectedUser = "Junior";
    String expectedPassword = "j";
    //when
    CasinoAccount actual = casinoAccountManager.getAccount(expectedUser, expectedPassword);
    //then
        Assert.assertNotNull(actual);

}


}

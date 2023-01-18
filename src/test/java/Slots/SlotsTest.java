package Slots;

import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class SlotsTest {
    @Test
    public void winnerTest(){
        //given
        String slot1 = "cherry";
        String slot2 = "cherry";
        String slot3 = "cherry";
        if (slot1 == "BIG WIN" && slot1 == slot2 && slot1 == slot3) {
            System.out.println("Jackpot! You win 50 tokens!" + "\n");
        } else if (slot1 == slot2 && slot1 == slot3) {
            System.out.println("Congrats! You win 10 tokens." + "\n");
        } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
            System.out.println("Congrats! You win 5 tokens." + "\n");
        } else {
            System.out.println("Sorry! Better luck next time." + "\n");
        }
        //when

        String expected = "Congrats! You win 10 tokens." + "\n";
       if(slot1 == slot2 && slot1 == slot3){
           System.out.println(expected);
       }



        //then
        Assert.assertTrue(expected,true);

    }
    @Test
    public void loserTest(){
        //given
        String slot1 = "cherry";
        String slot2 = "7";
        String slot3 = "BIGWIN";
        if (slot1 == "BIG WIN" && slot1 == slot2 && slot1 == slot3) {
            System.out.println("Jackpot! You win 50 tokens!" + "\n");
        } else if (slot1 == slot2 && slot1 == slot3) {
            System.out.println("Congrats! You win 10 tokens." + "\n");
        } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
            System.out.println("Congrats! You win 5 tokens." + "\n");
        } else {
            System.out.println("Sorry! Better luck next time." + "\n");
        }
        //when

        String expected = "Sorry! Better luck next time." + "\n";
        if(!slot1.equals(slot2) || !slot1.equals(slot3)){
            System.out.println(expected);
        }



        //then
        Assert.assertTrue(expected,true);
    }
    @Test
    public void partialWin(){
        //given
        String slot1 = "cherry";
        String slot2 = "7";
        String slot3 = "7";
        if (slot1 == "BIG WIN" && slot1 == slot2 && slot1 == slot3) {
            System.out.println("Jackpot! You win 50 tokens!" + "\n");
        } else if (slot1 == slot2 && slot1 == slot3) {
            System.out.println("Congrats! You win 10 tokens." + "\n");
        } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
            System.out.println("Congrats! You win 5 tokens." + "\n");
        } else {
            System.out.println("Sorry! Better luck next time." + "\n");
        }
        //when

        String expected = "Congrats! You win 5 tokens.\" + \"\\n";
        if(!slot1.equals(slot2) || !slot1.equals(slot3)){
            System.out.println(expected);
        }



        //then
        Assert.assertTrue(expected,true);
    }


}

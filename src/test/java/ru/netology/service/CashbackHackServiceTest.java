package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {

    @org.testng.annotations.Test
    public void testRemain() {
        CashbackHackService service = new CashbackHackService();

        int amount = 700;
        int actual  = service.remain(amount);
        int expected = 300;
        Assert.assertEquals(actual,expected);
    }
}
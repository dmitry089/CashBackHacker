package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {
    CashbackHackService service = new CashbackHackService();

    @org.testng.annotations.Test
    public void shouldAddTheAmount() {
        int amount = 600;
        int actual = service.remain(amount);
        int expected = 400;
        Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void mustEqualsZero() {
        int amount = 0;
        int actual = service.remain(amount);
        int expected = 1000;
        Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void mustEqualsOne() {
        int amount = 1;
        int actual = service.remain(amount);
        int expected = 999;
        Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void notEnoughToLimit() {
        int amount = 1400;
        int actual = service.remain(amount);
        int expected = 600;
        Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void moreThanOneLimit() {
        int amount = 1001;
        int actual = service.remain(amount);
        int expected = 999;
        Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void lessThanZeroByOne() {
        assertThrows(RuntimeException.class, () -> {

            service.remain(-1);
        });
    }
    @org.testng.annotations.Test
    public void amountEqualToTheBonus() {
        int amount = 1000;
        int actual = service.remain(amount);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }
}
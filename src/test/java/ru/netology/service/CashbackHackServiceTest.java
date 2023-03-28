package ru.netology.service;

import org.junit.Assert;

import static org.junit.Assert.*;

public class CashbackHackServiceTest {
    CashbackHackService service = new CashbackHackService();

    @org.junit.Test
    public void shouldAddTheAmount() {
        int amount = 600;
        int actual = service.remain(amount);
        int expected = 400;
        org.junit.Assert.assertEquals(actual, expected);
    }

    @org.junit.Test
    public void mustEqualsZero() {
        int amount = 0;
        int actual = service.remain(amount);
        int expected = 1000;
        org.junit.Assert.assertEquals(actual, expected);
    }

    @org.junit.Test
    public void mustEqualsOne() {
        int amount = 1;
        int actual = service.remain(amount);
        int expected = 999;
        org.junit.Assert.assertEquals(actual, expected);
    }

    @org.junit.Test
    public void notEnoughToLimit() {
        int amount = 1400;
        int actual = service.remain(amount);
        int expected = 600;
        org.junit.Assert.assertEquals(actual, expected);
    }

    @org.junit.Test
    public void moreThanOneLimit() {
        int amount = 1001;
        int actual = service.remain(amount);
        int expected = 999;
        org.junit.Assert.assertEquals(actual, expected);
    }

    @org.junit.Test
    public void lessThanZeroByOne() {
        org.junit.Assert.assertThrows(RuntimeException.class, () -> {

            service.remain(-1);
        });
    }
    @org.junit.Test
    public void amountEqualToTheBonus() {
        int amount = 1000;
        int actual = service.remain(amount);
        int expected = 0;
        org.junit.Assert.assertEquals(actual, expected);
    }
}
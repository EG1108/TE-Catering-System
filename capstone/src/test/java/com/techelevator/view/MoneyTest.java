package com.techelevator.view;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void dispenseChange() throws FileNotFoundException {
        Money money = new Money();
        BigDecimal amount = new BigDecimal("20.60");
        money.addMoney(amount);
        BigDecimal expectedResult = BigDecimal.valueOf(0.00);
        BigDecimal actualResult = money.changeReturned();
        assertEquals(expectedResult, actualResult);


    }

}

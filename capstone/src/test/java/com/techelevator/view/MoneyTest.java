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
        BigDecimal expectedResult = BigDecimal.valueOf(0.00).setScale(2);
        BigDecimal actualResult = money.changeReturned();
        assertEquals(expectedResult, actualResult);


    }

    @Test
    public void subtract() {
        Money money = new Money();
        BigDecimal addAmount = new BigDecimal("20.55");
        BigDecimal subAmount = new BigDecimal("10.40");
        BigDecimal subAmountGreater = new BigDecimal("45.30");
        money.addMoney(addAmount);
        BigDecimal expectedResult = BigDecimal.valueOf(10.15).setScale(2);
        BigDecimal actualResult = money.subtractMoney(subAmount);
        assertEquals(expectedResult, actualResult);

        BigDecimal expectedResult2 = money.getBalance();
        BigDecimal actualResult2 =  money.subtractMoney(subAmountGreater);
        assertEquals(expectedResult2, actualResult2);

    }

}

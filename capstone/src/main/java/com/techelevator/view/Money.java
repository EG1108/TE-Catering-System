package com.techelevator.view;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance;

    public Money(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }


}

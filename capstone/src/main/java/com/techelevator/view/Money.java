package com.techelevator.view;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private BigDecimal balance;

    public Money() {
        this.balance = BigDecimal.valueOf(0.0);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal addMoney (BigDecimal amountToAdd) {
        this.balance = balance.add(amountToAdd);
        return this.balance;
    }

    public BigDecimal subtractMoney(BigDecimal amountToSubtract) {
        if(this.balance.compareTo(amountToSubtract) >= 0) {
            this.balance = balance.subtract(amountToSubtract).setScale(2, RoundingMode.HALF_UP);
            return this.balance;
        } else {
            System.out.println("You don't have enough money!");
            return this.balance;
        }
    }

    public BigDecimal changeReturned() {
        BigDecimal nickel = new BigDecimal("0.05");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dollar = new BigDecimal("1.00");
        BigDecimal zero = new BigDecimal("0.00");
        int nickelCounter = 0;
        int dimeCounter = 0;
        int quarterCounter = 0;
        int dollarCounter = 0;
        while(balance.compareTo(zero) == 1) {
            if (balance.compareTo(dollar) == 1 || balance.compareTo(dollar) == 0) {
                balance = balance.subtract(dollar);
                dollarCounter++;
            } else if(balance.compareTo(quarter) == 1 || balance.compareTo(quarter) == 0) {
                balance = balance.subtract(quarter);
                quarterCounter++;
            } else if(balance.compareTo(dime) == 1 || balance.compareTo(dime) == 0) {
                balance = balance.subtract(dime);
                dimeCounter++;
            } else if(balance.compareTo(nickel) == 1 || balance.compareTo(nickel) == 0) {
                balance = balance.subtract(nickel);
                nickelCounter++;
            }
        }
        System.out.println("You got back " + dollarCounter + " dollars, " + quarterCounter + " quarters, " + dimeCounter + " dimes, and " + nickelCounter + " nickels!");
        this.balance = balance;
        return this.balance;
    }
    }



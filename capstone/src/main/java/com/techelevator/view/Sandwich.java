package com.techelevator.view;

import java.math.BigDecimal;

public class Sandwich extends Food{
    private int quantity;

    public Sandwich(String name, String consumables, BigDecimal price) {
        super(name, consumables, price);
        this.quantity = 7;
    }
    public void message() {
        System.out.println("Sandwich So Delicious, Yum!\n");
    }
}

package com.techelevator.view;

import java.math.BigDecimal;

public class Sandwich extends Food{
    private int quantity;

    public Sandwich(String name, String consumables, BigDecimal price, int quantity) {
        super(name, consumables, price);
        this.quantity = quantity;
    }
    public void message() {
        System.out.println("Sandwich So Delicious, Yum!");
    }
}

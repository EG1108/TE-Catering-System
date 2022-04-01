package com.techelevator.view;

import java.math.BigDecimal;

public class Munchy extends Food{
    private int quantity;

    public Munchy(String name, String consumables, BigDecimal price, int quantity) {
        super(name, consumables, price);
        this.quantity = quantity;
    }

    public void message() {
        System.out.println("Munchy, Munchy, so Good!");
    }
}

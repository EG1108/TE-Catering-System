package com.techelevator.view;

import java.math.BigDecimal;

public class Dessert extends Food{
    private int quantity;

    public Dessert(String name, String consumables, BigDecimal price) {
        super(name, consumables, price);
        this.quantity = quantity;
    }

    public void message() {
        System.out.println("Sugar, Sugar, so Sweet!");
    }
}

package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Food{
    private int quantity;

    public Drink(String name, String consumables, BigDecimal price) {
        super(name, consumables, price);
        this.quantity = 7;
    }
    public void message() {
        System.out.println("Drinky, Drinky, Slurp Slurp!\n");
    }

}

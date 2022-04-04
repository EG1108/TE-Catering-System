package com.techelevator.view;

import java.math.BigDecimal;

public class  Food {
    private String name;
    private String consumables;
    private BigDecimal price;
    private int quantity;

    public Food(String name, String consumables, BigDecimal price) {
        this.name = name;
        this.consumables = consumables;
        this.price = price;
        this.quantity = 7;
    }

    public Food(String name, String consumables, BigDecimal price, int quantity) {
        this.name = name;
        this.consumables = consumables;
        this.price = price;
        this.quantity = quantity;
    }

    public Food() {
        this.quantity = 7;
    }

    public String getName() {
        return name;
    }

    public String getConsumables() {
        return consumables;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", consumables='" + consumables + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

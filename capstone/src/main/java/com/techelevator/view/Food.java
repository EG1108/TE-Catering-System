package com.techelevator.view;

import java.math.BigDecimal;

public class  Food {
    private String name;
    private String consumables;
    private BigDecimal price;

    public Food(String name, String consumables, BigDecimal price) {
        this.name = name;
        this.consumables = consumables;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", consumables='" + consumables + '\'' +
                ", price=" + price +
                '}';
    }
}

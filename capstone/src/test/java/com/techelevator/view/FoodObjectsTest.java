package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FoodObjectsTest {
    @Test
    public void foodTest() {
        Food food = new Food("Calzone", "Sandwich", BigDecimal.valueOf(7.50));
        int expectedQty = 7;
        int actualQty = food.getQuantity();
        assertEquals(expectedQty, actualQty);

    }

    @Test
    public void sandwichTest() {
        Sandwich sandwich = new Sandwich("Tuna", "Sandwich", BigDecimal.valueOf(6.35));
        String expectedName = "Tuna";
        String actualName = sandwich.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void dessertTest() {
        Dessert dessert = new Dessert("Cake", "Dessert", BigDecimal.valueOf(15.75));
        String expectedConsumable = "Dessert";
        String actualConsumable = dessert.getConsumables();
        assertEquals(expectedConsumable, actualConsumable);

    }

    @Test
    public void munchyTest() {
        Munchy munchy = new Munchy("Chips", "Munchy", BigDecimal.valueOf(3.50));
        BigDecimal expectedPrice = BigDecimal.valueOf(3.50);
        BigDecimal actualPrice = munchy.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void drinkTest() {
        Drink drink = new Drink("Pepsi", "Drink", BigDecimal.valueOf(2.25));
        String expectedName = "Pepsi";
        String actualName = drink.getName();
        assertEquals(expectedName, actualName);
    }

}

package com.techelevator.view;

public class Drink extends Food{
    private String slotID;
    private String foodItem;

    public Drink(String name, double price, String foodItem, String slotID) {
        super(name, price);
        this.slotID = slotID;
        this.foodItem = foodItem;
    }

    public String getSlotID() {
        return slotID;
    }

//    public void setSlotID(String slotID) {
//        this.slotID = slotID;
//    }

    public String getFoodItem() {
        return foodItem;
    }

//    public void setFoodItem(String foodItem) {
//        this.foodItem = foodItem;
//    }
}

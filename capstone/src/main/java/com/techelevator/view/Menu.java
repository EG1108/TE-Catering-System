package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Menu {
    Money money = new Money();
    Map<String, Food> food = new HashMap<>();
    public void displayLevel1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(D) Display caTEring Items\n(P)Purchase\n(E)Exit");
        String choices = scanner.nextLine();

        File inputFile = new File("catering.csv");


        if (choices.equals("D")) {
            try {
                Scanner fileScanner = new Scanner(inputFile);
                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

    }

    public void displayLevel2() {
        BigDecimal balance = money.getBalance();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("(M) Feed Money \n(S)Select Item\n(F)Finish Transaction\n\n Current Money Provided: " + balance);
//        String choices = scanner.nextLine();
        boolean quit = false;

        File inputFile = new File("catering.csv");
        do {
            System.out.println("(M) Feed Money \n(S)Select Item\n(F)Finish Transaction\n\n Current Money Provided: " + money.getBalance());
            String choices = scanner.nextLine();
            if (choices.equals("M")) {
                System.out.println("Enter money in whole dollar amount: ");
                String amountDeposited = scanner.nextLine();
                BigDecimal dollarsEntered = new BigDecimal(amountDeposited);
                money.addMoney(dollarsEntered);
                System.out.println(money.getBalance());

            } else if (choices.equals("S")) {
                try {
                    Scanner fileScanner = new Scanner(inputFile);
                    int count = 0;

                    while (fileScanner.hasNext()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                        String[] dataArr = line.split("\\,");
                        String key = dataArr[0];
                        String name = dataArr[1];
                        String consumables = dataArr[2];
                        BigDecimal price = new BigDecimal(dataArr[3]);
                        Food currentFood = new Food(name, consumables, price);
                        food.put(key, currentFood);
                    }
                    System.out.println(food.get("D3"));

                    System.out.println("Enter slot identifier for wanted item: ");
                    String slotScanner = scanner.nextLine();
//                    for (int i = 0; i < food.size(); i++) {
                        if (food.containsKey(slotScanner)) {

                            if(food.get(slotScanner).getConsumables().equals("Drink")) {
                                Drink drink = new Drink(food.get(slotScanner).getName(), food.get(slotScanner).getConsumables(), food.get(slotScanner).getPrice());
                                if(money.getBalance().compareTo(drink.getPrice()) >= 0) {
                                    money.subtractMoney(drink.getPrice());
                                    drink.message();
                                    drink.setQuantity(drink.getQuantity() - 1);
                                    System.out.println(drink.getQuantity());
                                } else {
                                    money.subtractMoney(drink.getPrice());
                                }
//                                break;

                            } else if(food.get(slotScanner).getConsumables().equals("Sandwich")) {
                                Sandwich sandwich = new Sandwich(food.get(slotScanner).getName(), food.get(slotScanner).getConsumables(), food.get(slotScanner).getPrice());
                                if(money.getBalance().compareTo(sandwich.getPrice()) >= 0) {
                                    money.subtractMoney(sandwich.getPrice());
                                    sandwich.message();
                                } else {
                                    money.subtractMoney(sandwich.getPrice());
                                }
//                                break;

                            } else if(food.get(slotScanner).getConsumables().equals("Dessert")) {
                                Dessert dessert = new Dessert(food.get(slotScanner).getName(), food.get(slotScanner).getConsumables(), food.get(slotScanner).getPrice());
                                if(money.getBalance().compareTo(dessert.getPrice()) >= 0) {
                                    money.subtractMoney(dessert.getPrice());
                                    dessert.message();
                                } else {
                                    money.subtractMoney(dessert.getPrice());
                                }
//                                break;

                            } else if(food.get(slotScanner).getConsumables().equals("Munchy")) {
                                Munchy munchy = new Munchy(food.get(slotScanner).getName(), food.get(slotScanner).getConsumables(), food.get(slotScanner).getPrice());
                                if(money.getBalance().compareTo(munchy.getPrice()) >= 0) {
                                    money.subtractMoney(munchy.getPrice());
                                    munchy.message();
                                } else {
                                    money.subtractMoney(munchy.getPrice());
                                }
//                                break;
                            }

                        } else {
//                            System.out.println("This item is not in stock ");
                        }
//                    }
                    continue;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (choices.equals("F")) {
                money.changeReturned();
            }
        } while (!quit);

    }


    public static void main(String[] args) {

        Menu menu = new Menu();
//        menu.displayLevel1();
        menu.displayLevel2();

    }

}






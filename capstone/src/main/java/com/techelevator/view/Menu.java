package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Money money = new Money();
    Map<String, Food> food = new LinkedHashMap<>();
    boolean quit = false;
    Food myFood = new Food();


    public void displayListOfItems() {
        File inputFile = new File("catering.csv");
        try {
            Scanner fileScanner = new Scanner(inputFile);
            if (food.isEmpty()) {
                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
//                    System.out.println(line + ", x" + myFood.getQuantity());
                    String[] dataArr = line.split("\\,");
                    String key = dataArr[0];
                    String name = dataArr[1];
                    String consumables = dataArr[2];
                    BigDecimal price = new BigDecimal(dataArr[3]);
                    Food currentFood = new Food(name, consumables, price, 7);
                    food.put(key, currentFood);
                }
                for (Map.Entry<String, Food> entry : food.entrySet()) {
                    String values = entry.getValue().getName() + ", " + entry.getValue().getConsumables() + ", $" + entry.getValue().getPrice() + ", x" + entry.getValue().getQuantity();
                    System.out.println(entry.getKey() + ", " + values);
                }

            } else {
                for (Map.Entry<String, Food> entry : food.entrySet()) {
                    if (entry.getValue().getQuantity() <= 0) {
                        String values = entry.getValue().getName() + ", " + entry.getValue().getConsumables() + ", OUT OF STOCK!";
                        System.out.println(entry.getKey() + ", " + values);
                    } else {
                        String values = entry.getValue().getName() + ", " + entry.getValue().getConsumables() + ", $" + entry.getValue().getPrice() + ", x" + entry.getValue().getQuantity();
                        System.out.println(entry.getKey() + ", " + values);

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayLevel1() throws FileNotFoundException {
        System.out.println("(D)Display caTEring Items\n(P)Purchase\n(E)Exit");
        String choices = scanner.nextLine();

        while (!quit) {
            if (choices.equalsIgnoreCase("D")) {
                displayListOfItems();
                System.out.println();
                displayLevel1();

            } else if (choices.equalsIgnoreCase("P")) {
                displayLevel2();

            } else if (choices.equalsIgnoreCase("E")) {
                System.out.println("Thank you for shopping!");
                System.exit(1);
            } else {
                System.out.println("Please enter D, P, or E!");
                displayLevel1();
            }

        }
    }


    public void displayLevel2() throws FileNotFoundException {
        while (!quit) {
            System.out.println("(M)Feed Money \n(S)Select Item\n(F)Finish Transaction\n\nCurrent Money Provided: " + money.getBalance());
            String choices = scanner.nextLine();
            if (choices.equalsIgnoreCase("M")) {
                System.out.println("Enter money in whole dollar amount(1, 5, 10, 20): ");
                String amountDeposited = scanner.nextLine();
                if (amountDeposited.contains(".")) {
                    System.out.println("Please enter a whole number!");
                } else if (amountDeposited.equals("1") || amountDeposited.equals("5") || amountDeposited.equals("10") || amountDeposited.equals("20")) {
                    BigDecimal dollarsEntered = new BigDecimal(amountDeposited);
                    fileWriter("FEED MONEY", money.getBalance(), money.addMoney(dollarsEntered));
                    System.out.println(money.getBalance());
                } else {
                    try {
                        System.out.println("Please enter a 1, 5, 10, or 20\n");
                    } catch (NumberFormatException e) {
                        System.out.println("Not a number!\n");
                    }
                }

            } else if (choices.equalsIgnoreCase("S")) {
                displayListOfItems();
                System.out.println();
                System.out.println("Enter slot identifier for wanted item: ");
                String slotScanner = scanner.nextLine();
                slotScanner = slotScanner.toUpperCase();

                if (food.containsKey(slotScanner)) {
                    String name = food.get(slotScanner).getName();
                    String consumable = food.get(slotScanner).getConsumables();
                    BigDecimal price = food.get(slotScanner).getPrice();

                    if (food.get(slotScanner).getConsumables().equals("Drink")) {
                        Drink drink = new Drink(name, consumable, price);

                        if (money.getBalance().compareTo(drink.getPrice()) >= 0 && food.get(slotScanner).getQuantity() > 0) {
                            fileWriter(name + " " + slotScanner, money.getBalance(), money.subtractMoney(drink.getPrice()));
                            drink.message();

                            Food newFood = food.get(slotScanner);
                            newFood.setQuantity(newFood.getQuantity() - 1);

                        } else {
                            System.out.println("You don't have enough money.\n");
                        }

                    } else if (food.get(slotScanner).getConsumables().equals("Sandwich")) {

                        Sandwich sandwich = new Sandwich(name, consumable, price);
                        if (money.getBalance().compareTo(sandwich.getPrice()) >= 0 && food.get(slotScanner).getQuantity() > 0) {
                            fileWriter(name + " " + slotScanner, money.getBalance(), money.subtractMoney(sandwich.getPrice()));
                            sandwich.message();
                            Food newFood = food.get(slotScanner);
                            newFood.setQuantity(newFood.getQuantity() - 1);

                        } else {
                            System.out.println("You don't have enough money.\n");
                        }

                    } else if (food.get(slotScanner).getConsumables().equals("Dessert")) {
                        Dessert dessert = new Dessert(name, consumable, price);
                        if (food.get(slotScanner).getQuantity() <= 0) {
                            System.out.println("This item is out of stock!\n");
                        } else if (money.getBalance().compareTo(dessert.getPrice()) >= 0) {
                            fileWriter(name + " " + slotScanner, money.getBalance(), money.subtractMoney(dessert.getPrice()));
                            dessert.message();
                            Food newFood = food.get(slotScanner);

                            newFood.setQuantity(newFood.getQuantity() - 1);
                        } else {
                            System.out.println("You don't have enough money.\n");
                        }

                    } else if (food.get(slotScanner).getConsumables().equals("Munchy")) {
                        Munchy munchy = new Munchy(name, consumable, price);

                        if (money.getBalance().compareTo(munchy.getPrice()) >= 0 && food.get(slotScanner).getQuantity() > 0) {
                            fileWriter(name + " " + slotScanner, money.getBalance(), money.subtractMoney(munchy.getPrice()));
                            munchy.message();
                            Food newFood = food.get(slotScanner);
                            newFood.setQuantity(newFood.getQuantity() - 1);

                        } else {
                            System.out.println("You don't have enough money.\n");
                        }
                    }

                } else {
                    System.out.println("This is not a valid input!\n");
                }

            } else if (choices.equalsIgnoreCase("F")) {
                fileWriter("CHANGE RETURNED", money.getBalance(), money.changeReturned());
//                money.changeReturned();

                displayLevel1();
            } else {
                System.out.println("Please enter M, S, or F!\n");
            }
        }

    }

    public void fileWriter(String action, BigDecimal currentBalance, BigDecimal newBalance) throws FileNotFoundException {
        File auditFile = new File("audit.txt");
        PrintWriter writer = null;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String message = currentDateTime.format(targetFormat) + " " + action + " " + currentBalance + " " + newBalance + "\n";
// Instantiate the writer object with append functionality.
        if (auditFile.exists()) {
            writer = new PrintWriter(new FileOutputStream(auditFile.getAbsoluteFile(), true));
        }
// Instantiate the writer object without append functionality.
        else {
            writer = new PrintWriter(auditFile.getAbsoluteFile());
        }
        writer.append(message);
        writer.flush();
        writer.close();
    }


//        try (PrintWriter pw = new PrintWriter(auditFile.getAbsoluteFile())) {
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
//            pw.append(currentDateTime.format(targetFormat) + " " + action + " " + currentBalance + " " + newBalance);
//            pw.flush();
//        } catch (FileNotFoundException e) {
//            System.out.println("The file was not found!");
//        }
}

//    public static void main(String[] args) {
//
//        Menu menu = new Menu();
//        menu.displayLevel1();
////        menu.displayLevel2();
//    }










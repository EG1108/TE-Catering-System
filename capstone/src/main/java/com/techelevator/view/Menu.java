package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

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
        BigDecimal balance = new BigDecimal("0.35");
        Scanner scanner = new Scanner(System.in);
//        System.out.println("(M) Feed Money \n(S)Select Item\n(F)Finish Transaction\n\n Current Money Provided: " + balance);
//        String choices = scanner.nextLine();
        boolean quit = false;

        File inputFile = new File("catering.csv");
        do {
            System.out.println("(M) Feed Money \n(S)Select Item\n(F)Finish Transaction\n\n Current Money Provided: " + balance);
            String choices = scanner.nextLine();
            if (choices.equals("M")) {
                System.out.println("Enter money in whole dollar amount: ");
                String amountDeposited = scanner.nextLine();
                double dollarAmount = Double.parseDouble(amountDeposited);
                BigDecimal dollarsEntered = new BigDecimal(dollarAmount);
                balance = balance.add(dollarsEntered);
                System.out.println(balance);

            } else if (choices.equals("S")) {
                try {
                    Scanner fileScanner = new Scanner(inputFile);
                    List<String[]> slotItemList = new ArrayList<>();
                    int count = 0;


                    while (fileScanner.hasNext()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                        String[] dataArr = line.split("\\,");
                        slotItemList.add(dataArr);

                    }

                    System.out.println("Enter slot identifier for wanted item: ");
                    String slotScanner = scanner.nextLine();
                    for (int i = 0; i < slotItemList.size(); i++) {
                        if (slotItemList.get(i)[0].equals(slotScanner)) {
                            System.out.println("This item is in stock ");
                            double itemCost = Double.parseDouble(slotItemList.get(i)[3]);
                            BigDecimal itemPrice = new BigDecimal(itemCost);
                            BigDecimal itemDifference = balance .subtract(itemPrice);
                            if (balance.compareTo(itemPrice) == 1) {
                                System.out.println(slotItemList.get(i)[1] + " " + slotItemList.get(i)[3] + " Your remaining balance is " + itemDifference.setScale(2, RoundingMode.HALF_UP));
                            } else {
                                System.out.println("You don't have enough money.");
                            }
                            balance = itemDifference.setScale(2, RoundingMode.HALF_UP);
                        } else {
//                            System.out.println("This item is not in stock ");
                        }
//                        break;
                    }
                    continue;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (choices.equals("F")) {
                BigDecimal nickel = new BigDecimal("0.05");
                BigDecimal dime = new BigDecimal("0.10");
                BigDecimal quarter = new BigDecimal("0.25");
                BigDecimal dollar = new BigDecimal("1.00");
                BigDecimal zero = new BigDecimal("0.00");
                int nickelCounter = 0;
                int dimeCounter = 0;
                int quarterCounter = 0;
                int dollarCounter = 0;
                while(balance.compareTo(zero) == 1) {
                    if (balance.compareTo(dollar) == 1 || balance.compareTo(dollar) == 0) {
                        balance = balance.subtract(dollar);
                        dollarCounter++;
                    } else if(balance.compareTo(quarter) == 1 || balance.compareTo(quarter) == 0) {
                        balance = balance.subtract(quarter);
                        quarterCounter++;
                    } else if(balance.compareTo(dime) == 1 || balance.compareTo(dime) == 0) {
                        balance = balance.subtract(dime);
                        dimeCounter++;
                    } else if(balance.compareTo(nickel) == 1 || balance.compareTo(nickel) == 0) {
                        balance = balance.subtract(nickel);
                        nickelCounter++;
                    }
                }
                System.out.println("You got back " + dollarCounter + " dollars, " + quarterCounter + " quarters, " + dimeCounter + " dimes, and " + nickelCounter + " nickels!");
                displayLevel1();
            }
        } while (!quit);

    }


    public static void main(String[] args) {

        Menu menu = new Menu();
//        menu.displayLevel1();
        menu.displayLevel2();

    }

}






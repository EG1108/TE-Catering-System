package com.techelevator.view;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void displayLevel1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(D) Display caTEring Items\n(P)Purchase\n(E)Exit");
        String choices = scanner.nextLine();

        File inputFile = new File("catering.csv");


        if (choices.equals( "D") ){
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
        double balance = 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("(M) Feed Money \n(S)Select Item\n(F)Finish Transaction\n\n Current Money Provided: " + balance);
        String choices = scanner.nextLine();

        File inputFile = new File("catering.csv");

        if (choices.equals("M")){
            System.out.println("Enter money in whole dollar amount: ");
            String amountDeposited = scanner.nextLine();
            double dollarAmount = Double.parseDouble(amountDeposited);
            balance += dollarAmount;
            System.out.println(balance);

        }else if (choices.equals("S")){
            try {
                Scanner fileScanner = new Scanner(inputFile);
                List<String[]>slotItemList = new ArrayList<>();
                String[] slotItem = new String[16];
                int count = 0;


                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                    String[] dataArr = line.split("\\,");
                    slotItem [count] = dataArr[0];
                    slotItemList.add(dataArr);

                }

                System.out.println("Enter slot identifier for wanted item: ");
                String slotScanner = scanner.nextLine();
              System.out.println(slotItemList.size());
                for (int i = 0; i<slotItem.length; i++){
                    if (slotItem[i].equals("A1")) {
                        System.out.println("This item is in stock ");

                    }else {
                        System.out.println("This item is not in stock ");
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        Menu menu = new Menu();
//        menu.displayLevel1();
        menu.displayLevel2();

}

    }






package com.ClothStoreProject;

import com.ClothStoreProject.OnePointOne;

import java.util.Scanner;

public class OnePointFour {

    public static byte response;

    public static void menuThree() {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Transaction History options menu: \n");

            System.out.println("0. Return to Main Menu");
            System.out.println("1. Print total profit from all item purchases");
            System.out.println("2. Print total units sold from all item purchases");
            System.out.println("3. Print the total number of item transactions made");
            System.out.println("4. Print all transactions made");
            System.out.println("5. Print total profit from a specific item");
            System.out.println("6. Print total units sold of a specific item");
            System.out.println("7. Print all transactions of a specific item");
            System.out.println("8. Print item with highest profit");

            System.out.print("\n Type an option number:  ");
            response = input.nextByte();

            if (response == 0) {
                System.out.println("\n Returning to main menu ... ");
                OnePointOne.main(new String[0]);
                break;
            } else if (response == 1) {
                break;
            } else if (response > 0 && response <= 8) {
                System.out.println("\n Executing Option " + response);
            } else {
                System.out.println("\n Invalid menu option. Please type another menu option. ");
            }
        } while (response != 0);
    }



















    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


    }
}

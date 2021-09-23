package com.ClothStoreProject;

import java.util.Scanner;

public class OnePointOne {

    public static void mainMenu() {
        System.out.println("Main Menu: Please choose among the options below.\n" +
                "\n" +
                "0. Close system.\n" +
                "1. Open Item options.\n" +
                "2. Open Review options.\n" +
                "3. Open Transaction History options.\n" +
                "\n" +
                "Type an option number:\n");
    }

    public static void readUserInput() {
        int response;
        Scanner input = new Scanner(System.in);

        do {
            response = input.nextInt();
            input.nextLine();

            switch (response) {
                case 0:
                    System.exit(404);
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another menu option. ");
                    mainMenu();
                    break;
            }
        } while (response < 0 || response > 3); // System only accepts value between 0 and 3, any other value
    }

    public static void main(String[] args) {
        mainMenu();
        readUserInput();
    }
}

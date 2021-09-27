package com.ClothStoreProject.EpicFeatureOne;

import static com.ClothStoreProject.EpicFeatureOne.Input.response;

public class StartMenu {

    public static void optionsList() {
        System.out.println("""
                
                Main Menu: Please choose among the options below.

                0. Close system.
                1. Open Item options.
                2. Open Review options.
                3. Open Transaction History options.
                """);

        System.out.print("Type an option number: ");
    }

        public static void putInOption () {
            do {
                Input.askOption();
                switch (response) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        // Anton add the reference to your code block here
                        break;
                    case 2:
                        // Akuen add the reference to your code block here
                        break;
                    case 3:
                        MenuThree.optionsList();
                        MenuThree.putInOption();       // For example, I am referring to the code I wrote in
                        break;                          // method MenuThree in class OnePointFour
                    default:
                        System.out.println("Invalid menu option. Please type another menu option. ");
                        optionsList();
                        break;
                }
            } while (response < 0 || response > 3); // System only accepts value between 0 and 3, any other value
        }

        public static void optionTwo () {
            // Anton add the reference to your code block here
        }

        public static void optionThree () {
            // Akuen add the reference to your code block here
        }
    }


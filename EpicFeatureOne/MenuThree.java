package com.ClothStoreProject.EpicFeatureOne;

public class MenuThree {

    public static void optionsList() {
        System.out.println("""

                Transaction History options menu:
                
                0. Return to Main Menu.
                1. Print total profit from all item purchases.
                2. Print total units sold from all item purchases.
                3. Print the total number of item transactions made.
                4. Print all transactions made.
                5. Print the total profit of a specific item.
                6. Print the number of units sold of a specific item.
                7. Print all transactions of a specific item.
                8. Print item with highest profit.
                """);

        System.out.print("Type an option number: ");
    }

    public static void putInOption() {
        do {
            Input.askOption();

            switch (Input.response) {
                case 0:
                    System.out.println("Returning to main menu ...");
                    StartMenu.optionsList();
                    StartMenu.putInOption();
                    break;
                case 1:
                    // Print total profit from all item purchases
                    break;
                case 2:
                    // Print total units sold from all item purchases
                    break;
                case 3:
                    // Print the total number of item transactions made
                    break;
                case 4:
                    // Print all transactions made.
                    break;
                case 5:
                    // Print the total profit of a specific item.
                    break;
                case 6:
                    // Print the number of units sold of a specific item
                    break;
                case 7:
                    // Print all transactions of a specific item.
                    break;
                case 8:
                    // Print item with the highest profit.
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another menu option.");
                    optionsList();
                    break;
           }
        } while (Input.response < 0 || Input.response > 8);
    }
}

package EF1;

public class MenuThree {

    public static void optionsList() {
        System.out.println("Transaction History options menu:\n" +
                "\n0. Return to Main Menu." +
                "\n1. Print total profit from all item purchases." +
                "\n2. Print total units sold from all item purchases." +
                "\n3. Print the total number of item transactions made." +
                "\n4. Print all transactions made." +
                "\n5. Print the total profit of a specific item." +
                "\n6. Print the number of units sold of a specific item." +
                "\n7. Print all transactions of a specific item." +
                "\n8. Print item with highest profit.");

        System.out.print("\nType an option number: ");
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

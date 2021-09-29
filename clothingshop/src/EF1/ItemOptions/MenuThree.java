package DIT043PROJECT.clothingshop.src.EF1.ItemOptions;

public class MenuThree {

    public static final String EOL = System.lineSeparator();

    public static void optionsList() {
        System.out.println("Transaction History options menu:" + EOL +
                "0. Return to Main Menu." + EOL +
                "1. Print total profit from all item purchases." + EOL +
                "2. Print total units sold from all item purchases." + EOL +
                "3. Print the total number of item transactions made." + EOL +
                "4. Print all transactions made." + EOL +
                "5. Print the total profit of a specific item." + EOL +
                "6. Print the number of units sold of a specific item." + EOL +
                "7. Print all transactions of a specific item." + EOL +
                "8. Print item with highest profit." + EOL);

        System.out.println("Type an option number: ");
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

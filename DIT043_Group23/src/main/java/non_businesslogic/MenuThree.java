package non_businesslogic;

import facade.Facade;

public class MenuThree {

    static final String EOL = System.lineSeparator();

    static void optionsList() {
        System.out.println(EOL + "Transaction History options menu:" + EOL +
                "0. Return to Main Menu." + EOL +
                "1. Print total profit from all item purchases." + EOL +
                "2. Print total units sold from all item purchases." + EOL +
                "3. Print the total number of item transactions made." + EOL +
                "4. Print all transactions made." + EOL +
                "5. Print the total profit of a specific item." + EOL +
                "6. Print the number of units sold of a specific item." + EOL +
                "7. Print all transactions of a specific item." + EOL +
                "8. Print item with highest profit." + EOL);
    }

    static void putInOption() {
        int response;

        do {
            optionsList();
            response = UserInput.inputInt("Type an option number: ");

            switch (response) {
                case 0:
                    StartMenu.putOption();
                    break;
                case 1:
                    Facade.getTotalProfit();
                    /** This block is having some issues, so ignore the red marking for the moment.*/

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
                    System.out.println("Invalid menu option. Please type another menu option." + EOL);
                    optionsList();
                    break;
            }
        } while (response < 0 || response > 8);
    }
}

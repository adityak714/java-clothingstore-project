package logic_classes;

public class TransactionMenu {

    private Facade facade;
    public Facade getFacade() {
        return facade;
    }

    private StartMenu startMenu;

    static void optionsList() {
        System.out.println(ItemOptions.EOL + "Transaction History options menu:" + ItemOptions.EOL +
                "0. Return to Main Menu." + ItemOptions.EOL +
                "1. Print total profit from all item purchases." + ItemOptions.EOL +
                "2. Print total units sold from all item purchases." + ItemOptions.EOL +
                "3. Print the total number of item transactions made." + ItemOptions.EOL +
                "4. Print all transactions made." + ItemOptions.EOL +
                "5. Print the total profit of a specific item." + ItemOptions.EOL +
                "6. Print the number of units sold of a specific item." + ItemOptions.EOL +
                "7. Print all transactions of a specific item." + ItemOptions.EOL +
                "8. Print item with highest profit." + ItemOptions.EOL);
    }

    void putInOption() {
        int response;

        facade = new Facade();
        startMenu = new StartMenu();

        String itemID;

        do {

                optionsList();
                response = Utilities.inputInt("Type an option number: ");
            try {
                switch (response) {
                    case 0:
                        startMenu.putOption();
                        break;
                    case 1:
                        facade.getTotalProfit();
                        /*This block is having some issues, so ignore the red marking for the moment.*/
                        break;
                    case 2:
                        facade.getTotalUnitsSold();
                        // Print total units sold from all item purchases
                        break;
                    case 3:
                        facade.printItemTransactions("");
                        // Print the total number of item transactions made
                        break;
                    case 4:
                        facade.getTotalTransactions();
                        // Print all transactions made.
                        break;
                    case 5:
                        itemID = Utilities.inputString(ItemOptions.EOL + "Type the ID number for the item: ");
                        facade.getProfit(itemID);
                        // Print the total profit of a specific item.
                        break;
                    case 6:
                        itemID = Utilities.inputString(ItemOptions.EOL + "Type the ID number for the item: ");
                        facade.getUnitsSolds(itemID);
                        // Print the number of units sold of a specific item
                        break;
                    case 7:
                        itemID = Utilities.inputString(ItemOptions.EOL + "Type the ID number for the item: ");
                        facade.printItemTransactions(itemID);
                        // Print all transactions of a specific item.
                        break;
                    case 8:
                        facade.printMostProfitableItems();
                        // Print item with the highest profit.
                        break;
                    default:
                        System.out.println("Invalid menu option. Please type another menu option." + ItemOptions.EOL);
                        optionsList();
                        break;
                }
            }catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        } while (response < 0 || response > 8);
    }
}

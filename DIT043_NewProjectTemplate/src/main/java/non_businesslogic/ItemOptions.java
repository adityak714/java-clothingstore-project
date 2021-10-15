package non_businesslogic;

import facade.Facade;

public class ItemOptions {

    public static final String EOL = System.lineSeparator();

    private Facade facade;
    public Facade getFacade() {
        return facade;
    }

    private StartMenu startMenu;
    public StartMenu getStartMenu() {
        return startMenu;
    }

    public void printMenu(){
        int input;

        facade = new Facade();
        startMenu = new StartMenu();

        do {
            System.out.println(EOL + "Item options menu: "

            + EOL + "0. Return to Main Menu. "
            + EOL + "1. Create an Item. "
            + EOL + "2. Remove an Item. "
            + EOL + "3. Print all registered Items. "
            + EOL + "4. Buy an Item. "
            + EOL + "5. Update an item's name. "
            + EOL + "6. Update an item's price. ");

            input = Utilities.inputInt(EOL + "Type an option number: ");
            String id;
            String name;
            double price;
            int amount;
            String newName;
            double newPrice;

            switch(input) {
                case 0:
                    startMenu.putOption();
                    break;
                case 1:
                    id = Utilities.inputString(EOL + "Type an ID number for the new item: ");
                    name = Utilities.inputString("Create a name for the new item: ");
                    price = Utilities.inputDouble("Enter a price for the new item: ");
                    facade.createItem(id, name, price);
                    break;
                case 2:
                    id = Utilities.inputString(EOL + "Type the ID of the item to be removed: ");
                    facade.removeItem(id);
                    break;
                case 3:
                    facade.printAllItems();
                    break;
                case 4:
                    id = Utilities.inputString(EOL + "Type the ID of the item you would like to purchase: ");
                    amount = Utilities.inputInt("Enter the amount of this item you would like to purchase: ");
                    facade.buyItem(id, amount);
                    break;
                case 5:
                    id = Utilities.inputString(EOL + "Enter the ID of the item to update the name: ");
                    newName = Utilities.inputString("Enter the new name for the item: ");
                    facade.updateItemName(id, newName);
                    break;
                case 6:
                    id = Utilities.inputString(EOL + "Type the ID of the item to update the price of: ");
                    newPrice = Utilities.inputDouble("Set new price as: ");
                    facade.updateItemPrice(id, newPrice);
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option" + EOL);
                    printMenu();
             }
        } while(input < 0 || input > 6);
    }
}
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

            switch(input) {
                case 0:
                    startMenu.putOption();
                    break;
                case 1:
                    // Move input declarations here
//                    facade.createItem();
                    break;
                case 2:
                    System.out.print("RemoveItem();");
                    break;
                case 3:
                    System.out.print("PrintItem();");
                    break;
                case 4:
                    System.out.print("BuyItem();");
                    break;
                case 5:
                    System.out.print("UpdateItemName();");
                    break;
                case 6:
                    System.out.print("UpdateItemPrice();");
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option" + EOL);
                    printMenu();
             }
        } while(input < 0 || input > 6);
    }
}

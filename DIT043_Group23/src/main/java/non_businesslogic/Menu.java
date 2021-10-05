package non_businesslogic;

public class Menu {

    public static final String EOL = System.lineSeparator();

    public static void printMenu(){

        int input;

        do {
            System.out.println(EOL + "Item options menu: "

            + EOL + "0. Return to Main Menu. "
            + EOL + "1. Create an Item. "
            + EOL + "2. Remove an Item. "
            + EOL + "3. Print all registered Items. "
            + EOL + "4. Buy an Item. "
            + EOL + "5. Update an item's name. "
            + EOL + "6. Update an item's price. ");

            input = UserInput.inputInt(EOL + "Type an option number: ");

            switch(input) {
                case 0:
                   StartMenu.putOption();
                    break;
                case 1:
                    CreateItem.CreatingItem();
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

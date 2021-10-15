package non_businesslogic;

public class StartMenu {

    private ItemOptions itemOptions;

    private ReviewOption reviewOption;

    private MenuThree menuThree;

    public static void optionsList() {
        System.out.println(ItemOptions.EOL + "Main Menu: Please choose among the options below." + ItemOptions.EOL +
                "0. Close system." + ItemOptions.EOL +
                "1. Open Item options." + ItemOptions.EOL +
                "2. Open Review options." + ItemOptions.EOL +
                "3. Open Transaction History options." );
    }

    public void putOption() {
            int response;

            itemOptions = new ItemOptions();
            reviewOption = new ReviewOption();
            menuThree = new MenuThree();

            do {
            optionsList();
            response = Utilities.inputInt(ItemOptions.EOL + "Type an option number: ");

            switch (response) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    itemOptions.printMenu();
                    break;
                case 2:
                    reviewOption.reviewsMenu();
                    break;
                case 3:
                    menuThree.putInOption();
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another menu option." + ItemOptions.EOL);
                    break;
            }
        } while (response < 0 || response > 3);
    }
}


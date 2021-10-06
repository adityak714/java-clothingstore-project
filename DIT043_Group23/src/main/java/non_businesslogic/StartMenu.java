package non_businesslogic;

public class StartMenu {

    static final String EOL = System.lineSeparator();

    public static void optionsList() {
        System.out.println(EOL + "Main Menu: Please choose among the options below." + EOL +
                "0. Close system." + EOL +
                "1. Open Item options." + EOL +
                "2. Open Review options." + EOL +
                "3. Open Transaction History options." );
    }

    public static void putOption() {
            int response;

        do {
            optionsList();
            response = Utilities.inputInt(EOL + "Type an option number: ");

            switch (response) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Menu.printMenu();
                    break;
                case 2:
                    ReviewOption.reviewsMenu();
                    break;
                case 3:
                    MenuThree.putInOption();
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another menu option." + EOL);
                    break;
            }
        } while (response < 0 || response > 3);
    }
}


package ItemOptions;

public class StartMenu {

    static final String EOL = System.lineSeparator();

    public static void optionsList() {
        System.out.println(EOL + "Main Menu: Please choose among the options below." + EOL +
                "0. Close system." + EOL +
                "1. Open Item options." + EOL +
                "2. Open Review options." + EOL +
                "3. Open Transaction History options." );
    }

    public static void putInOption () {
            int response;

        do {
            optionsList();
            response = UserInput.inputInt(EOL + "Type an option number: ");

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
                    MenuThree.putInOption();       // For example, I am referring to the code I wrote in
                    break;                          // method MenuThree in class OnePointFour
                default:
                    System.out.println("Invalid menu option. Please type another menu option." + EOL);
                    optionsList();
                    break;
            }
        } while (response < 0 || response > 3); // System only accepts value between 0 and 3, any other value
    }
}


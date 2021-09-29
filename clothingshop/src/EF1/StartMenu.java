package EF1;

import static EF1.Input.response;

public class StartMenu {

    public static void optionsList() {
        System.out.println("Main Menu: Please choose among the options below.\n" +
                "\n0. Close system." +
                "\n1. Open Item options." +
                "\n2. Open Review options." +
                "\n3. Open Transaction History options.");

        System.out.print("\nType an option number: ");
    }

    public static void putInOption () {
        do {
            Input.askOption();
            switch (response) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    break;
                case 2:
                    // Akuen add the reference to your code block here
                    break;
                case 3:
                    MenuThree.optionsList();
                    MenuThree.putInOption();       // For example, I am referring to the code I wrote in
                    break;                          // method MenuThree in class OnePointFour
                default:
                    System.out.println("Invalid menu option. Please type another menu option. \n");
                    optionsList();
                    break;
            }
        } while (response < 0 || response > 3); // System only accepts value between 0 and 3, any other value
    }
}


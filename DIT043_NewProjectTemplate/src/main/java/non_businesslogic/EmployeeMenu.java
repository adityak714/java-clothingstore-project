package non_businesslogic;

public class EmployeeMenu {
    private Facade facade;

    public Facade getFacade() {
        return facade;
    }

    public void printMenu(){
        int input;

        facade = new Facade();
        StartMenu startMenu = new StartMenu();

        do {
            System.out.println(ItemOptions.EOL + "Employee Options Menu:  "

                    + ItemOptions.EOL + "0. Return to Main Menu. "
                    + ItemOptions.EOL + "1. Create an employee (Regular Employee). "
                    + ItemOptions.EOL + "2. Create an employee (Manager). "
                    + ItemOptions.EOL + "3. Create an employee (Director). "
                    + ItemOptions.EOL + "4. Create an employee (Intern). "
                    + ItemOptions.EOL + "5. Remove an employee. "
                    + ItemOptions.EOL + "6. Print specific employee. "
                    + ItemOptions.EOL + "7. Print all registered employees. "
                    + ItemOptions.EOL + "8. Print the total expense with net salary. "
                    + ItemOptions.EOL + "9. Print all employees sorted by gross salary. ");

            input = Utilities.inputInt(ItemOptions.EOL + "Type an option number: ");

            switch(input) {
                case 0:
                    startMenu.putOption();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option" + ItemOptions.EOL);
                    printMenu();
            }
        } while(input < 0 || input > 9);
    }
}

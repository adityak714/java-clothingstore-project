package logic_classes;

public class EmployeeMenu {
    private Facade facade;

    public Facade getFacade() {
        return facade;
    }

    public void printMenu() throws Exception {
        int input;

        facade = new Facade();
        StartMenu startMenu = new StartMenu();

        String id;
        String name;
        double salary;
        String degree;
        String department;
        int gpa;

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

                switch (input) {
                    case 0:
                        startMenu.putOption();
                        break;
                    case 1:
                        id = Utilities.inputString(ItemOptions.EOL + "Type an ID number for the new employee: ");
                        name = Utilities.inputString("Create a name for the new employee: ");
                        salary = Utilities.inputDouble("Enter a salary for the new employee: ");
                        facade.createEmployee(id, name, salary);
                        //Create an employee (Regular Employee).
                        break;
                    case 2:
                        id = Utilities.inputString(ItemOptions.EOL + "Type an ID number for the new employee: ");
                        name = Utilities.inputString("Create a name for the new employee: ");
                        degree = Utilities.inputString("Create a degree for the new employee: ");
                        salary = Utilities.inputDouble("Enter a salary for the new employee: ");
                        facade.createEmployee(id, name, salary, degree);
                        //Create an employee (Manager).
                        break;
                    case 3:
                        id = Utilities.inputString(ItemOptions.EOL + "Type an ID number for the new employee: ");
                        name = Utilities.inputString("Create a name for the new employee: ");
                        degree = Utilities.inputString("Create a degree for the new employee: ");
                        salary = Utilities.inputDouble("Enter a salary for the new employee: ");
                        department = Utilities.inputString("Create a department for the new employee: ");
                        facade.createEmployee(id, name, salary, degree, department);
                        //Create an employee (Director).
                        break;
                    case 4:
                        id = Utilities.inputString(ItemOptions.EOL + "Type an ID number for the new employee: ");
                        name = Utilities.inputString("Create a name for the new employee: ");
                        salary = Utilities.inputDouble("Enter a salary for the new employee: ");
                        gpa = Utilities.inputInt("Enter gpa value for the new employee: ");
                        facade.createEmployee(id, name, salary, gpa);
                        //Create an employee (Intern).
                        break;
                    case 5:
                        id = Utilities.inputString(ItemOptions.EOL + "Type an ID number for the new employee: ");
                        facade.removeEmployee(id);
                        //Remove an employee.
                        break;
                    case 6:
                        id = Utilities.inputString(ItemOptions.EOL + "Type an ID number for the new employee: ");
                        facade.printEmployee(id);
                        //Print specific employee.
                        break;
                    case 7:
                        facade.printAllEmployees();
                        //Print all registered employees.
                        break;
                    case 8:
                        facade.getTotalNetSalary();
                        //Print the total expense with net salary.
                        break;
                    case 9:
                        facade.printSortedEmployees();
                        // Print all employees sorted by gross salary.
                        break;
                    default:
                        System.out.println("Invalid menu option. Please type another option" + ItemOptions.EOL);
                        printMenu();
                }

        } while(input < 0 || input > 9);
    }
}

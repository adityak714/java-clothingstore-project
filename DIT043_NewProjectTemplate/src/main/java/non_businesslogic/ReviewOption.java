package non_businesslogic;

public class ReviewOption {

    public static final String EOL = System.lineSeparator();

    private Facade facade;
    public Facade getFacade() {
        return facade;
    }

    private StartMenu startMenu;

    public void reviewsMenu() {

        facade = new Facade();
        startMenu = new StartMenu();

        int optionNumber;

        do {
            optionNumber = Utilities.inputInt(EOL + "Review options menu: " + EOL +
                    "0. Return to Main Menu. " + EOL +
                    "1. Create a review for an Item." + EOL +
                    "2. Print a specific review of an Item." + EOL +
                    "3. Print all reviews of an Item." + EOL +
                    "4. Print mean grade of an Item" + EOL +
                    "5. Print all comments of an Item." + EOL +
                    "6. Print all registered reviews." + EOL +
                    "7. Print item(s) with most reviews." + EOL +
                    "8. Print item(s) with least reviews." + EOL +
                    "9. Print item(s) with best mean review grade." + EOL +
                    "10. Print item(s) with worst mean review grade." + EOL
                    + EOL + "Type an option number: ");
            try{
            switch (optionNumber) {
                case 0:
                    startMenu.putOption();
                    break;
                case 1:
                    String itemID = Utilities.inputString("Enter the specific ID of the item: ");
                    break;
                case 2:
                    System.out.println("PrintSpecificReviews()");
                    break;
                case 3:
                    System.out.println("PrintAllReviews()");
                    break;
                case 4:
                    System.out.println("PrintMeanGrade()");
                    break;
                case 5:
                    System.out.println("Printing all comments");
                    break;
                case 6:
                    System.out.println("Printing all registered reviews");
                    break;
                case 7:
                    System.out.println("Printing item(s) with most reviews");
                    break;
                case 8:
                    System.out.println("Printing item(s) with least reviews");
                    break;
                case 9:
                    System.out.println("Printing item(s) with best mean review grade");
                    break;
                case 10:
                    System.out.println("Printing item(s) with worst mean review grade");
                    break;
                default:
                    System.out.println("“Invalid menu option. Please type another option”");
                    break;
            }
            }catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        } while (optionNumber < 0 || optionNumber > 10);
    }
}











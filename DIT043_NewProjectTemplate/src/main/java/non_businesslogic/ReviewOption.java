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
        String itemID;
        String comment;
        int reviewNumber;

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
                    itemID = Utilities.inputString("Enter the specific ID of the item: ");
                    comment = Utilities.inputString("Enter a comment about the item: ");
                    int grade = Utilities.inputInt("Enter a grade for the item: ");
                    facade.reviewItem(itemID, comment, grade);
                    break;
                case 2:
                    itemID = Utilities.inputString("Enter the specific ID of the item: ");
                    reviewNumber = Utilities.inputInt("Enter the number of the review: ");
                    facade.getPrintedItemReview(itemID, reviewNumber);
                    break;
                case 3:
                    itemID = Utilities.inputString("Enter the specific ID of the item: ");
                    facade.getPrintedReviews(itemID);
                    break;
                case 4:
                    itemID = Utilities.inputString("Enter the specific ID of the item: ");
                    facade.getItemMeanGrade(itemID);
                    break;
                case 5:
                    itemID = Utilities.inputString("Enter the specific ID of the item: ");
                    facade.getItemComments(itemID);
                    break;
                case 6:
                    facade.printAllReviews();
                    break;
                case 7:
                    facade.getMostReviewedItems();
                    break;
                case 8:
                    facade.getLeastReviewedItems();
                    break;
                case 9:
                    facade.getBestReviewedItems();
                    break;
                case 10:
                    facade.getWorseReviewedItems();
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











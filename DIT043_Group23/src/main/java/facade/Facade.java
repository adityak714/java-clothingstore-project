package facade;

import non_businesslogic.ItemController;

import java.util.List;

public class Facade {

    private final ItemController ITEMCONTROLLER = new ItemController();

    public Facade() {}

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public String createItem(String itemID, String itemName, double unitPrice) {
        if (ITEMCONTROLLER.CreatingItem(itemID, itemName, unitPrice)) {
            return ("Item " + itemID + " was registered successfully.");
        }

        return ("Invalid data for item.");
    }

    public String printItem(String id) {
        return ITEMCONTROLLER.printItem(id);
    }

    public String removeItem(String itemID) {
        return ITEMCONTROLLER.removeItem(itemID);
    }

    public boolean containsItem(String itemID) {
        return false;
    }

    public double buyItem(String itemID, int amount) {
        return ITEMCONTROLLER.buyItem(itemID, amount);
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {

        return ITEMCONTROLLER.CreateReview(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return reviewItem(itemID, "", reviewGrade);
    }

    public String getItemCommentsPrinted(String itemID) {
        return "";
    }

    public List<String> getItemComments(String itemID) {
        return null;
    }

    public double getItemMeanGrade(String itemID) {
        return -1.0;
    }

    public int getNumberOfReviews(String itemID) {
        return -1;
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        return "";
    }

    public String getPrintedReviews(String itemID) {
        return "";
    }

    public String printMostReviewedItems() {
        return "";
    }

    public List<String> getMostReviewedItems() {
        return null;
    }

    public List<String> getLeastReviewedItems() {
        return null;
    }

    public String printLeastReviewedItems() {
        return "";
    }

    public double getTotalProfit() {
        return -1.0;
    }

    public String printItemTransactions(String itemID) {
        return "";
    }

    public int getTotalUnitsSold() {
        return -1;
    }

    public int getTotalTransactions() {
        return -1;
    }

    public double getProfit(String itemID) {
        return -1.0;
    }

    public int getUnitsSolds(String itemID) {
        return -1;
    }

    public String printAllTransactions() {
        return "";
    }

    public String printWorseReviewedItems() {
        return "";
    }

    public String printBestReviewedItems() {
        return "";
    }

    public List<String> getWorseReviewedItems() {
        return null;
    }

    public List<String> getBestReviewedItems() {
        return null;
    }

    public String printAllReviews() {
        return "";
    }

    public String updateItemName(String itemID, String newName) {
        return ITEMCONTROLLER.updatingName(itemID, newName);
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return ITEMCONTROLLER.updatingPrice(itemID, newPrice);
    }

    public String printAllItems() {
        return ITEMCONTROLLER.printItems();
    }

    public String printMostProfitableItems() {
        return "";
    }
}
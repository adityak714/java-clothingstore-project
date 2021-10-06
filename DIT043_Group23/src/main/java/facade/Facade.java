package facade;

import non_businesslogic.Item;
import non_businesslogic.ItemController;
import non_businesslogic.Menu;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class Facade {

    ItemController itemController = new ItemController();

    public Facade() {}

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public String createItem(String itemID, String itemName, double unitPrice) {
        if (itemController.CreatingItem(itemID, itemName, unitPrice)) {
            return ("Item " + itemID + " was registered successfully.");
        }

        return ("Invalid data for item. Item cannot be created. ");
    }

    public String printItem(String id) {
        return itemController.printItem(id);
    }

    public String removeItem(String itemID) {
        return "";
    }

    public boolean containsItem(String itemID) {
        return false;
    }

    public double buyItem(String itemID, int amount) {
        return 0.0;
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        return "";
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return "";
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
        return "";
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return "";
    }

    public String printAllItems() {
        return itemController.printItems();
    }

    public String printMostProfitableItems() {
        return "";
    }
}
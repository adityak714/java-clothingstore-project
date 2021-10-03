package facade;

import non_businesslogic.CreateItem;
import non_businesslogic.Menu;
import non_businesslogic.MenuThree;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facade {

    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();

    // TA
    // Is it fine if variables are declared like this in the body of the facade?

    public ArrayList<String> getIds() {return ids;}
    public ArrayList<Double> getPrices() {return prices;}
    public ArrayList<String> getNames() {return names;}

    public Facade() {}

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public String createItem(String itemID, String itemName, double unitPrice) {
        ids.add(itemID);
        names.add(itemName);
        prices.add(unitPrice);

        return "";
    }

    public String printItem(String itemID) {
        double price = 0;
        String name = "";

        do {
            if (ids.contains(itemID)) {
                double itemPrice = CreateItem.Create().getPrice();
                name = CreateItem.Create().getName();

                DecimalFormat truncate = new DecimalFormat("#.##");
                truncate.setRoundingMode(RoundingMode.DOWN);
                price = Double.parseDouble(truncate.format(itemPrice));

                // TA
                // Is this method of printing a single particular item workable?

            } else {
                System.out.println("Item" + itemID + " was not registered yet.");
            }
        } while (ids.contains(itemID));

        return String.format(" %s: %s. " + price + " SEK ", itemID, name);
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
        String fullItemsList = "All registered items. " + Menu.EOL;
        String eachItem = String.format(" %s: %s. " + CreateItem.Create().getPrice() + " SEK ",
                CreateItem.Create().getID(), CreateItem.Create().getName());

        return fullItemsList + eachItem.repeat(ids.size());
        // TA
    }

    public String printMostProfitableItems() {
        return "";
    }
}
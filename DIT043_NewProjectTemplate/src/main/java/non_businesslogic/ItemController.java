package non_businesslogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ItemController {

    //ATTRIBUTES

    private final List<Item> items;

    public List<Item> getItems() {
        return this.items;
    }

    public ItemController() {
        items = new ArrayList<>();
    }


    private final Item empty = new Item("","", 0.0);
    //private final Review emptyReview = new Review("",0);


    private Item desiredItem;

    public Item getItem(String itemID) {
        for (Item item : items) {
            if (/*Objects.equals(item.getID(), itemID)*/item.hasSameID(itemID)) {
               // (items.contains(getItem(itemID)))
               return item;
            }
        }
       return empty;
    }


    public List<Integer> getGrades(String itemID){
        Item desiredItem = getItem(itemID);
        List<Integer> grades = new ArrayList<>();

        for(Review review : desiredItem.getReviews()){
            grades.add(review.getGrade());

        }
        return grades;

    }

/*
    public boolean containsItem(String currentItem){
        for(Item item : items){
            if(item.hasSameID(currentItem)){
                return true;
            }
        }
        return false;
    }

    public Review getReview(String itemID) {
        Item desiredItem = getItem(itemID);

        for(Review review : desiredItem.getReviews()){
            return review;
        }
        return emptyReview;
    }
*/


    //2.1 -- I want to create items in my system so that I can sell them in my system.
    public boolean CreatingItem(String id, String name, double price) {

    /*2.2 -- I want to avoid the creation of items with invalid data
             so that I only have reliable data in my system. */
        if (id.isEmpty() || name.isEmpty() || price <= 0) {
            return false;
        }

        Item item = new Item(id, name, price);
        items.add(item);
        return true;
    }


    //EF 2.3 UPDATING AN ITEM IN THE SYSTEM.
    public String updatingName(String itemID, String newName){
        desiredItem = getItem(itemID);

        if(items.contains(desiredItem)) {
            if(newName.isEmpty()){
                return "Invalid data for item.";
            }
            else {
                desiredItem.setName(newName);
            }
        }
        else {
            return ("Item " + itemID + " was not registered yet.");
        }

        return "Item " + desiredItem.getID() + " was updated successfully.";
    }


    public String updatingPrice(String itemID, double newPrice){
        desiredItem = getItem(itemID);

        if(items.contains(desiredItem)) {
            if(newPrice <= 0){
                return "Invalid data for item.";
            }
            else {
                desiredItem.setPrice(newPrice);
            }
        }
        else {
            return ("Item " + itemID + " was not registered yet.");
        }

        return "Item " + desiredItem.getID() + " was updated successfully.";
    }


    //2.4 BUYING AN ITEM.
    public double buyItem (String itemID, int amount){
        final int DISCOUNT_THRESHOLD = 4;
        Transaction newTransaction;
        double itemsPrice;
        desiredItem = getItem(itemID);

        if (!(desiredItem.equals(empty))) {
           // (!(getItem(itemID) == null))
            double unitPrice = desiredItem.getPrice();

            if (amount <= DISCOUNT_THRESHOLD) {
                itemsPrice = (amount * unitPrice);
                newTransaction = new Transaction(itemID, amount, itemsPrice);
                desiredItem.getTransactionHistory().add(newTransaction);
                return itemsPrice;
            }

            int extraItems = amount - DISCOUNT_THRESHOLD;
            itemsPrice = (DISCOUNT_THRESHOLD * unitPrice) + extraItems * (unitPrice * (0.7));
            DecimalFormat df = new DecimalFormat (" #.##");
            df.setRoundingMode(RoundingMode.FLOOR);

            newTransaction = new Transaction(itemID, amount, itemsPrice);
            desiredItem.getTransactionHistory().add(newTransaction);

            return Double.parseDouble(df.format(itemsPrice));
            }
        return -1.0;
    }


    // 2.5 REMOVING AN ITEM.
    public String removeItem (String itemID){
       desiredItem = getItem(itemID);

        if (items.contains(desiredItem)) {
            items.remove(desiredItem);
            return ("Item " + itemID + " was successfully removed.");

        }
            return ("Item " + itemID + " could not be removed.");
    }


    //2.6 - PRINTING THE OVERVIEW OF ONE ITEM.
    public String printItem(String itemID) {
        desiredItem = getItem(itemID);

        String name = desiredItem.getName();
        double price = desiredItem.getPrice();

        if (!(items.contains(desiredItem)) || desiredItem.equals(empty)) {
            return("Item " + itemID + " was not registered yet.");
        }

        return String.format("%s: %s. " + String.format("%.2f", price) + " SEK", itemID, name);
    }


    //2.7 - PRINTING A LIST OF ALL REGISTERED ITEMS.
    public String printItems () {
        StringBuilder sb = new StringBuilder();

        sb.append("All registered items:").append(ItemOptions.EOL);
        for (Item i : getItems()) {
            sb.append(String.format("%s: %s. " + String.format("%.2f", i.getPrice()) + " SEK", i.getID(), i.getName()));
            sb.append(ItemOptions.EOL);
        }

        if (items.isEmpty()) {
            return "No items registered yet.";
        }

        return sb.toString();
    }


    //3.1
    Review review;
    String successfulRegistration = "Your item review was registered successfully.";

    public String CreateReview(String itemID, int reviewGrade){
        desiredItem = getItem(itemID);

        if(items.contains(desiredItem)) {
           if(!(reviewGrade >= 1 && reviewGrade <= 5)) {
               return "Grade values must be between 1 and 5.";
           }
           review = new Review(reviewGrade);
           desiredItem.getReviews().add(review);
           return successfulRegistration;
       }

        return "Item " + itemID + " not found.";
    }


    public String CreateReview(String itemID, String reviewComment, int reviewGrade){

        // String itemID = Utilities.inputString("Enter the specific ID of the item: ");
        desiredItem = getItem(itemID);


        if (items.contains(desiredItem)){
            if(!(reviewGrade >= 1 && reviewGrade <= 5)) {
                return "Grade values must be between 1 and 5.";
            }
            review = new Review(reviewComment, reviewGrade);
            desiredItem.getReviews().add(review);
            return successfulRegistration;
        }

        return "Item " + itemID + " not found.";
    }


    //3.2
    public String getPrintedItemReview(String itemID, int reviewNumber){

        String name = getItem(itemID).getName();
        ArrayList<Review> reviews = getItem(itemID).getReviews();
        boolean noReviews = getItem(itemID).getReviews().isEmpty();
        boolean hasItem = getItems().contains(getItem(itemID));

        // First if block to be converted as do while loop in the menu.
        if(!hasItem){
            return "Item " + itemID + " was not registered yet.";
        }
        if(noReviews){
            return "Item " + name + " has not been reviewed yet.";
        }
        if(reviewNumber < 1 || reviewNumber > reviews.size()){
            return "Invalid review number. Choose between 1 and " + reviews.size() + ".";
        }
        return reviews.get(reviewNumber - 1).toString();
    }


    //3.3
    public String printReviews(String itemID){
        StringBuilder sb = new StringBuilder();
        String name = getItem(itemID).getName();
        double price = getItem(itemID).getPrice();
        boolean noReviews = getItem(itemID).getReviews().isEmpty();
        boolean hasItem = getItems().contains(getItem(itemID));

        if(!hasItem){
            return "Item " + itemID + " was not registered yet.";
        }

        sb.append(String.format("Review(s) for %s: %s. %.2f SEK", itemID, name, price)).append(ItemOptions.EOL);

        if(noReviews){
            sb.append(String.format("The item %s has not been reviewed yet.", name));
        }

        for (Review review : getItem(itemID).getReviews()) {
            sb.append(String.format("Grade: %d.%s", review.getGrade(), review.getComment())).append(ItemOptions.EOL);
        }

        return sb.toString();

    }


    //3.4
    public double getMeanItem(String itemID){
        double sum = 0.0;
        double reviewMean;
        int truncatingResult;
        double truncatedResult;


        Item item = getItem(itemID);
        List<Review> reviews = item.getReviews();
        //Item review = getReviews(itemID);
        if(reviews.isEmpty()){
            return sum;
        }
        for (Review grade : reviews) {
            sum += grade.getGrade();
        }

       /* sum /= reviews.size();

        double scale = (int) Math.pow(10, 1);
        truncatedResult = (int) (sum * scale);

        return truncatedResult / scale;*/

        reviewMean = sum / reviews.size();
        truncatingResult = (int)(reviewMean * 10);
        truncatedResult = (double) truncatingResult / 10;

        return truncatedResult;
    }


    //3.5
    public List<String> getActualComments(String itemID){
        Item desiredItem = getItem(itemID);
        List<String> comments = new ArrayList<>();

        if(desiredItem.hasSameID(itemID)) {
            for (Review review : desiredItem.getReviews()) {
                if(!review.getComment().isBlank()){
                    comments.add(review.getComment());
                }

            }
        }

        return comments;
    }


    //3.6
    public String printAllReviews(){
        StringBuilder sb = new StringBuilder();
        if (items.isEmpty()) {
            return "No items registered yet.";
        }

        sb.append("All registered reviews:").append(ItemOptions.EOL);
        sb.append("------------------------------------").append(ItemOptions.EOL);

        boolean reviewed=false;

        for (Item item : getItems()) {
            // add later to the menu.
            if(item.getAmountOfReviews() > 0){
                reviewed = true;
                sb.append(String.format("Review(s) for %s: %s. %.2f SEK" + ItemOptions.EOL, item.getID(), item.getName(), item.getPrice()));
                for (Review review : getItem(item.getID()).getReviews()) {
                    sb.append(String.format("Grade: %d.%s", review.getGrade(), review.getComment())).append(ItemOptions.EOL);
                }
                sb.append("------------------------------------").append(ItemOptions.EOL);
            }
        }

        if(reviewed){
            return sb.toString();
        }
        else {
            return "No items were reviewed yet.";
        }
    }


    //3.7
    public String printMostReviewedItems() {
        StringBuilder sb = new StringBuilder();

        if (getItems().isEmpty()) {
            return "No items registered yet.";
        }

        getItems().sort(Comparator.comparingInt(Item::getAmountOfReviews));
        Item mostAmountOfReviews = getItems().get(getItems().size() - 1);

        if(mostAmountOfReviews.getAmountOfReviews()==0){
            return "No items were reviewed yet.";
        }
        else {
            sb.append(String.format("Most reviews: %d review(s) each.", mostAmountOfReviews.getAmountOfReviews())).append(ItemOptions.EOL);

            for (Item item : getItems()) {
                if (item.getAmountOfReviews() == mostAmountOfReviews.getAmountOfReviews()) {
                    sb.append(printItem(item.getID())).append(ItemOptions.EOL);
                }
            }
            return sb.toString();
        }
    }


    //to be discussed with greg, copying items from previous list into this list
    public String printLeastReviewedItems() {
        StringBuilder sb = new StringBuilder();

        if(getItems().isEmpty()){
            return "No items registered yet.";
        }

        if(getLeastReviewedSet() != null) {
            if(getLeastReviewedSet().isEmpty()){
                return "No items were reviewed yet.";
            }
            sb.append(String.format("Least reviews: %d review(s) each." + ItemOptions.EOL, numLeast));

            for (Item item : getLeastReviewedSet()) {
                sb.append(item).append(ItemOptions.EOL);
            }
            return sb.toString();
        }
        else return "Least reviews: 0 review(s) each."; //test oracle computed wrongly by Francisco

    }


    int numLeast;


    public List<Item> getLeastReviewedSet(){
        List<Item> least = new ArrayList<>();

        if(getItems().isEmpty()){
            return least;
        }

        getItems().sort(Comparator.comparingInt(Item::getAmountOfReviews));

        Item leastReviewed = null;
        for(Item item : getItems()){
            if(item.getAmountOfReviews() > 0){
                leastReviewed = item;
                numLeast = item.getAmountOfReviews();
                break;
            }
        }

        if(leastReviewed!=null) {
            for (Item item : getItems()) {
                if (item.getAmountOfReviews() == leastReviewed.getAmountOfReviews() && item.getAmountOfReviews() > 0) {
                    least.add(item);
                }
            }
        }

        return least;
    }


    public List<String> getLeastReviewedItems(){
        List<String> leastReviewed = new ArrayList<>();

        if(getItems().isEmpty()){
            return leastReviewed;
        }

        getItems().sort(Comparator.comparingInt(Item::getAmountOfReviews));

        Item leastReviewedItem = null;

        for(Item item : getItems()){
            if(item.getAmountOfReviews() > 0){
                leastReviewedItem = item;
                break;
            }
        }

        if(leastReviewedItem!=null) {
            for (Item item : getItems()) {
                if (item.getAmountOfReviews() == leastReviewedItem.getAmountOfReviews() && item.getAmountOfReviews() > 0) {
                    leastReviewed.add(item.getID());
                }
            }
        }
        return leastReviewed;
    }


    public List<String> getMostReviewedItems(){
        List<String> mostReviewed = new ArrayList<>();

        if(getItems().isEmpty()){
            return mostReviewed;
        }

        getItems().sort(Comparator.comparingInt(Item::getAmountOfReviews));

        Item mostReviewedITem = getItems().get(getItems().size()-1);
        if(mostReviewedITem.getAmountOfReviews()>0){
            for (Item item : getItems()) {
                if (item.getAmountOfReviews() == mostReviewedITem.getAmountOfReviews()) {
                    mostReviewed.add(item.getID());
                }
            }
        }
        return mostReviewed;
    }


    public String printBestReviewedItems(){
        StringBuilder sb = new StringBuilder();

        if(getItems().isEmpty()) {
            return "No items registered yet.";
        }

        double maxRating = 0.0;

        for(Item item:getItems()){
            if(maxRating<item.getMeanGrade()) {
                maxRating = item.getMeanGrade();
            }
        }

        if(maxRating == 0.0){
            return "No items were reviewed yet.";
        }
        else{
            sb.append("Items with best mean reviews:").append(ItemOptions.EOL);
            sb.append(String.format("Grade: %.1f" + ItemOptions.EOL, maxRating));
            for(Item item : getItems()) {
                if (item.getMeanGrade() == maxRating) {
                    sb.append(item).append(ItemOptions.EOL);

                }
            }
            return sb.toString();
        }
    }


    public String printWorstReviewedItems(){
        StringBuilder sb = new StringBuilder();

        if(getItems().isEmpty()) {
            return "No items registered yet.";
        }

        double minRating = 0.0;
        for(Item item : getItems()){
            if(item.getMeanGrade() > 0){
                minRating = item.getMeanGrade();
                break;
            }
        }

        for(Item item:getItems()){
            if(minRating > item.getMeanGrade() && item.getMeanGrade() > 0) {
                minRating = item.getMeanGrade();
            }
        }

        if(minRating == 0){
            return "No items were reviewed yet.";
        }
        else {
            sb.append("Items with worst mean reviews:").append(ItemOptions.EOL);
            sb.append(String.format("Grade: %.1f" + ItemOptions.EOL, minRating));
            for(Item item : getItems()) {
                if (item.getMeanGrade() == minRating) {
                    sb.append(item).append(ItemOptions.EOL);
                }
            }
            return sb.toString();
        }
    }


    public List<String> getBestReviewedItems(){
        List<String> bestReviewed = new ArrayList<>();

        if(getItems().isEmpty()){
            return bestReviewed;
        }

        double maxRating = 0.0;
        for(Item item:getItems()){
            if(maxRating<item.getMeanGrade()) {
                maxRating = item.getMeanGrade();
            }
        }

        for (Item item : getItems()) {
            if (item.getMeanGrade() == maxRating && (item.getAmountOfReviews() > 0)) {
                bestReviewed.add(item.getID());
            }
        }

        return bestReviewed;
    }


    public List<String> getWorstReviewed(){
        List<String> worstReviewed = new ArrayList<>();

        if (getItems().isEmpty()) {
            return worstReviewed;
        }

        double minRating = 0.0;
        for(Item item : getItems()){
            if(item.getMeanGrade() > 0){
                 minRating = item.getMeanGrade();
                 break;
            }
        }

        for(Item item:getItems()){
            if(minRating > item.getMeanGrade() && item.getMeanGrade() > 0) {
                minRating = item.getMeanGrade();
            }
        }

        for(Item item : getItems()) {
            if (item.getMeanGrade() == minRating && (item.getAmountOfReviews() > 0)) {
                worstReviewed.add(item.getID());
            }
        }

        return worstReviewed;
    }


    public String getItemTransactions(String itemID){
        StringBuilder sb = new StringBuilder();
        desiredItem = getItem(itemID);

        if(!items.contains(desiredItem)){
            return "Item " + itemID + " was not registered yet.";
        }

        sb.append("Transactions for item: " + desiredItem).append(ItemOptions.EOL);

        if(desiredItem.getTransactionHistory().isEmpty()){
            sb.append("No transactions have been registered for item " + itemID + " yet.");
        }
        else {
            for (Transaction entry : desiredItem.getTransactionHistory()) {
                sb.append(itemID).append(entry).append(ItemOptions.EOL);
            }
        } return sb.toString();
    }


    //getTotalTransactions = number of Transaction objects
    //getTotalUnitsSold = total added up number of single items bought, from all IDs
    //getTotalProfit

    public int getTotalTransactions(){
        int numTransactions = 0;

        for(Item item : getItems()){
            if(!item.getTransactionHistory().isEmpty()){
                numTransactions += item.getTransactionHistory().size();
            }
        }
        return numTransactions;
    }


    public int getTotalSoldUnits(){
        int numUnits = 0;

        for(Item item : getItems()){
            if(!item.getTransactionHistory().isEmpty()){
                numUnits += item.getUnitsSold();
            }
        }
        return numUnits;
    }


    public String printAllTransactions(){
        StringBuilder sb = new StringBuilder();

        sb.append("All purchases made: ").append(ItemOptions.EOL);
        sb.append(String.format("Total profit: %.2f SEK", getTotalProfit())).append(ItemOptions.EOL);
        sb.append(String.format("Total items sold: %d units", getTotalSoldUnits())).append(ItemOptions.EOL);
        sb.append(String.format("Total purchases made: %d transactions", getTotalTransactions())).append(ItemOptions.EOL);
        sb.append("------------------------------------").append(ItemOptions.EOL);

        boolean transactions = false;

        for (Item item : getItems()) {
            // add later to the menu.
            if(item.getTransactionHistory().size() > 0){
                transactions = true;
                for (Transaction entry : item.getTransactionHistory()) {
                    sb.append(item.getID());
                    sb.append(entry).append(ItemOptions.EOL);
                }
            }
        }

        sb.append("------------------------------------").append(ItemOptions.EOL);

        return sb.toString();
    }

    public double getTotalProfit(){
        int truncatingProfit;
        double profitMade = 0.0;

        for(Item item : getItems()){
            if(!item.getTransactionHistory().isEmpty()){
                profitMade += item.getItemProfit();
            }
        }

        truncatingProfit = (int) (profitMade * 100);
        profitMade = (double) truncatingProfit / 100;
        return profitMade;
    }
    //Change comparators to for loops to retain the order

    public String mostProfitableItems(){
        StringBuilder sb = new StringBuilder();

        if(getTotalTransactions() == 0) {
            return "No items registered yet.";
        }

        double mostProfitable = 0.0;

        for(Item item : getItems()){
            if(mostProfitable < item.getItemProfit()){
                mostProfitable = item.getItemProfit();
            }
        }

        //There is some item that is most profitable, having a price of 3998
        //in the second for loop, it finds which item is it that has that most profitable price
        if(mostProfitable == 0){
            return "No items were bought yet.";
        }

        else {
            sb.append("Most profitable items: ").append(ItemOptions.EOL);
            sb.append(String.format("Total profit: %.2f SEK" + ItemOptions.EOL, mostProfitable));
            for(Item item : getItems()) {
                if (item.getItemProfit() == mostProfitable) {
                    sb.append(item).append(ItemOptions.EOL);
                }
            }
            return sb.toString();
        }
    }
}

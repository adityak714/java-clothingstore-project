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
*/

/*
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
    public double buyItem (String itemID,int amount){
        final int DISCOUNT_THRESHOLD = 4;
        double itemsPrice;
        desiredItem = getItem(itemID);

        if (!(desiredItem.equals(empty))) {
           // (!(getItem(itemID) == null))
            double unitPrice = desiredItem.getPrice();

            if (amount <= DISCOUNT_THRESHOLD) {
                itemsPrice = (amount * unitPrice);
                return itemsPrice;
            }

            int extraItems = amount - DISCOUNT_THRESHOLD;
            itemsPrice = (DISCOUNT_THRESHOLD * unitPrice) + extraItems * (unitPrice * (0.7));
            DecimalFormat df = new DecimalFormat (" #.##");
            df.setRoundingMode(RoundingMode.FLOOR);
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
           review = new Review (reviewGrade);
           desiredItem.getReviews().add(review);
           return successfulRegistration;
       }

        return "Item " + desiredItem + " was not registered yet.";
    }

    public String CreateReview(String itemID, String reviewComment, int reviewGrade){

        // String itemID = Utilities.inputString("Enter the specific ID of the item: ");
        desiredItem = getItem(itemID);


        if (items.contains(desiredItem)){

            review = new Review(reviewComment, reviewGrade);
            desiredItem.getReviews().add(review);
            return successfulRegistration;
        }

    return "Item " + desiredItem + " was not registered yet.";
    }

    //3.2
    public String getPrintedItemReview(String itemID, int reviewNumber){

        String name = getItem(itemID).getName();
        ArrayList<Review> reviews = getItem(itemID).getReviews();
        boolean noReviews = getItem(itemID).getReviews().isEmpty();
        boolean hasItem = getItems().contains(getItem(itemID));

        // First if block to be converted as do while loop in the menu.
        if(reviewNumber < 1 || reviewNumber > reviews.size()){
            return "Invalid review number. Choose between 1 and " + reviews.size() + ". ";
        }
        if(!hasItem){
            return "Item " + itemID + " was not registered yet.";
        }

        if(noReviews){
            return "Item " + name + " has not been reviewed yet.";
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
            return "Item " + name + " has not been reviewed yet.";
        }

        for (Review review : getItem(itemID).getReviews()) {

            sb.append(String.format("Grade: %d.%s", review.getGrade(), review.getComment())).append(ItemOptions.EOL);
                /* sb.append(String.format("%s: %s. " + String.format("%.2f", i.getPrice()) + " SEK", i.getID(), i.getName()));
                sb.append(ItemOptions.EOL);*/
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

        for (Item item : getItems()) {
            // add later to the menu.
       /*     if(item.getReviews().isEmpty()){
                sb.append("No items were reviewed yet.").append(ItemOptions.EOL);
                sb.append("------------------------------------").append(ItemOptions.EOL);
            }*/
            if (!item.getReviews().isEmpty()) {
                sb.append(String.format("Review(s) for %s: %s. %.2f SEK" + ItemOptions.EOL, item.getID(), item.getName(), item.getPrice()));
                for (Review review : getItem(item.getID()).getReviews()) {
                    sb.append(String.format("Grade: %d.%s", review.getGrade(), review.getComment())).append(ItemOptions.EOL);
                }
                sb.append("------------------------------------").append(ItemOptions.EOL);
            }
        }
        return sb.toString();
    }

    //3.7

    public String printMostReviewedItems() {
        StringBuilder sb = new StringBuilder();

        if(getItems().isEmpty()){
            return "No items registered yet.";
        }

        getItems().sort(Comparator.comparingInt(Item::getAmountOfReviews));
        Item mostAmountOfReviews = getItems().get(getItems().size() - 1);
        sb.append(String.format("Most reviews: %d review(s) each.", mostAmountOfReviews.getAmountOfReviews())).append(ItemOptions.EOL);

        for(Item item : getItems()){
            if(item.getAmountOfReviews() == mostAmountOfReviews.getAmountOfReviews()){
                sb.append(printItem(item.getID())).append(ItemOptions.EOL);
            }
        }

        return sb.toString();
    }

    //to be discussed with greg, copying items from previous list into this list

    public String printLeastReviewedItems() {
        StringBuilder sb = new StringBuilder();

        if(getItems().isEmpty()){
            return "No items registered yet.";
        }

        getItems().sort(Comparator.comparingInt(Item::getAmountOfReviews));

        Item leastAmountOfReviews = getItems().get(0);
        sb.append(String.format("Least reviews: %d review(s) each." + ItemOptions.EOL, leastAmountOfReviews.getAmountOfReviews()));

        for(Item item : getItems()) {
            System.out.println(getItems().toString());

            if(item.getAmountOfReviews() > 0 /*&&*/){
                sb.append(item);
                sb.append(ItemOptions.EOL);
            }
        }

        return sb.toString();
    }
}
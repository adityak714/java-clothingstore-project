package non_businesslogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
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


    public Item getReviews(String itemID){
        if(items.contains(desiredItem)){
        return getReviews(itemID);
        }
      return null;
    }





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

    /*  public static char QuitOrProceed() {

        char quitOrProceedInput = UserInput.inputChar("Press 'q' to quit to the previous menu. If you wish to proceed, press 'p'. ");
        if (quitOrProceedInput == 'q') {
            Menu.printMenu();
        }
        return quitOrProceedInput;
    }*/

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
//3.4
    public double getMeanItem(String itemID){
        double sum = 0.0;
        double truncatedResult;


        Item item = getItem(itemID);
        List<Review> reviews = item.getReviews();
        //Item review = getReviews(itemID);
        if(reviews.isEmpty()){
            return sum;
        }
        for (Review review : reviews) {
            sum += review.getGrade();
        }


        sum /= reviews.size();
        double scale = (int) Math.pow(10, 1);
        truncatedResult = (int) (sum * scale);
        return truncatedResult / scale;



    }



}
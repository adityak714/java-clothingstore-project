package non_businesslogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private Item desiredItem;

    public Item getItem(String itemID) {
        for (Item item : items) {
            if (Objects.equals(item.getID(), itemID)) {
               // (items.contains(getItem(itemID)))
               return item;
            }
        }
       return empty;
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
        //QuitOrProceed
    }

    //EF 2.3
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

        //String itemID = Utilities.inputString("Enter the ID of the item to update the name: ");

        if(items.contains(desiredItem)) {

            //String newName = Utilities.inputString("Enter the new name for the item: ");

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

/*    public static char QuitOrProceed() {

        char quitOrProceedInput = UserInput.inputChar("Press 'q' to quit to the previous menu. If you wish to proceed, press 'p'. ");
        if (quitOrProceedInput == 'q') {
            Menu.printMenu();
        }
        return quitOrProceedInput;
    }*/

    //2.4
    public double buyItem (String itemID,int amount){

       // String itemId = Utilities.inputString("Enter the specific ID for the item you are buying: ");
       // amount = Utilities.inputInt("Enter the number of items:  ");
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


    // 2.5
    public String removeItem (String itemID){
       // String itemId = Utilities.inputString("Enter the specific ID for the item to be removed: ");
        desiredItem = getItem(itemID);

        if (items.contains(desiredItem)) {
            items.remove(desiredItem);
            return ("Item " + itemID + " was successfully removed.");

        }
            return ("Item " + itemID + " could not be removed.");
    }

    //2.6 - Printing the overview of one single item given its ID
    public String printItem(String itemID) {
        desiredItem = getItem(itemID);

        String name = desiredItem.getName();
        double price = desiredItem.getPrice();

        if (!(items.contains(desiredItem)) || desiredItem.equals(empty)) {
            return("Item " + itemID + " was not registered yet.");
        }

        return String.format("%s: %s. " + String.format("%.2f", price) + " SEK", itemID, name);
    }

    //2.7 - Printing the entire list of items that are registered
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
}
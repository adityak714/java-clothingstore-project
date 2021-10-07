package non_businesslogic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Utilities;

public class ItemController {

    //ATTRIBUTES
    private List<Item> items;
    public List<Item> getItems() {
        return this.items;
    }

    public ItemController() {
        items = new ArrayList<>();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Item getItem(String itemID) {
        for (Item item : items) {
            if (item.getID().equals(itemID)) {
                return item;
            }
        }
        return null;
    }

    public void setItem(ArrayList<Item> items) {
        this.items = items;
    }

    //EF 2.1 -- I want to create items in my system so that I can sell them in my system.
    public boolean CreatingItem(String id, String name, double price) {

        // id = UserInput.inputString(Menu.EOL + "Type an ID number for the new item(4 digits): ");
        // name = UserInput.inputString("Create a name for the new item: ");
        // price = UserInput.inputDouble("Enter a price for the new item: ");

        //2.2 I want to avoid the creation of items with invalid data
        //    so that I only have reliable data in my system.

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

        //String itemID = Utilities.inputString("Enter the ID of the item to update the name: ");

        if(items.contains(getItem(itemID))) {

            //String newName = Utilities.inputString("Enter the new name for the item: ");

            if(newName.isEmpty()){
                return "Invalid data for item.";
            }
            else {
                getItem(itemID).setName(newName);
            }
        }
        else {
            return ("Item " + itemID + " was not registered yet.");
        }

        return "Item " + getItem(itemID).getID() + " was updated successfully.";
    }



    public String updatingPrice(String itemID, double newPrice){

        //String itemID = Utilities.inputString("Enter the ID of the item to update the name: ");

        if(items.contains(getItem(itemID))) {

            //String newName = Utilities.inputString("Enter the new name for the item: ");

            if(newPrice <= 0){
                return "Invalid data for item.";
            }
            else {
                getItem(itemID).setPrice(newPrice);
            }
        }
        else {
            return ("Item " + itemID + " was not registered yet.");
        }

        return "Item " + getItem(itemID).getID() + " was updated successfully.";
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
            double itemsPrice = 0.0;

            if (!(getItem(itemID) == null)) {

                double unitPrice = getItem(itemID).getPrice();

                if (amount <= DISCOUNT_THRESHOLD) {
                    itemsPrice = (amount * unitPrice);


                }
                if (amount > DISCOUNT_THRESHOLD) {
                    int extraItems = amount - DISCOUNT_THRESHOLD;
                    itemsPrice = (4 * unitPrice) + extraItems * (unitPrice * (0.7));
                }

            } else {
                return -1.0;

            }
            DecimalFormat df = new DecimalFormat (" #.##");
            df.setRoundingMode(RoundingMode.FLOOR);
            return Double.parseDouble(df.format(itemsPrice));
        }


       // 2.5
        public String removeItem (String itemID){
           // String itemId = Utilities.inputString("Enter the specific ID for the item to be removed: ");

            if (items.contains(getItem(itemID))) {
                items.remove(getItem(itemID));
                return ("Item " + itemID + " was successfully removed.");

            }
                return ("Item " + itemID + " could not be removed.");
        }

        //EF 2.6 - Printing the overview of one single item given its ID
        public String printItem(String id) {
            String name = getItem(id).getName();
            double price = getItem(id).getPrice();

            if (getItem(id) == null) {
                return("Item" + id + " was not registered yet.");
            }

            return String.format("%s: %s. " + String.format("%.2f", price) + " SEK", id, name);
        }

        //2.7 - Printing the entire list of items that are registered
        public String printItems () {
            StringBuilder sb = new StringBuilder();
            sb.append("All registered items:").append(Menu.EOL);

            for (Item i : getItems()) {
                sb.append(String.format("%s: %s. " + String.format("%.2f", i.getPrice()) + " SEK", i.getID(), i.getName()));
                sb.append(Menu.EOL);
            }

            return sb.toString();
        }
}
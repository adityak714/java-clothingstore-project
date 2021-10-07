package non_businesslogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemController {

    //ATTRIBUTES
    private List<Item> items;
    Item item;
    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Item getItem(String itemID) {
        for (Item item : getItems()) {
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
        getItems().add(item);
        return true;
        //QuitOrProceed
    }

/*    public static char QuitOrProceed() {

        char quitOrProceedInput = UserInput.inputChar("Press 'q' to quit to the previous menu. If you wish to proceed, press 'p'. ");
        if (quitOrProceedInput == 'q') {
            Menu.printMenu();
        }
        return quitOrProceedInput;
    }*/

        //2.4

        public double buyItem (String itemID,int itemsAmount){

            String itemId = Utilities.inputString("Enter the specific ID for the item you are buying: ");
            itemsAmount = Utilities.inputInt("Enter the number of items:  ");
            final int DISCOUNT_THRESHOLD = 4;

            if (item.getID().contains(itemId)) {
                double unitPrice = item.getPrice();

                if (itemsAmount <= DISCOUNT_THRESHOLD) {
                    double itemsPrice = (itemsAmount * unitPrice);


                }
                if (itemsAmount > DISCOUNT_THRESHOLD) {
                    int extraItems = itemsAmount - DISCOUNT_THRESHOLD;
                    double itemsPrice = (4 * unitPrice) + extraItems * (unitPrice * (1.0 - 0.3));
                    return itemsPrice;
                }

            } else {
                System.out.println("-1");

            }
            return 0.0;
        }


        //2.5
        public void removeItem (String itemID){
            String itemId = Utilities.inputString("Enter the specific ID for the item to be removed: ");

            if (items.contains(itemId)) {
                items.remove(itemId);
                System.out.println("Item " + itemId + " was successfully removed.");


            } else {
                System.out.println("Item " + itemId + " could not be removed.");
            }
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
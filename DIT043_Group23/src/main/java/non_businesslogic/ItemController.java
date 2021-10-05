package non_businesslogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemController {

    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems(){ return this.items; }

    public void setItem(ArrayList<Item> items){ this.items = items; }

    Item item;

    //EF 2.1 I want to create items in my system
    // so that I can sell them in my system.

    public boolean CreatingItem() {

        String id = UserInput.inputString("\nType an ID number for the new item(4 digits): ");
        String name = UserInput.inputString("Create a name for the new item: ");
        double price = UserInput.inputDouble("Enter a price for the new item: ");

            //2.2 I want to avoid the creation of items with invalid data
            // so that I only have reliable data in my system.

        if(id.isEmpty() || name.isEmpty() || price <= 0){
            System.out.println("Invalid data for item.");
            System.out.print("Item cannot be created");
            return false;
        }

        Item item =  new Item(id, name, price);
        items.add(item);
        System.out.println("Item is created.");

        return true;
        //QuitOrProceed();
    }

/*    public static char QuitOrProceed() {

        char quitOrProceedInput = UserInput.inputChar("Press 'q' to quit to the previous menu. If you wish to proceed, press 'p'. ");
        if (quitOrProceedInput == 'q') {
            Menu.printMenu();
        }
        return quitOrProceedInput;
    }*/

      //2.4
      //2.5


    //2.6
/*
101 Blue T-shirt 500kr
102 Yellow T-shirt 600kr

printItem(101)
*/

    public String printItem(String itemID) {
        double price = 0;
        String name = "";

        do {
            if (item.getID().contains(itemID)) {
                price = item.getPrice();
                name = item.getName();

                DecimalFormat truncate = new DecimalFormat("#.##");
                truncate.setRoundingMode(RoundingMode.DOWN);
                price = Double.parseDouble(truncate.format(price));

                // TA
                // Is this method of printing a single particular item workable?

            } else {
                System.out.println("Item" + itemID + " was not registered yet.");
            }
        } while (items.contains(itemID));

        return String.format(" %s: %s. " + price + " SEK ", itemID, name);
    }

    //2.7
    public String printAllItems() {
        String fullItemsList = "All registered items. " + Menu.EOL;
        String eachItem = String.format(" %s: %s. " + item.getPrice() + " SEK ", item.getID(), item.getName());
        return fullItemsList + eachItem.repeat(items.size());
    }
}


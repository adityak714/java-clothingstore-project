package non_businesslogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//CLASS
public class ItemController {

    //ATTRIBUTES
    private List<Item> items;
    public List<Item> getItems(){ return this.items; }
    public void setItems(ArrayList<Item> items){ this.items = items; }
    Item item;

    //CONSTRUCTOR
    public ItemController() {
        items = new ArrayList<>();
    }

    //METHODS
    public Item getItem(String itemID) {

        for (Item items : getItems()) {
            if (item.getID().contains(itemID)) {
                return items;
            }
        }
        return null;
    }

    //EF 2.1 -- I want to create items in my system so that I can sell them in my system.
    public boolean CreatingItem() {

        String id = UserInput.inputString(Menu.EOL + "Type an ID number for the new item(4 digits): ");
        String name = UserInput.inputString("Create a name for the new item: ");
        double price = UserInput.inputDouble("Enter a price for the new item: ");

            //2.2 I want to avoid the creation of items with invalid data
            // so that I only have reliable data in my system.
        Item item =  new Item(id, name, price);

        if(id.isEmpty() || name.isEmpty() || price <= 0 || items.contains(item)){
            System.out.println("Invalid data for item.");
            System.out.print("Item cannot be created");
            return false;
        }

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

    //EF 2.4
    //EF 2.5


    //EF 2.6 - Printing the overview of one single item given its ID
    public String printItem(String itemID) {
        double price = 0;
        String name = "";

        if (item.getID().contains(itemID)) {
            price = getItem(itemID).getPrice();

            DecimalFormat truncate = new DecimalFormat("#.##");
            truncate.setRoundingMode(RoundingMode.DOWN);
            price = Double.parseDouble(truncate.format(price));

        } else {
            System.out.println("Item" + itemID + " was not registered yet.");
            }

        return String.format(" %s: %s. " + price + " SEK ", itemID, name);
    }

    //2.7 - Printing the entire list of items that are registered
    public String printAllItems() {
        String fullItemsList = "All registered items. " + Menu.EOL;
        String eachItem = String.format(" %s: %s. " + item.getPrice() + " SEK ", item.getID(), item.getName());
        return fullItemsList + eachItem.repeat(items.size());
    }
}


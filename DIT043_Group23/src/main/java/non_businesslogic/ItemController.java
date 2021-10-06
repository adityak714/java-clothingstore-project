package non_businesslogic;

import java.util.ArrayList;
import java.util.List;

//CLASS
public class ItemController {

    //ATTRIBUTES
    private List<Item> items;
    public List<Item> getItems(){ return this.items; }
    public void setItems(ArrayList<Item> items){ this.items = items; }

    //CONSTRUCTOR
    public ItemController() {
        items = new ArrayList<>();
    }

    //METHODS
    public Item getItem(String itemID) {

        for (Item item : getItems()) {
            if (item.getID().equals(itemID)) {
                return item;
            }
        }
        return null;
    }

    //EF 2.1 -- I want to create items in my system so that I can sell them in my system.
    public boolean CreatingItem(String id, String name, double price) {

        // id = UserInput.inputString(Menu.EOL + "Type an ID number for the new item(4 digits): ");
        // name = UserInput.inputString("Create a name for the new item: ");
        // price = UserInput.inputDouble("Enter a price for the new item: ");

        //2.2 I want to avoid the creation of items with invalid data
        //    so that I only have reliable data in my system.

        if(id.isEmpty() || name.isEmpty() || price <= 0) {
            return false;
        }

        Item item = new Item(id, name, price);
        getItems().add(item);
        //QuitOrProceed();
        return true;
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

    //2.7 - Printing the entire list of items that are registered
    public String printItems() {

        StringBuilder sb = new StringBuilder();
        sb.append("All registered items:").append(Menu.EOL);

        for (Item i : getItems()) {
            sb.append(String.format("%s: %s. " + String.format("%.2f", i.getPrice()) + " SEK", i.getID(), i.getName()));
            sb.append(Menu.EOL);
        }
        return sb.toString();
    }

    public String printItem(String id) {
        String name = getItem(id).getName();
        double price = getItem(id).getPrice();

        if (getItem(id) == null) {
            return("Item" + id + " was not registered yet.");
        }

        return String.format("%s: %s. " + String.format("%.2f", price) + " SEK", id, name);
    }
}


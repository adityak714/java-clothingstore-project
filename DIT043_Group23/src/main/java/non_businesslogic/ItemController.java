package non_businesslogic;


import java.util.ArrayList;

public class ItemController {



private ArrayList<Item> items;

public ItemController(ArrayList<Item>items){
    
    items = new ArrayList<Item>(); 

}

public ArrayList<Item> getItems(){ return this.items; }

public void setItem(ArrayList<Item> items){ this.items = items; }


//EF 2.1 I want to create items in my system 
// so that I can sell them in my system.


/*public static boolean CreatingItem() {

         
    //Taking input from a user
    String id = UserInput.inputString("\nType an ID number for the new item(4 digits): ");
    String name = UserInput.inputString("Create a name for the new item: ");
    double price = UserInput.inputDouble("Enter a price for the new item: ");
    
        //2.2 I want to avoid the creation of items with invalid data 
        // so that I only have reliable data in my system.
        if(id.isEmpty() || name.isEmpty() || price <= 0){
    
            System.out.println("Invalid data for item.");
            return false;
        }
    
        for(int i = 0; i < items.size(); i++){
            //if(items[i] == null){
                ///Item item =  new Item(id, name, price);
                //allItems.add(item);
                //System.out.println("Item is created. ");
                
                //return true;
     
            }
        }
        //System.out.print("Item cannot be created");
        return false;
        //QuitOrProceed();
    
        
        }
    
    public static char QuitOrProceed(){
       
        char quitOrProceedInput = UserInput.inputChar("Press 'q' to quit to the previous menu. If you wish to proceed, press 'p'. ");
        if(quitOrProceedInput == 'q'){
            Menu.printMenu();
        }
        return quitOrProceedInput;
        
  
    
  */

  //2.4
  //2.5
 

//2.6
public String printItem(String itemID) {
    double price = 0;
    String name = "";

    
    do {
        if () {
            price = Item.getPrice();
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
    return "";
}

//2.7
public String printAllItems() {
    String fullItemsList = "All registered items. " + Menu.EOL;
    String eachItem = String.format(" %s: %s. " + CreateItem.Create().getPrice() + " SEK ",
            CreateItem.Create().getID(), CreateItem.Create().getName());

    return fullItemsList + eachItem.repeat(ids.size());
  
}








  
}


package non_businesslogic;

import java.util.ArrayList;

import facade.Facade;

public class CreateItem {


    private final String id;
    private String name;
    private double price;

    private static ArrayList <CreateItem> allItems = new ArrayList<CreateItem>();



    public CreateItem (String id, String name, double price) {
    //pointing to the declared attributes in the class.
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getID(){
        return id;
}

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String setName(String newName){
    
        this.name = newName;
        return newName;
    }
    
    public double setPrice(double newPrice){
        
        this.price = newPrice;
        return newPrice;
    }



//EF 2.1 I want to create items in my system 
// so that I can sell them in my system.
    public static boolean CreatingItem() {

         
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

    for(int i = 0; i < allItems.size(); i++){
        if(allItems == null){
            CreateItem item =  new CreateItem(id, name, price);
            allItems.add(item);
            System.out.println("Item is created. ");
            
            return true;
 
        }
    }
    System.out.print("Item cannot be created");
    return false;
    //QuitOrProceed();

    
    }

public static char QuitOrProceed(){
   
    char quitOrProceedInput = UserInput.inputChar("Press 'q' to quit to the previous menu. If you wish to proceed, press 'p'. ");
    if(quitOrProceedInput == 'q'){
        Menu.printMenu();
    }
    return quitOrProceedInput;
    
    
    }
    

}

    




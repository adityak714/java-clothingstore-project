package ItemOptions;
public class CreateItem {

/*I want to create items in my system so that I can sell them in my system.

Each item has an identified (ID), name and a price per unit value.
Once created, the ID of an item cannot change and two items cannot have the same ID. 
The creation of items is prompted in the “Items options” menu. 
In order to create an item, the user must input: (i) the item ID, (ii) the item name and (iii) the item price.

When the item is created successfully, the system should print the message: "Item <ID> was registered successfully."*/

final String id;
String name;
double price; 


public CreateItem (int id, String name, double price) {
    //pointing to the declared attributes in the class.
    this.id = id;
    this.name = name;
    this.price = price;

}

public int getID(){
   
    return id;

}

public String getName(){

    return name;

}
public double getPrice(){

    return price;

}


//Creating a behaivour method for creating an item.
public static CreateItem Create() {

    int id = UserInput.inputInt("Type an ID number for the new item(4 digits): ");
    //store the input value in storeID array.

    String name = UserInput.inputString("Create a name for the new item: ");
    //store the input value in storeName array.

    double price = UserInput.inputDouble("Enter a price for the new item: ");
    //store the input value in storePrice array.

    System.out.print("\nItem " + id + " was registered successfully.\n");

    CreateItem item = new CreateItem(id, name, price);
    return item;

}






}


    


/*int playlistSize = UserInput.readInt("How many songs?");
Song[] playlist = new Song[playlistSize];
    for (i = 0; i < playlistSize; i++){
        playlist[i] = createSong();
        playlist[i].Play(); 
*/

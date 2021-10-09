package non_businesslogic;


import java.util.ArrayList;

public class Item {

    private final String id;
    private String name;
    private double price;
    ArrayList<Review> reviewsList = new ArrayList<>();

    public Item (String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    //Get the id, name, price, but only name and price can be changed.
    public String getID(){ return id; }

    public String getName(){ return name; } 

    public double getPrice(){ return price; }

    public void setName(String newName) { this.name = newName; }
    
    public void setPrice(double newPrice){ this.price = newPrice; }

}
    



    




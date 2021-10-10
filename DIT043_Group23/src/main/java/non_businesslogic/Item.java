package non_businesslogic;


import java.util.ArrayList;
import java.util.Objects;

public class Item {

    private final String id;
    private String name;
    private double price;
    private ArrayList<Review> reviewsList;

    public Item (String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reviewsList = new ArrayList<>();

    }

    //Get the id, name, price, but only name and price can be changed.
    public String getID(){ return id; }

    public String getName(){ return name; } 

    public double getPrice(){ return price; }

    public ArrayList<Review> getReviews(){ return reviewsList; }




    public void setName(String newName) { this.name = newName; }
    
    public void setPrice(double newPrice){ this.price = newPrice; }

}
    



    




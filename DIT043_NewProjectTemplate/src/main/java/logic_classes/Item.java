package logic_classes;


import java.util.ArrayList;

public class Item {

    private final String id;
    private String name;
    private double price;
    private final ArrayList<Review> reviewsList;
    private final ArrayList<Transaction> transactions;

    public Item (String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reviewsList = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    //Get the id, name, price, but only name and price can be changed.
    public String getID(){ return id; }

    public String getName(){ return name; } 

    public double getPrice(){ return price; }

    public ArrayList<Review> getReviews(){ return reviewsList; }

    public ArrayList<Transaction> getTransactionHistory(){return transactions;}

    public int getAmountOfReviews(){return getReviews().size();}

   public double getMeanGrade(){
       double sum = 0.0;
       double reviewMean;
       int truncatingResult;
       double truncatedResult;

       //Item review = getReviews(itemID);
       if(reviewsList.isEmpty()){
           return sum;
       }
       for (Review grade : reviewsList) {
           sum += grade.getGrade();
       }

       reviewMean = sum / reviewsList.size();
       truncatingResult = (int)(reviewMean * 10);
       truncatedResult = (double) truncatingResult / 10;

       return truncatedResult;
    }

    public boolean hasSameID(String anotherID){ return this.id.equals(anotherID); }

    public void setName(String newName) { this.name = newName; }
    
    public void setPrice(double newPrice){ this.price = newPrice; }

    public int getUnitsSold(){
        int totalUnits = 0;

        for(Transaction entry : transactions){
            totalUnits += entry.getAmountBought();
        }

        return totalUnits;
    }

    public double getItemProfit(){
        int truncatingProfit;
        double profit = 0.0;

        for(Transaction entry : transactions){
            profit += entry.getTotalPrice();
        }

        truncatingProfit = (int) (profit * 100);
        profit = (double) truncatingProfit / 100;
        return profit;
    }

    @Override
    public String toString() {
        return String.format("%s: %s. %.2f SEK", id, name, getPrice());
    }
}
    



    




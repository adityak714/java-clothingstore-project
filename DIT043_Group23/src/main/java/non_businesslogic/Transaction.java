package non_businesslogic;

public class Transaction {
    private final String id;
    private final int amountBought;
    private final double totalPrice;
    ItemController itemController = new ItemController();

    public Transaction(String id, int amountBought, double totalPrice){
        this.id = itemController.getItem(id).getID();
        this.amountBought = amountBought;
        this.totalPrice = totalPrice;

    }

    public String toString(){
        return String.format("%s: %d item(s). %.2f SEK", id, amountBought, totalPrice);
    }

    public String getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getAmountBought() {
        return amountBought;
    }
}

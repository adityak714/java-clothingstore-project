package facade;

import non_businesslogic.ItemController;

import java.util.List;
import java.util.Map;

public class Facade {

    private final ItemController ITEMCONTROLLER = new ItemController();

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public Facade(){

    }

    public String createItem(String itemID, String itemName, double unitPrice){
        if (ITEMCONTROLLER.CreatingItem(itemID, itemName, unitPrice)) {
            return ("Item " + itemID + " was registered successfully.");
        }

        return ("Invalid data for item.");
    }

    public String printItem(String itemID) {
        return ITEMCONTROLLER.printItem(itemID);
    }

    public String removeItem(String itemID) {
        return ITEMCONTROLLER.removeItem(itemID);
    }

    public boolean containsItem(String itemID) {
        return false;
    }

    public double buyItem(String itemID, int amount) {
        return ITEMCONTROLLER.buyItem(itemID, amount);
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        return ITEMCONTROLLER.CreateReview(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return ITEMCONTROLLER.CreateReview(itemID, reviewGrade);
    }

    public String getItemCommentsPrinted(String itemID) {
        return "";
    }

    public List<String> getItemComments(String itemID) {
        return ITEMCONTROLLER.getActualComments(itemID);
    }

    public double getItemMeanGrade(String itemID) {
        return ITEMCONTROLLER.getMeanItem(itemID);
    }

    public int getNumberOfReviews(String itemID) {
        return ITEMCONTROLLER.getItem(itemID).getAmountOfReviews();
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        return ITEMCONTROLLER.getPrintedItemReview(itemID, reviewNumber);
    }

    public String getPrintedReviews(String itemID) {
        return ITEMCONTROLLER.printReviews(itemID);
    }

    public String printMostReviewedItems() {
        return ITEMCONTROLLER.printMostReviewedItems();
    }

    public List<String> getMostReviewedItems() {
        return ITEMCONTROLLER.getMostReviewedItems();
    }

    public List<String> getLeastReviewedItems() {
        return ITEMCONTROLLER.getLeastReviewedItems();
    }

    public String printLeastReviewedItems() {
        return ITEMCONTROLLER.printLeastReviewedItems();
    }

    public double getTotalProfit() {
        return ITEMCONTROLLER.getTotalProfit();
    }

    public String printItemTransactions(String itemID) {
        return ITEMCONTROLLER.getItemTransactions(itemID);
    }

    public int getTotalUnitsSold() {
        return ITEMCONTROLLER.getTotalSoldUnits();
    }

    public int getTotalTransactions() {
        return ITEMCONTROLLER.getTotalTransactions();
    }

    public double getProfit(String itemID) {
        return ITEMCONTROLLER.getItem(itemID).getItemProfit();
    }

    public int getUnitsSolds(String itemID) {
        return ITEMCONTROLLER.getItem(itemID).getUnitsSold();
    }

    public String printAllTransactions() {
        return ITEMCONTROLLER.printAllTransactions();
    }

    public String printWorseReviewedItems() {
        return ITEMCONTROLLER.printWorstReviewedItems();
    }

    public String printBestReviewedItems() {
        return ITEMCONTROLLER.printBestReviewedItems();
    }

    public List<String> getWorseReviewedItems() {
        return ITEMCONTROLLER.getWorstReviewed();
    }

    public List<String> getBestReviewedItems() {
        return ITEMCONTROLLER.getBestReviewedItems();
    }

    public String printAllReviews() {
        return ITEMCONTROLLER.printAllReviews();
    }

    public String updateItemName(String itemID, String newName) {
        return ITEMCONTROLLER.updatingName(itemID, newName);
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return ITEMCONTROLLER.updatingPrice(itemID, newPrice);
    }

    public String printAllItems() {
        return ITEMCONTROLLER.printItems();
    }

    public String printMostProfitableItems() {
        return ITEMCONTROLLER.mostProfitableItems();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        return "";
    }

    public String printEmployee(String employeeID) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return "";
    }

    public double getNetSalary(String employeeID) throws Exception {
        return -1.0;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        return "";
    }

    public String removeEmployee(String empID) throws Exception {
        return "";
    }

    public String printAllEmployees() throws Exception {
        return "";
    }

    public double getTotalNetSalary() throws Exception {
        return -1.0;
    }

    public String printSortedEmployees() throws Exception {
        return "";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        return "";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        return "";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        return "";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        return "";
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        return "";
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        return "";

    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return "";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return "";
    }
}

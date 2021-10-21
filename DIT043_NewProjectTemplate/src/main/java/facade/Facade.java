package facade;

import non_businesslogic.EmployeeController;
import non_businesslogic.ItemController;

import java.util.List;
import java.util.Map;

public class Facade {

    private final ItemController ITEMCONTROLLER = new ItemController();

    private final EmployeeController EMPLOYEECONTROLLER = new EmployeeController();

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
        EMPLOYEECONTROLLER.createEmployee(employeeID, employeeName, grossSalary);

        if(employeeID.isEmpty()){
            throw new Exception("ID cannot be blank.");
        }
        if(employeeName.isEmpty()){
            throw new Exception("Name cannot be blank.");
        }
        if(grossSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }

        return "Employee " + employeeID + " was registered successfully.";
        // need to create conditional line of code in case employee creation unsuccessful
    }

    public String printEmployee(String employeeID) throws Exception {
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(employeeID))){
            throw new Exception("Employee " + employeeID + " was not registered yet.");
        }

        return EMPLOYEECONTROLLER.getEmployee(employeeID).toString();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        if(EMPLOYEECONTROLLER.createManager(employeeID, employeeName, degree, grossSalary)){
            return "Employee " + employeeID + " was registered successfully.";
        }
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        if(EMPLOYEECONTROLLER.createIntern(employeeID, employeeName, grossSalary, gpa)){
            return "Employee " + employeeID + " was registered successfully.";
        }
        return "";
    }

    public double getNetSalary(String employeeID) throws Exception {
        return EMPLOYEECONTROLLER.getEmployee(employeeID).getNetSalary();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        if(EMPLOYEECONTROLLER.createDirector(employeeID, employeeName, grossSalary, degree, dept)){
            return "Employee " + employeeID + " was registered successfully.";
        }
        return ""; // Exception
    }

    public String removeEmployee(String empID) throws Exception {
        return EMPLOYEECONTROLLER.removeEmployee(empID);
    }

    public String printAllEmployees() throws Exception {
        return EMPLOYEECONTROLLER.printAllEmployees();
    }

    public double getTotalNetSalary() throws Exception {
        return EMPLOYEECONTROLLER.totalNetSalary();
    }

    public String printSortedEmployees() throws Exception {
        return EMPLOYEECONTROLLER.sortEmployeesByGrossSalary();
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        if(EMPLOYEECONTROLLER.changeEmployeeName(empID, newName)){
            return "Employee " + empID + " was updated successfully";
        }

        return "Employee could not be updated."; //Exception
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        if(EMPLOYEECONTROLLER.changeInternGPA(empID, newGPA)){
            return "Employee " + empID + " was updated successfully";
        }

        return "Employee could not be updated."; //Exception
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        if(EMPLOYEECONTROLLER.changeManagerDegree(empID, newDegree)){
            return "Employee " + empID + " was updated successfully";
        }

        return "Employee could not be updated."; //Exception
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        if(EMPLOYEECONTROLLER.changeDirectorDept(empID, newDepartment)){
            return "Employee " + empID + " was updated successfully";
        }

        return "Employee could not be updated."; //Exception
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        if(EMPLOYEECONTROLLER.changeGrossSalary(empID, newSalary)){
            return "Employee " + empID + " was updated successfully";
        }

        return "Employee could not be updated."; //Exceptions
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return EMPLOYEECONTROLLER.mapDegreeToEmployee();
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        if(EMPLOYEECONTROLLER.promoteToManager(empID, degree)){
            return (empID + " promoted successfully to Manager.");
        }

        return "Employee could not be promoted. "; //Exceptions
    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        if(EMPLOYEECONTROLLER.promoteToDirector(empID, degree, department)) {
            return (empID + " promoted successfully to Director.");
        }

        return "Employee could not be promoted."; //Exceptions
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        if(EMPLOYEECONTROLLER.promoteToIntern(empID, gpa)) {
            return (empID + " promoted successfully to Intern.");
        }

        return "Employee could not be promoted."; //Exceptions
    }
}

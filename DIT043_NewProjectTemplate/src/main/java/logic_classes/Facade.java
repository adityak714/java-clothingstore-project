package logic_classes;

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
        if(employeeID.isBlank()){
            throw new Exception("ID cannot be blank.");
        }
        if(employeeName.isBlank()){
            throw new Exception("Name cannot be blank.");
        }
        if(grossSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }

        EMPLOYEECONTROLLER.createEmployee(employeeID, employeeName, grossSalary);

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
        if(employeeID.isBlank()){
            throw new Exception("ID cannot be blank.");
        }
        if(employeeName.isBlank()){
            throw new Exception("Name cannot be blank.");
        }
        if(grossSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }
        if(!degree.equals("BSc") && !degree.equals("MSc") && !degree.equals("PhD")){
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }

        EMPLOYEECONTROLLER.createManager(employeeID, employeeName, degree, grossSalary);
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        if(employeeID.isBlank()){
            throw new Exception("ID cannot be blank.");
        }
        if(employeeName.isBlank()){
            throw new Exception("Name cannot be blank.");
        }
        if(grossSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }
        if(gpa < 0 || gpa > 10){
            throw new Exception(gpa + " outside range. Must be between 0-10.");
        }

        if(EMPLOYEECONTROLLER.createIntern(employeeID, employeeName, grossSalary, gpa)){
            return "Employee " + employeeID + " was registered successfully.";
        }
        return "";
    }

    public double getNetSalary(String employeeID) throws Exception {
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(employeeID))){
            throw new Exception("Employee " + employeeID + " was not registered yet.");
        }

        return EMPLOYEECONTROLLER.getEmployee(employeeID).getNetSalary();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        if(employeeID.isBlank()){
            throw new Exception("ID cannot be blank.");
        }
        if(employeeName.isBlank()){
            throw new Exception("Name cannot be blank.");
        }
        if(grossSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }
        if(!degree.equals("BSc") && !degree.equals("MSc") && !degree.equals("PhD") && degree.isBlank()){
            throw new Exception("Degree must be one of the options: PhD, MSc or PhD.");
        }
        if(!dept.equals("Business") && !dept.equals("Human Resources") && !dept.equals("Technical") && dept.isBlank()){
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }

        if(EMPLOYEECONTROLLER.createDirector(employeeID, employeeName, grossSalary, degree, dept)){
            return "Employee " + employeeID + " was registered successfully.";
        }
        return ""; // Exception
    }

    public String removeEmployee(String empID) throws Exception {
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }

        return EMPLOYEECONTROLLER.removeEmployee(empID);
    }

    public String printAllEmployees() throws Exception {
        if(EMPLOYEECONTROLLER.getEmployees().isEmpty()){
            throw new Exception("No employees registered yet.");
        }

        return EMPLOYEECONTROLLER.printAllEmployees();
    }

    public double getTotalNetSalary() throws Exception {
        if(EMPLOYEECONTROLLER.getEmployees().isEmpty()){
            throw new Exception("No employees registered yet.");
        }

        return EMPLOYEECONTROLLER.totalNetSalary();
    }

    public String printSortedEmployees() throws Exception {
        if(EMPLOYEECONTROLLER.getEmployees().isEmpty()){
            throw new Exception("No employees registered yet.");
        }

        return EMPLOYEECONTROLLER.sortEmployeesByGrossSalary();
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        if(newName.isBlank()){
            throw new Exception("Name cannot be blank.");
        }

        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }

        EMPLOYEECONTROLLER.changeEmployeeName(empID, newName);
        return "Employee " + empID + " was updated successfully";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        if(newGPA < 0 || newGPA > 10){
            throw new Exception(newGPA + " outside range. Must be between 0-10.");
        }
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }

        EMPLOYEECONTROLLER.changeInternGPA(empID, newGPA);
        return "Employee " + empID + " was updated successfully";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }
        if(!newDegree.equals("BSc") && !newDegree.equals("MSc") && !newDegree.equals("PhD")){
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }

        EMPLOYEECONTROLLER.changeManagerDegree(empID, newDegree);
        return "Employee " + empID + " was updated successfully";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        if(!newDepartment.equals("Technical") && !newDepartment.equals("Human Resources") && !newDepartment.equals("Business")){
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }

        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }

        EMPLOYEECONTROLLER.changeDirectorDept(empID, newDepartment);
        return "Employee " + empID + " was updated successfully";
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        if(newSalary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }
        EMPLOYEECONTROLLER.changeGrossSalary(empID, newSalary);
        return "Employee " + empID + " was updated successfully";
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        if(EMPLOYEECONTROLLER.getEmployees().isEmpty()){
            throw new Exception("No employees registered yet.");
        }

        return EMPLOYEECONTROLLER.mapDegreeToEmployee();
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }
        if(EMPLOYEECONTROLLER.promoteToManager(empID, degree)){
            return (empID + " promoted successfully to Manager.");
        }

        return "Employee could not be promoted. "; //Exceptions
    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }

        EMPLOYEECONTROLLER.promoteToDirector(empID, degree, department);
        return (empID + " promoted successfully to Director.");
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        if(!EMPLOYEECONTROLLER.getEmployees().contains(EMPLOYEECONTROLLER.getEmployee(empID))){
            throw new Exception("Employee " + empID + " was not registered yet.");
        }

        if(gpa < 0 || gpa > 10){
            throw new Exception(gpa + " outside range. Must be between 0-10.");
        }

        EMPLOYEECONTROLLER.promoteToIntern(empID, gpa);
        return (empID + " promoted successfully to Intern.");
    }
}

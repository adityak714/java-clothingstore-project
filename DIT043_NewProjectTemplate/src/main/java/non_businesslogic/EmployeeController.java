package non_businesslogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeController {

private final List<Employee> employees;

    protected double truncateDecimalFormat(double input){
        int truncatingResult;
        truncatingResult = (int)(input * 100);
        double truncatedResult;
        truncatedResult = (double) truncatingResult / 100;

        return truncatedResult;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    Employee empty = new Employee("", "", 0.0);
    Employee emptyManager = new Manager("", "", 0.0, "");
    Employee emptyDirector = new Director("", "", 0.0, "", "");
    Employee emptyIntern = new Intern("", "", 0.0, 0);


    public Employee getEmployee(String employeeID){
        for(Employee employee : employees){
           if(employee.hasSameID(employeeID)){
               return employee;
           }
        }
        return empty;
    }

    public Manager getManager(String employeeID){
        if(getEmployee(employeeID) instanceof Manager){
            return (Manager) getEmployee(employeeID);
        }
        return ((Manager) emptyManager);
    }

    public Director getDirector(String employeeID){
        if(getEmployee(employeeID) instanceof Director){
            return (Director) getEmployee(employeeID);
        }
        return ((Director) emptyDirector);
    }

    public Intern getIntern(String employeeID){
        if(getEmployee(employeeID) instanceof Intern){
            return (Intern) getEmployee(employeeID);
        }
        return ((Intern) emptyIntern);
    }

    protected double truncateSalary(double value, int decimal){
        return ((int) value * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }

    public EmployeeController(){ this.employees = new ArrayList<>(); }

    public boolean createEmployee(String employeeID, String name, double grossSalary) {
        if (employeeID.isEmpty() || name.isEmpty() || grossSalary <= 0 || employees.contains(getEmployee(employeeID))) {
            return false;
        } else {
            Employee employee = new Employee(employeeID, name, grossSalary);
            employees.add(employee);
            return true;
        }
    }

    public boolean createDirector(String employeeID, String name, double grossSalary, String degree, String department) {
        if(employeeID.isEmpty() || name.isEmpty() || grossSalary <= 0 || employees.contains(getEmployee(employeeID))){
            return false;
        } else {
            Employee employee = new Director(employeeID, name, grossSalary, degree, department);
            employees.add(employee);
            return true;
        }
    }

    public boolean createManager(String employeeID, String name, String degree, double grossSalary){
        if (employeeID.isBlank() || name.isBlank() || grossSalary <= 0 || employees.contains(getEmployee(employeeID)) || degree.isBlank()){
            return false;
        } else {
            Employee employee = new Manager(employeeID, name, grossSalary, degree);
            employees.add(employee);
            // need to create a collection to store all managers (and the same for other positions)
            return true;
        }
    }

    public boolean createIntern(String employeeID, String name, double grossSalary, int gpa) {
        if (employeeID.isEmpty() || name.isEmpty() || gpa <= 0 || employees.contains(getEmployee(employeeID))) {
            return false;
        } else {
            Employee employee = new Intern(employeeID, name, grossSalary, gpa);
            employees.add(employee);
            return true;
        }
    }

    public String removeEmployee (String employeeID) throws Exception {
        Employee desiredEmployee = getEmployee(employeeID);

        if (!desiredEmployee.equals(empty)) {
            employees.remove(desiredEmployee);
            return ("Employee " + employeeID + " was successfully removed.");
        }
        return ("Employee " + employeeID + " could not be removed.");
    }

    public double totalNetSalary(){
        double totalNet = 0.0;
        for(Employee employee : employees){
            totalNet += employee.getNetSalary();
        }
        return truncateDecimalFormat(totalNet);
    }

    public String printAllEmployees(){
        StringBuilder sb = new StringBuilder();

        sb.append("All registered employees:").append(ItemOptions.EOL);

        for (Employee employee : employees) {
            // add later to the menu.
                sb.append(employee).append(ItemOptions.EOL);
        }

        if(employees.isEmpty()){
            return "No employees registered yet."; //Exception
        }

        return sb.toString();
    }

    public String sortEmployeesByGrossSalary(){
        StringBuilder sb = new StringBuilder();

        if(employees.isEmpty()){
            return "No employees registered yet.";
        }

        employees.sort(Comparator.comparingDouble(Employee::getSalary));

        sb.append("Employees sorted by gross salary (ascending order):").append(ItemOptions.EOL);

        for (Employee employee : employees) {
            sb.append(employee).append(ItemOptions.EOL);
        }

        return sb.toString();
    }

    public boolean changeEmployeeName(String empID, String newName){
        Employee desiredEmployee = getEmployee(empID);
        boolean successful = false;

        if(employees.contains(desiredEmployee)){
            desiredEmployee.setName(newName);
            successful = true;
        }

        return successful;
    }

    public boolean changeInternGPA(String empID, int newGPA){
        Intern desiredEmployee = (Intern) getEmployee(empID);
        boolean successful = false;

        if(employees.contains(desiredEmployee)){
            desiredEmployee.setGPA(newGPA);
            successful = true;
        }

        return successful;
    }

    public boolean changeManagerDegree(String empID, String newDegree){
        Manager desiredEmployee = (Manager) getEmployee(empID);
        boolean successful = false;

        if(employees.contains(desiredEmployee)){
            desiredEmployee.degreeChange(newDegree);
            successful = true;
        }

        return successful;
    }

    public boolean changeDirectorDept(String empID, String newDept){
        Director desiredEmployee = (Director) getEmployee(empID);
        boolean successful = false;

        if(employees.contains(desiredEmployee)){
            desiredEmployee.setDepartment(newDept);
            successful = true;
        }

        return successful;
    }

    public boolean changeGrossSalary(String empID, double newSalary){
        Employee desiredEmployee = getEmployee(empID);
        boolean successful = false;

        if(employees.contains(desiredEmployee)){
            desiredEmployee.setSalary(newSalary);
            if(getEmployee(empID) instanceof Manager && desiredEmployee.setSalary(newSalary)){
                Manager desiredManager = (Manager) desiredEmployee;

                if (desiredManager.degree.equals("BSc")) {
                    desiredManager.setSalary(desiredManager.getSalary() * 1.1);
                    //27500.275 -> .28
                }
                if (desiredManager.degree.equals("MSc")) {
                    desiredManager.setSalary(desiredManager.getSalary() * 1.2);
                }
                if (desiredManager.degree.equals("PhD")) {
                    desiredManager.setSalary(desiredManager.getSalary() * 1.35);
                }
            }
            successful = true;
        }

        return successful;
    }

    //Salary is changing, degree is still the same
}

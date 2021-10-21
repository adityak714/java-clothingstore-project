package non_businesslogic;

import java.util.*;

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

    // we have created new objects of all classes in case the user's id doesn't exist.
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



    // We create a new array of employees in EmployeeController constructor.
    public EmployeeController(){ this.employees = new ArrayList<>(); }

    // Creating a general employee reference and object.
    public boolean createEmployee(String employeeID, String name, double grossSalary) {

        if (employeeID.isEmpty() || name.isEmpty() || grossSalary <= 0 || employees.contains(getEmployee(employeeID))) {
            return false;
        } else {
            Employee employee = new Employee(employeeID, name, grossSalary);
            employees.add(employee);
            return true;
        }
    }

    // Creating a Director employee reference and object.
    public boolean createDirector(String employeeID, String name, double grossSalary, String degree, String department) {
        if(employeeID.isEmpty() || name.isEmpty() || grossSalary <= 0 || employees.contains(getEmployee(employeeID))){
            return false;
        } else {
            Employee employee = new Director(employeeID, name, grossSalary, degree, department);
            employees.add(employee);
            return true;
        }
    }

    //  Creating a Manager employee reference and object.
    public boolean createManager(String employeeID, String name, String degree, double grossSalary){
        if (employeeID.isBlank() || name.isBlank() || grossSalary <= 0 || employees.contains(getEmployee(employeeID)) || degree.isBlank()){
            return false;
        }
        else {

            Employee employee = new Manager(employeeID, name, grossSalary, degree);
            employees.add(employee);

            return true;
        }
    }

    //  Creating an Intern employee reference and object.
    public boolean createIntern(String employeeID, String name, double grossSalary, int gpa) {
        if (employeeID.isEmpty() || name.isEmpty() || gpa <= 0 || employees.contains(getEmployee(employeeID))) {
            return false;
        }
        else {

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
            if(desiredEmployee instanceof Director){
                desiredEmployee = (Director) getEmployee(empID);
            }
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

    public Map<String, Integer> mapDegreeToEmployee(){
        Map<String, Integer> empToDegree = new HashMap<>();

        empToDegree.put("BSc", 0);
        empToDegree.put("MSc", 0);
        empToDegree.put("PhD", 0);

        for(Employee employee : employees) {
            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                if(manager.getDegree().equals("BSc")){
                    empToDegree.replace("BSc", empToDegree.get("BSc")+1);
                }
                if(manager.getDegree().equals("MSc")){
                    empToDegree.replace("MSc", empToDegree.get("MSc")+1);
                }
                if(manager.getDegree().equals("PhD")){
                    empToDegree.replace("PhD", empToDegree.get("PhD")+1);
                }
            }
        }

        if(empToDegree.get("BSc") == 0){
            empToDegree.remove("BSc");
        }
        if(empToDegree.get("MSc") == 0){
            empToDegree.remove("MSc");
        }
        if(empToDegree.get("PhD") == 0){
            empToDegree.remove("PhD");
        }

        return empToDegree;
    }

    public boolean promoteToManager(String empID, String degree){
        Employee toBePromoted = getEmployee(empID);
        String toBePromotedName = toBePromoted.name;
        double toBePromotedSalary = toBePromoted.salary;

        boolean promoted = false;

        for(Employee employee : employees){
            if(employee.equals(toBePromoted)){
                int indexOfPromoted = employees.indexOf(toBePromoted);

                if(employee instanceof Director){
                    toBePromotedSalary -= 5000;
                    if (((Director) employee).degree.equals("BSc")) {
                        toBePromotedSalary /= 1.1;
                    }
                    if (((Director) employee).degree.equals("MSc")) {
                        toBePromotedSalary /= 1.2;
                    }
                    if (((Director) employee).degree.equals("PhD")) {
                        toBePromotedSalary /= 1.35;
                    }
                    Manager director = new Manager(empID, toBePromotedName, toBePromotedSalary, degree);

                    employees.set(indexOfPromoted, director);
                    return true;
                }

                Employee manager = new Manager(empID, employee.name, employee.salary, degree);
                employees.set(indexOfPromoted, manager);
                promoted = true;
            }
        }
        return promoted;
    }

    public boolean promoteToDirector(String empID, String degree, String department){
        Employee toBePromoted = getEmployee(empID);
        String toBePromotedName = toBePromoted.name;
        double toBePromotedSalary = toBePromoted.salary;

        boolean promoted = false;

        for(Employee employee : employees){
            if(employee.equals(toBePromoted)){
                int indexOfPromoted = employees.indexOf(toBePromoted);

                if(employee instanceof Manager){
                    if (((Manager) employee).degree.equals("BSc")) {
                        toBePromotedSalary /= 1.1;
                    }
                    if (((Manager) employee).degree.equals("MSc")) {
                        toBePromotedSalary /= 1.2;
                    }
                    if (((Manager) employee).degree.equals("PhD")) {
                        toBePromotedSalary /= 1.35;
                    }

                    Director manager = new Director(empID, toBePromotedName, toBePromotedSalary, degree, department);
                    employees.set(indexOfPromoted, manager);
                    return true;
                }

                Employee director = new Director(empID, employee.name, employee.salary, degree, department);

                if(employee instanceof Intern){
                    director.salary = ((Intern) employee).getOriginalSalary();
                    final int directorBonus = 5000;

                    if(degree == "BSc"){
                        director.salary = director.salary * 1.1 + directorBonus;
                    }
                    if(degree == "MSc"){
                        director.salary = director.salary * 1.2 + directorBonus;
                    }
                    if(degree == "PhD"){
                        director.salary = director.salary * 1.35 + directorBonus;
                    }

                }
                employees.set(indexOfPromoted, director);
                promoted = true;
            }
        }
        return promoted;
    }

    public boolean promoteToIntern(String empID, int gpa){
        Employee toBePromoted = getEmployee(empID);
        String toBePromotedName = toBePromoted.name;
        double toBePromotedSalary = toBePromoted.salary;

        boolean promoted = false;

        for(Employee employee : employees){
            if(employee.equals(toBePromoted)){
                int index = employees.indexOf(toBePromoted);

                if(employee instanceof Director){
                    toBePromotedSalary -= 5000;
                    if (((Manager) employee).degree.equals("BSc")) {
                        toBePromotedSalary /= 1.1;
                    }
                    if (((Manager) employee).degree.equals("MSc")) {
                        toBePromotedSalary /= 1.2;
                    }
                    if (((Manager) employee).degree.equals("PhD")) {
                        toBePromotedSalary /= 1.35;
                    }

                    Intern newIntern = new Intern(empID, toBePromotedName, toBePromotedSalary, gpa);
                    employees.set(index, newIntern);
                    return true;
                }

                if(employee instanceof Manager){
                    if (((Manager) employee).degree.equals("BSc")) {
                        toBePromotedSalary /= 1.1;
                    }
                    if (((Manager) employee).degree.equals("MSc")) {
                        toBePromotedSalary /= 1.2;
                    }
                    if (((Manager) employee).degree.equals("PhD")) {
                        toBePromotedSalary /= 1.35;
                    }

                    Intern newIntern = new Intern(empID, toBePromotedName, toBePromotedSalary, gpa);
                    employees.set(index, newIntern);
                    return true;
                }

                Intern newIntern = new Intern(empID, toBePromotedName, toBePromotedSalary, gpa);
                employees.set(index, newIntern);
                promoted = true;
            }
        }
        return promoted;
    }
}

package non_businesslogic;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

private final List<Employee> employees;

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
}

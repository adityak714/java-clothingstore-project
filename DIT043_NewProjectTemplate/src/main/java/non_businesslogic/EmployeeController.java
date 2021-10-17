package non_businesslogic;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

private final List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    Employee empty = new Employee("", "", 0.0);

    public Employee getEmployee(String employeeID){
        for(Employee employee : employees){
           if(employee.hasSameID(employeeID)){
               return employee;
           }
        }
        return empty;
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
}

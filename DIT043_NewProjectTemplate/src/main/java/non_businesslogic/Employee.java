package non_businesslogic;

import java.util.Objects;

public class Employee {
    protected final String id;
    protected String name;
    protected double salary;
    protected double netSalary;

    public Employee(String id, String name, double salary) /*throws Exception */{
/*        if(id.isBlank() || name.isBlank()){
            throw new Exception("Field cannot be empty.");
        }
        if(salary <= 0){
            throw new Exception("Enter a non-zero value.");
        }*/
        this.id = id;
        this.name = name;
        //this.salary = salary;
        this.salary = truncateDecimalFormat(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected double getSalary() {
        return salary;
    }

    public boolean setSalary(double salary) {
        this.salary = salary;
        // Whenever the gross salary is changed, the new salary is adjusted again for the
        // degree the employee has, regardless of if the degree was changed or not.
        return true;
    }

    public double getNetSalary(){
        return (salary * 0.9);
    }

    @Override
    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", name, salary);
    }

    public boolean hasSameID(String anotherID){ return this.id.equals(anotherID); }

    protected double truncateDecimalFormat(double input){
        int truncatingResult;
        truncatingResult = (int)(input * 100);
        double truncatedResult;
        truncatedResult = (double) truncatingResult / 100;

        return truncatedResult;
    }

    protected double truncateSalary(double value, int decimal){
        return (value * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }
}

package non_businesslogic;

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
        this.salary = salary;
    }

    protected double getSalary() {
        return salary;
    }

    public double getNetSalary(){
        return (salary * 0.9);
    }

    protected double truncateSalary(double value, int decimal){
        return ((int) value * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }

    @Override
    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", name, salary);
    }

    public boolean hasSameID(String anotherID){ return this.id.equals(anotherID); }


}

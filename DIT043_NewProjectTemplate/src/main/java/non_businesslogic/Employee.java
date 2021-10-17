package non_businesslogic;

public class Employee {
    protected final String id;
    protected String name;
    protected double salary;
    protected double netSalary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", name, salary);
    }

    public double getSalary() {
        return salary;
    }

    public double getNetSalary(){return (salary * 0.9);}

    public boolean hasSameID(String anotherID){ return this.id.equals(anotherID); }
}

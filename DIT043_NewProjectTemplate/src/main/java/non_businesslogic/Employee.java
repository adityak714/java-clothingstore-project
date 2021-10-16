package non_businesslogic;

public class Employee {
    private final String id;
    private String name;
    private double salary;
    private double netSalary;

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

    public double getNetSalary(){
        return (salary - (salary * 0.1));
    }
}

package non_businesslogic;

public class Employee {
    protected final String id;
    protected String name;
    protected double salary;

    public Employee(String id, String name, double salary){
        this.id = id;
        this.name = name;
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
}

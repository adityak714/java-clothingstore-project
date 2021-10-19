package non_businesslogic;

public class Intern extends Employee {

    private int gpa;
    private final double internSalary;

    public Intern(String id, String name, double salary, int gpa){
        super(id, name, salary);
        this.gpa = gpa;
        final int internBonus = 1000;
        this.salary = salary;
        internSalary = salary;

        if (gpa <= 5) {
            this.salary = 0.0;
        } else if (gpa > 8) {
            this.salary = salary + internBonus;
        }
    }

    public int getGPA(int gpa){ return gpa;}

    public void setGPA(int newGPA){
        this.gpa = newGPA;

        if(newGPA <= 5){
            this.salary = 0.0;
        } else if (newGPA > 8){
            this.salary = internSalary + 1000;
        }
    }

    @Override
    public double getNetSalary() {
        return getSalary();
    }

    public String toString(){
        return String.format("%s's gross salary is %.2f SEK per month. GPA: %d", name, truncateDecimalFormat(this.salary), gpa);
    }
}

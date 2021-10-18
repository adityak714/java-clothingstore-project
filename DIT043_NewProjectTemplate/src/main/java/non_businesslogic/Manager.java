package non_businesslogic;

public class Manager extends Employee {

    protected String degree;

    public Manager(String id, String name, double salary, String degree) {
        super(id, name, salary);
        this.degree = degree;
        if(degree == "BSc"){
            this.salary = salary * 1.1;
        }
        if(degree == "MSc"){
            this.salary = salary * 1.2;
        }
        if(degree == "PhD"){
            this.salary = salary * 1.35;
        }
    }

    public String getDegree(){ return degree; }
    // Create more branches with degrees; BSc, MSc & PhD (with 10%, 20% & 35% bonus corresponding to each).
    // The bonus should only affect the salary set in the super class, not anywhere else.
   /* public double truncateSalary(double value, int decimals){
         double newValue = ((int) value * Math.pow(10, decimals)) / Math.pow(10, decimals);
         return newValue;
    }*/

    @Override
    public double getNetSalary() {
        return truncateSalary(super.getNetSalary(), 2);
    }

    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, name, truncateSalary(salary, 2));
    }
}

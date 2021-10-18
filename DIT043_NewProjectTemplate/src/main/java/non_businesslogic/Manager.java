package non_businesslogic;

public class Manager extends Employee {

    private String degree;


    public Manager(String id, String name, double salary, String degree) {
        super(id, name, salary);
        salary = (double) ((int) salary * 100 / 100);
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

    public String toString(){
<<<<<<< Updated upstream
        salary =  ((int) salary * Math.pow(10, 2)) / Math.pow(10, 2);
=======
>>>>>>> Stashed changes
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, name, salary);
    }

}

package non_businesslogic;

public class Manager extends Employee {

    protected String degree;

    // MSc -> PhD
    //BSc-MSc 50000-5000/1.1

    public Manager(String id, String name, double salary, String degree) {
        super(id, name, salary);
        this.degree = degree;
        if (degree.equals("BSc")) {
            this.salary = getSalary() * 1.1;
            //27500.275 -> .28
        }
        if (degree.equals("MSc")) {
            this.salary = getSalary() * 1.2;
        }
        if (degree.equals("PhD")) {
            this.salary = getSalary() * 1.35;
        }
    }

    public void degreeChange(String degree) {
        this.degree = degree;
        switch(degree){
            case "MSc":
                this.salary = (1.2*(this.salary/1.1));
                break;
            case "PhD":
                this.salary = (1.35*((this.salary)/1.2));
                break;
            case "BSc":
                this.salary = ((this.salary / 1.2)*1.1);
        }
    }

/*    public void promotionDegreeChange(String degree){

        this.degree = degree;
        if()
        switch(degree){
            case ""
        }

    }*/



    public String getDegree(){
        return degree;
    }
    // Create more branches with degrees; BSc, MSc & PhD (with 10%, 20% & 35% bonus corresponding to each).
    // The bonus should only affect the salary set in the super class, not anywhere else.
   /* public double truncateSalary(double value, int decimals){
         double newValue = ((int) value * Math.pow(10, decimals)) / Math.pow(10, decimals);
         return newValue;
    }*/

    @Override
    public double getNetSalary() {
        return super.getNetSalary();
    }

    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, name, truncateDecimalFormat(this.salary));
    }
}

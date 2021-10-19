package non_businesslogic;

public class Director extends Manager {

    private String department;

    //35000.5 * 1.2 = 42000.6 + 5000 = 47000.6
    //(47000.6 - 5000)/1.2 = 35000.5
    //(35000.5 * 1.35) + 5000 = 52250.675;

    public Director(String id, String name, double salary, String degree, String department) {
        super(id, name, salary, degree);
        final int directorBonus = 5000;
        degree = super.getDegree();

        if(degree == "BSc"){
            this.salary = salary * 1.1;
        }
        if(degree == "MSc"){
            this.salary = salary * 1.2;
        }
        if(degree == "PhD"){
            this.salary = salary * 1.35;
        }

        this.salary += directorBonus;
        this.department = department;
    }

/*  Less than 30,000 SEK: the director pays the same taxation as a regular employee (10%) on their final gross salary.
    Between 30,000 and 50,000 SEK: the director will pay 20% taxes on their gross income.
    Greater than 50,000 SEK: he/she will pay 20% of taxes for the 30,000 SEK and 40% taxes on the amount that is greater than 30,000.*/

    //More sub-branches - Human Resources, Technical, Business
    //Additional fixed salary addition of 5000

    @Override
    public double getNetSalary() {
        double netSalary;
        if(salary <= 30000){
            netSalary = super.getNetSalary();
        }
        else if(salary > 30000 && salary < 50000){
            netSalary = salary * 0.8;
        }
        else {
            double upperBaselineTax = (30000 * 0.8);
            netSalary = (upperBaselineTax + (0.6 * (salary - 30000)));
        }
        return netSalary;
    }

    public void degreeChange(String degree) {
        this.degree = degree;
        switch(degree){
            case "MSc":
                this.salary = (1.2*((this.salary-5000)/1.1)+5000);
                break;
            case "PhD":
                this.salary = (1.35*((this.salary-5000)/1.2)+5000);
                break;
        }
    }

    public double getSalary(){return this.salary;}

    public String getDepartment(){ return department;}
    public void setDepartment(String newDepartment){ this.department = newDepartment;}

    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", degree, name, truncateDecimalFormat(this.salary), department);
    }
}

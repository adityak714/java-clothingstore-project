package non_businesslogic;

public class Director extends Manager {

    private String department;
    private final double upperBaselineTax = (30000 * 0.2);
    private String degree;

    public Director(String id, String name, double salary, String degree, String department) {
        super(id, name, salary, degree);
        salary = (double) ((int) salary * 100 / 100);
        final int directorBonus = 5000;
        this.salary = (salary + directorBonus);
        this.department = department;

        if(salary > 30000 && salary < 50000){
           this.salary = salary * 0.8;
        }
        else if (salary > 50000){
            this.salary = (6000 + 0.6 * (salary - 50000));
        }
    }

/*  Less than 30,000 SEK: the director pays the same taxation as a regular employee (10%) on their final gross salary.
    Between 30,000 and 50,000 SEK: the director will pay 20% taxes on their gross income.
    Greater than 50,000 SEK: he/she will pay 20% of taxes for the 30,000 SEK and 40% taxes on the amount that is greater than 30,000.*/

    //More sub-branches - Human Resources, Technical, Business
    //Additional fixed salary addition of 5000
    public double getSalary(){return this.salary;}

    public String getDepartment(){ return department;}
    public void setDepartment(String newDepartment){ this.department = newDepartment;}

    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", degree, name, super.salary, department);
    }
}

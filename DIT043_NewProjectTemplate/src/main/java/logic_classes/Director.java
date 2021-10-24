package logic_classes;

public class Director extends Manager {

    private String department;



    public Director(String id, String name, double salary, String degree, String department) {
        super(id, name, salary, degree);
        degree = super.getDegree();

        if(degree == "BSc"){
            this.salary = salary * BSCBONUS;
        }
        if(degree == "MSc"){
            this.salary = salary * MSCBONUS;
        }
        if(degree == "PhD"){
            this.salary = salary * PHDBONUS;
        }

        this.salary += directorBonus;
        this.department = department;
    }


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
            double upperBaselineTax = (30000 * 0.8); //Implies that 20% tax paid for 30000.
            netSalary = (upperBaselineTax + (0.6 * (salary - 30000)));//Leftover amount is applied with 40% tax.
        }
        return netSalary;
    }

    public void degreeChange(String degree) {
        this.degree = degree;
        switch(degree){
            case "MSc":
                this.salary = (MSCBONUS*((this.salary-directorBonus)/BSCBONUS)+directorBonus); //When a Director is changing degrees from BSc to MSc.
                break;
            case "PhD":
                this.salary = (PHDBONUS *((this.salary-directorBonus)/MSCBONUS)+directorBonus);//When a Director is changing degrees from MSc to PhD.
                break;
            case "BSc":
                this.salary = (((this.salary-directorBonus)/MSCBONUS)*BSCBONUS);//When a Director is changing degrees from MSc to BSc.
                break;
        }
    }

    public double getSalary(){return this.salary;}

    //public String getDepartment(){ return department;}
    public void setDepartment(String newDepartment){ this.department = newDepartment;}

    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", degree, name, truncateDecimalFormat(this.salary), department);
    }
}

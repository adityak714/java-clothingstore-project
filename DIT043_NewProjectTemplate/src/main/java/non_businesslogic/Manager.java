package non_businesslogic;

public class Manager extends Employee {

    protected String degree;
    protected static final int directorBonus = 5000;
    protected static final double BSCBONUS = 1.1; // BSCBONUS = Bachelors bonus 10%
    protected static final double MSCBONUS = 1.2; // MSCBONUS = Masters bonus 20%
    protected static final double PHDBONUS = 1.35;// PHDBONUS = PhD bonus 35%

    public Manager(String id, String name, double salary, String degree) {
        super(id, name, salary);
        this.degree = degree;

        if (degree.equals("BSc")) {
            this.salary = getSalary() * BSCBONUS;
        }
        if (degree.equals("MSc")) {
            this.salary = getSalary() * MSCBONUS;
        }
        if (degree.equals("PhD")) {
            this.salary = getSalary() * PHDBONUS;
        }
    }

    public void degreeChange(String degree) {
        this.degree = degree;

        switch(degree){
            case "MSc":
                this.salary = (MSCBONUS*(this.salary/BSCBONUS)); //Demoting from a degree to MSc.
                break;
            case "PhD":
                this.salary = (PHDBONUS*((this.salary)/MSCBONUS));//Demoting from a degree to PhD.
                break;
            case "BSc":
                this.salary = ((this.salary / MSCBONUS)*BSCBONUS);//Demoting from a degree to BSc.
        }
    }

    public String getDegree(){
        return degree;
    }

    @Override
    public double getNetSalary() {
        return super.getNetSalary();
    }

    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, name, truncateDecimalFormat(this.salary));
    }
}

package non_businesslogic;

public class Manager extends Employee {

    protected String degree;

    public Manager(String id, String name, double salary, String degree) {
        super(id, name, salary);
        this.degree = degree;
        if (degree.equals("BSc")) {
            this.salary = getSalary() * 1.1;
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

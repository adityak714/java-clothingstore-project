package non_businesslogic;

public class Intern extends Employee {

    public Intern(String id, String name, double salary) {
        super(id, name, salary);
    }

    //GPA less than or equal to 5: then he/she will not receive a gross salary (i.e., it will be zero).
    //GPA between 5 and 8: then he/she will receive his/her full gross salary.
    //GPA greater than or equal to 8: then he/she will receive the full gross salary, plus a benefit of 1,000 SEK to reward them for academic excellence.

    //No net salary as interns don't pay taxes
    //Net salary = Gross salary
}

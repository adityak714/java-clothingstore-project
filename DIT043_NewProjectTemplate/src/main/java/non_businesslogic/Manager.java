package non_businesslogic;

public class Manager extends Employee {

    public Manager(String id, String name, double salary) {
        super(id, name, salary);
    }

    // Create more branches with degrees; BSc, MSc & PhD (with 10%, 20% & 35% bonus corresponding to each).
    // The bonus should only affect the salary set in the super class, not anywhere else.
}

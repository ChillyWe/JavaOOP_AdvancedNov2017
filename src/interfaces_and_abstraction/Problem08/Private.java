package interfaces_and_abstraction.Problem08;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public class Private extends BaseISolder implements ISolder, IPrivate {
    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f", super.getFirstName(), super.getLastName(), super.getID(), this.salary);
    }
}
package interfaces_and_abstraction.Problem08;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public abstract class BaseISolder implements ISolder {
    private int id;
    private String firstName;
    private String lastName;

    protected BaseISolder(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
}
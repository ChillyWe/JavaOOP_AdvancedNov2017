package interfaces_and_abstraction.Problem08;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public class Spy extends BaseISolder implements ISolder, ISpy {
    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s\nCode Number: %s", super.getFirstName(), super.getLastName(), super.getID(), this.codeNumber);
    }
}
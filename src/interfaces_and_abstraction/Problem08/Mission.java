package interfaces_and_abstraction.Problem08;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
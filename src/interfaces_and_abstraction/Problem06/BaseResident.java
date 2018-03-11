package interfaces_and_abstraction.Problem06;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public abstract class BaseResident {
    private String name;

    protected BaseResident(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

}
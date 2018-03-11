package interfaces_and_abstraction.Problem10;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Demon extends BaseGameObject {
    private double energy;

    public Demon(String username, double energy, int level) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    protected String generateHashedPassword() {
        return String.format("%s", super.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("").append(this.energy * super.getLevel());
        return sb.toString();
    }
}
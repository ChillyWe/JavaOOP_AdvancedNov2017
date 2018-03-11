package interfaces_and_abstraction.Problem10;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Archangel extends BaseGameObject{
    private int mana;

    public Archangel(String username, int mana, int level) {
        super(username, level);
        this.mana = mana;
    }

    @Override
    protected String generateHashedPassword() {
        StringBuilder sb = new StringBuilder(super.getUsername()).reverse().append(super.getUsername().length() * 21);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("").append(this.mana * super.getLevel());
        return sb.toString();
    }
}
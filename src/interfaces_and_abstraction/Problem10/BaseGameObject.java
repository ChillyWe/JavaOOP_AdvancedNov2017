package interfaces_and_abstraction.Problem10;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public abstract class BaseGameObject implements GameObject{
    private String username;
    private String hashedPassword;
    private int level;

    protected BaseGameObject(String username, int level) {
        this.setUsername(username);
        this.hashedPassword = generateHashedPassword();
        this.level = level;
    }

    protected int getLevel() {
        return level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected abstract String generateHashedPassword();

    private void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return this.username;
    }

    @Override
    public String getHeshPass() {
        return this.hashedPassword;
    }
}
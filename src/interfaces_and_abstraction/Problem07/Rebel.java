package interfaces_and_abstraction.Problem07;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Rebel extends BaseResident {
    public static final int REBEL_DEFAULT_FOOD = 5;
    private String group;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.setGroup(group);
    }

    private void setGroup(String group) {
        this.group = group;
    }

    @Override
    public void buyFood() {
        super.setFoodCount(REBEL_DEFAULT_FOOD);
    }
}
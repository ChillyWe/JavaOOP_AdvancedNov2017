package interfaces_and_abstraction.Problem07;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public abstract class BaseResident implements Buyer{
    public static final int FOOD_DEFAULT_VALUE = 0;
    private String name;
    private int age;
    private int foodCount;

    protected BaseResident(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.foodCount = FOOD_DEFAULT_VALUE;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    protected void setFoodCount(int foodCount) {
        this.foodCount += foodCount;
    }

    @Override
    public int getFoodCount() {
        return this.foodCount;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
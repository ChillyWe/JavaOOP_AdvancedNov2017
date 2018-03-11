package interfaces_and_abstraction.Problem07;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Citizen extends BaseResident {
    public static final int CITIZEN_DEFAULT_FOOD = 10;
    private String id;
    private String birthDay;

    public Citizen(String name, int age , String id, String birthDay) {
        super(name, age);
        this.setId(id);
        this.setBirthDay(birthDay);
    }

    private void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public void buyFood() {
        super.setFoodCount(CITIZEN_DEFAULT_FOOD);
    }
}
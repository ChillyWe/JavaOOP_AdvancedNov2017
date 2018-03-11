package interfaces_and_abstraction.Problem06;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Pet extends BaseResident implements Birthdayable {
    private String birthDay;

    public Pet(String name, String birthDay) {
        super(name);
        this.setBirthDay(birthDay);
    }

    private void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }
}

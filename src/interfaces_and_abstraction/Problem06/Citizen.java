package interfaces_and_abstraction.Problem06;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Citizen extends BaseResident implements Identifiable, Birthdayable {
    private int age;
    private String id;
    private String birthDay;

    public Citizen(String name, int age , String id, String birthDay) {
        super(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthDay(birthDay);
    }

    private void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }
}
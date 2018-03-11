package interfaces_and_abstraction.Problem02;

/**
 * Created by Chilly on 18.11.2017 г..
 */
public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDay;

    public Citizen(String name, int age, String id, String birthDay) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDay = birthDay;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }

    @Override
    public String getID() {
        return this.id;
    }
}
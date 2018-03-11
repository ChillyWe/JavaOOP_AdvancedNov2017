package interfaces_and_abstraction.Problem06;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Robot extends BaseResident implements Identifiable {
    private String id;

    public Robot(String name, String id) {
        super(name);
        this.setId(id);
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
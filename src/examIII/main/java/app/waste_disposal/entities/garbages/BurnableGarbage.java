package exam_preparations.examIII.main.java.app.waste_disposal.entities.garbages;


import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Burnable;

/**
 * Created by Chilly on 20.12.2017 г..
 */
@Burnable
public class BurnableGarbage extends BaseGarbage {

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
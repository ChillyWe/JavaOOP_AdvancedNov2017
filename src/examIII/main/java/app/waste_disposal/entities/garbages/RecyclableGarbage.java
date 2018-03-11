package exam_preparations.examIII.main.java.app.waste_disposal.entities.garbages;

import app.waste_disposal.annotations.Recyclable;

/**
 * Created by Chilly on 20.12.2017 г..
 */
@Recyclable
public class RecyclableGarbage extends BaseGarbage {

    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
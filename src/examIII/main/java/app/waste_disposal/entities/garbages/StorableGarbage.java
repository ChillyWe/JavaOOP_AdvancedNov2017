package exam_preparations.examIII.main.java.app.waste_disposal.entities.garbages;

import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Storable;

/**
 * Created by Chilly on 20.12.2017 г..
 */
@Storable
public class StorableGarbage extends BaseGarbage {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
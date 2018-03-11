package exam_preparations.examIII.main.java.app.waste_disposal.factories;


import exam_preparations.examIII.main.java.app.waste_disposal.contracts.Waste;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.garbages.BurnableGarbage;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.garbages.RecyclableGarbage;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.garbages.StorableGarbage;

/**
 * Created by Chilly on 21.12.2017 г..
 */
public final class WasteFactory {

    private WasteFactory() {}

    public static Waste createRecyclable(String name, double weight, double volumePerKg) {
        return new RecyclableGarbage(name, weight, volumePerKg);
    }

    public static Waste createBurnable(String name, double weight, double volumePerKg) {
        return new BurnableGarbage(name, weight, volumePerKg);
    }

    public static Waste createStorable(String name, double weight, double volumePerKg) {
        return new StorableGarbage(name, weight, volumePerKg);
    }
}
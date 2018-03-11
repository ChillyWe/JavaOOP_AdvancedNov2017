package exam_preparations.examIII.main.java.app.waste_disposal.entities.strategies;


import exam_preparations.examIII.main.java.app.waste_disposal.contracts.ProcessingData;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.Waste;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.ProcessingDataImpl;

/**
 * Created by Chilly on 20.12.2017 г..
 */
public class StorableGarbageStrategy extends BaseStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energy = -1 * (garbage.getWeight() * garbage.getVolumePerKg()) * 0.13;
        double capital = -1 * (garbage.getWeight() * garbage.getVolumePerKg()) * 0.65;
        return new ProcessingDataImpl(energy, capital);
    }
}
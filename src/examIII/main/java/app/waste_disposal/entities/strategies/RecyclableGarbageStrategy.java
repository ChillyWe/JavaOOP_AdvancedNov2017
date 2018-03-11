package exam_preparations.examIII.main.java.app.waste_disposal.entities.strategies;


import exam_preparations.examIII.main.java.app.waste_disposal.contracts.ProcessingData;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.Waste;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.ProcessingDataImpl;

/**
 * Created by Chilly on 20.12.2017 г..
 */
public class RecyclableGarbageStrategy extends BaseStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energy =  - (garbage.getWeight() * garbage.getVolumePerKg()) * 0.5;
        double capital = garbage.getWeight() * 400;
        return new ProcessingDataImpl(energy, capital);
    }
}
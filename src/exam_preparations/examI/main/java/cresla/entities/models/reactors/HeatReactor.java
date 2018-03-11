package exam_preparations.examI.main.java.cresla.entities.models.reactors;

import cresla.interfaces.Container;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public class HeatReactor extends BaseReactor {
    private int heatReductionIndex;

    public HeatReactor(int id, Container container, int heatReductionIndex) {
        super(id, container);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long resultEnergy = super.getContainer().getTotalEnergyOutput();

        if (resultEnergy > this.getTotalHeatAbsorbing()) {
            resultEnergy = 0;
        }
        return resultEnergy;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing() + heatReductionIndex;
    }
}

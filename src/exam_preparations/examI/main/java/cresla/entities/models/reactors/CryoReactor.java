package exam_preparations.examI.main.java.cresla.entities.models.reactors;

import cresla.interfaces.Container;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public class CryoReactor extends BaseReactor {
    private int cryoProductionIndex;

    public CryoReactor(int id, Container container, int cryoProductionIndex) {
        super(id, container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long resultEnergy = super.getContainer().getTotalEnergyOutput() * cryoProductionIndex;

        if (resultEnergy > this.getTotalHeatAbsorbing()) {
            resultEnergy = 0;
        }
        return resultEnergy;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();
    }
}

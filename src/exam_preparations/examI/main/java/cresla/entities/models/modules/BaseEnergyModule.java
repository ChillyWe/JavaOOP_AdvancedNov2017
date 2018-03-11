package exam_preparations.examI.main.java.cresla.entities.models.modules;

import cresla.interfaces.EnergyModule;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public abstract class BaseEnergyModule extends BaseModule implements EnergyModule {
    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s Module - %d", this.getClass().getSimpleName(), super.getId())).append(System.lineSeparator())
                .append(String.format("Energy Output: %d", this.energyOutput));
        return builder.toString();
    }
}

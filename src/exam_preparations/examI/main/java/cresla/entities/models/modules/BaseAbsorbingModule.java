package exam_preparations.examI.main.java.cresla.entities.models.modules;

import cresla.interfaces.AbsorbingModule;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public abstract class BaseAbsorbingModule extends BaseModule implements AbsorbingModule {
    private int heatAbsorbing;

    protected BaseAbsorbingModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s Module - %d", this.getClass().getSimpleName(), super.getId())).append(System.lineSeparator())
                .append(String.format("Heat Absorbing: %d", this.heatAbsorbing));
        return builder.toString();
    }
}
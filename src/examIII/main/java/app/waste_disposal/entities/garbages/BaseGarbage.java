package exam_preparations.examIII.main.java.app.waste_disposal.entities.garbages;


import exam_preparations.examIII.main.java.app.waste_disposal.contracts.Waste;

/**
 * Created by Chilly on 20.12.2017 г..
 */
public abstract class BaseGarbage implements Waste {
    private String name;
    private double weight;
    private double volumePerKg;

    protected BaseGarbage(String name, double weight, double volumePerKg) {
        this.name = name;
        this.weight = weight;
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
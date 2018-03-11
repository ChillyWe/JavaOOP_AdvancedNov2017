package exam_preparations.examIII.main.java.app.waste_disposal.entities;


import exam_preparations.examIII.main.java.app.waste_disposal.contracts.ProcessingData;

/**
 * Created by Chilly on 20.12.2017 г..
 */
public class ProcessingDataImpl implements ProcessingData {
    private double energyBalance;
    private double capitalBalance;

    public ProcessingDataImpl(double energyBalance, double capitalBalance) {
        this.energyBalance = energyBalance;
        this.capitalBalance = capitalBalance;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }
}

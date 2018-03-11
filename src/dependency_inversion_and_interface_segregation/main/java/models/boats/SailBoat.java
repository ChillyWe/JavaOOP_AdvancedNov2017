package dependency_inversion_and_interface_segregation.main.java.models.boats;

import utility.Constants;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public class SailBoat extends BaseBoat{
    private static final double SAIL_EFFICIENCY_MAX_VALUE = 100;
    private static final int SAIL_EFFICIENCY_MIN_VALUE = 1;

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < SAIL_EFFICIENCY_MIN_VALUE || sailEfficiency > SAIL_EFFICIENCY_MAX_VALUE) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }
}
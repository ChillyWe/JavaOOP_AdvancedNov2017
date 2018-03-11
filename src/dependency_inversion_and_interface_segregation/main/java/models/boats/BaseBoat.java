package dependency_inversion_and_interface_segregation.main.java.models.boats;

import contracts.Boat;
import contracts.Race;
import utility.Constants;
import utility.Validator;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public abstract class BaseBoat implements Boat {
    private static final String PROPERTY_NAME = "Weight";

    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, PROPERTY_NAME);
        this.weight = weight;
    }

    public abstract double calculateRaceSpeed(Race boatRace);
}
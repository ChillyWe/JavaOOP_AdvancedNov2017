package dependency_inversion_and_interface_segregation.main.java.models.boats_engines;

import contracts.BoatEngine;
import utility.Constants;
import utility.Validator;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public abstract class BaseBoatEngine implements BoatEngine {
    private static final String PROPERTY_NAME_HORSEPOWER = "Horsepower";
    private static final String PROPERTY_NAME_DISPLACEMENT = "Displacement";

    private int cachedOutput;
    private String model;

    protected BaseBoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        setHorsepower(horsepower);
        setDisplacement(displacement);
        this.cachedOutput = calculateCachedOutput(horsepower, displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    protected abstract int calculateCachedOutput(int horsepower, int displacement);

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, PROPERTY_NAME_HORSEPOWER);
    }

    private void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, PROPERTY_NAME_DISPLACEMENT);
    }
}

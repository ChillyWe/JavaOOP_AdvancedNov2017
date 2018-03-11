package dependency_inversion_and_interface_segregation.main.java.models.boats;

import utility.Validator;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public class Yacht extends BaseBoat {
    private static final String PROPERTY_NAME = "Cargo Weight";

    private int cargoWeight;

    public Yacht(String model, int weight, int cargoWeight) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, PROPERTY_NAME);
        this.cargoWeight = cargoWeight;
    }
}

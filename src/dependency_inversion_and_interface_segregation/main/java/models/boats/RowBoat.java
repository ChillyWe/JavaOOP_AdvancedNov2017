package dependency_inversion_and_interface_segregation.main.java.models.boats;

import utility.Validator;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public class RowBoat extends BaseBoat {
    private static final String PROPERTY_NAME = "Oars";
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, PROPERTY_NAME);
        this.oars = oars;
    }
}
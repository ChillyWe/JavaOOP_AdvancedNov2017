package dependency_inversion_and_interface_segregation.main.java.models.boats;

import contracts.BoatEngine;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public class PowerBoat extends BaseBoat{
    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }
}
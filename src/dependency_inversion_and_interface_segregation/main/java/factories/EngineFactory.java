package dependency_inversion_and_interface_segregation.main.java.factories;

import contracts.BoatEngine;
import models.boats_engines.JetEngine;
import models.boats_engines.SterndriveEngine;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public final class EngineFactory {
    private EngineFactory() {}

    public static BoatEngine createJetEngine(String model, int horsepower, int displacement) {
        return new JetEngine(model, horsepower, displacement);
    }

    public static BoatEngine createSterndriveEngine(String model, int horsepower, int displacement) {
        return new SterndriveEngine(model, horsepower, displacement);
    }
}
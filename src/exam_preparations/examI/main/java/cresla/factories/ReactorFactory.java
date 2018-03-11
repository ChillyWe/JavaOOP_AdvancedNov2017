package exam_preparations.examI.main.java.cresla.factories;

import cresla.entities.models.reactors.CryoReactor;
import cresla.entities.models.reactors.HeatReactor;
import cresla.interfaces.Container;
import cresla.interfaces.Reactor;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public final class ReactorFactory {
    private ReactorFactory() {}

    public static Reactor createCryoReactor(int id, Container container, int cryoProductionIndex) {
        return new CryoReactor(id, container, cryoProductionIndex);
    }

    public static Reactor createHeatReactor(int id, Container container, int heatReductionIndex) {
        return new HeatReactor(id, container, heatReductionIndex);
    }
}
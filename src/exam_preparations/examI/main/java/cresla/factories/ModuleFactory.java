package exam_preparations.examI.main.java.cresla.factories;

import cresla.entities.models.modules.CooldownSystem;
import cresla.entities.models.modules.CryogenRod;
import cresla.entities.models.modules.HeatProcessor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public final class ModuleFactory {
    private ModuleFactory () {}

    public static EnergyModule createCryogenRod(int id, int energyOutput) {
        return new CryogenRod(id, energyOutput);
    }

    public static AbsorbingModule createHeatProcessor(int id, int energyOutput) {
        return new HeatProcessor(id, energyOutput);
    }

    public static AbsorbingModule createCooldownSystem(int id, int energyOutput) {
        return new CooldownSystem(id, energyOutput);
    }
}
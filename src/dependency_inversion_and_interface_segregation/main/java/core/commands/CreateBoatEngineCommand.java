package dependency_inversion_and_interface_segregation.main.java.core.commands;

import contracts.BoatEngine;
import core.BaseCommand;
import factories.EngineFactory;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public class CreateBoatEngineCommand extends BaseCommand {

    @Override
    public String execute() {
        String type = super.getParams().get(3);
        int horsepower = Integer.parseInt(super.getParams().get(1));
        int displacement = Integer.parseInt(super.getParams().get(2));

        BoatEngine engine = null;
        switch (type) {
            case "Jet":
                engine = EngineFactory.createJetEngine(super.getParams().get(0), horsepower, displacement);
                break;
            case "Sterndrive":
                engine = EngineFactory.createSterndriveEngine(super.getParams().get(0), horsepower, displacement);
                break;
        }


        return String.format("Engine model %s with %d HP and displacement %d cm3 created successfully.", engine.getModel(), horsepower, displacement);
    }
}

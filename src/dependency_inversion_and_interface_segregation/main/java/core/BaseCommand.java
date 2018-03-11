package dependency_inversion_and_interface_segregation.main.java.core;

import annotation.Inject;
import contracts.BoatSimulatorController;
import contracts.Executable;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public abstract class BaseCommand implements Executable {
    @Inject
    private List<String> params;
    @Inject
    private BoatSimulatorController controller;

    protected BaseCommand() {
    }

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected BoatSimulatorController getController() {
        return this.controller;
    }
}
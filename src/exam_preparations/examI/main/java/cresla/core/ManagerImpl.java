package exam_preparations.examI.main.java.cresla.core;

import cresla.factories.ContainerFactory;
import cresla.factories.ModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public class ManagerImpl implements Manager {
    private static final String CRYO_REACTOR = "Cryo";
    private static final String HEAT_REACTOR = "Heat";

    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;
    private int idCounter;

    public ManagerImpl() {
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
        this.idCounter = 1;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Container container = ContainerFactory.createContainer(Integer.parseInt(arguments.get(2)));

        if (CRYO_REACTOR.equals(arguments.get(0))) {
            Reactor cryoReactor = ReactorFactory.createCryoReactor(this.idCounter, container, Integer.parseInt(arguments.get(1)));
            reactors.putIfAbsent(this.idCounter, cryoReactor);
        } else if (HEAT_REACTOR.equals(arguments.get(0))) {
            Reactor heatReactor = ReactorFactory.createHeatReactor(this.idCounter, container, Integer.parseInt(arguments.get(1)));
            reactors.putIfAbsent(this.idCounter, heatReactor);
        }

        return String.format("Created %s Reactor - %d", arguments.get(0), this.idCounter++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorID = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));

        if ("CryogenRod".equalsIgnoreCase(type)) {
            EnergyModule cryogenRod = ModuleFactory.createCryogenRod(this.idCounter, additionalParam);
            this.modules.put(this.idCounter, cryogenRod);
            this.reactors.get(reactorID).addEnergyModule(cryogenRod);
        } else if ("HeatProcessor".equalsIgnoreCase(type)) {
            AbsorbingModule heatProcessor = ModuleFactory.createHeatProcessor(this.idCounter, additionalParam);
            this.modules.put(this.idCounter, heatProcessor);
            this.reactors.get(reactorID).addAbsorbingModule(heatProcessor);
        } else if ("CooldownSystem".equalsIgnoreCase(type)) {
            AbsorbingModule cooldownSystem = ModuleFactory.createCooldownSystem(this.idCounter, additionalParam);
            this.modules.put(this.idCounter, cooldownSystem);
            this.reactors.get(reactorID).addAbsorbingModule(cooldownSystem);
        }

        return String.format("Added %s - %d to Reactor - %d", type, this.idCounter++, reactorID);
    }

    @Override
    public String reportCommand(List<String> arguments) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        int id = Integer.parseInt(arguments.get(0));
        StringBuilder sb = new StringBuilder();

        if (this.reactors.containsKey(id)) {
            Reactor reactor = this.reactors.get(id);
            sb
                    .append(String.format("%s - %d", reactor.getClass().getSimpleName(), reactor.getId())).append(System.lineSeparator())
                    .append(String.format("Energy Output: %d", reactor.getTotalEnergyOutput())).append(System.lineSeparator())
                    .append(String.format("Heat Absorbing: %d", reactor.getTotalHeatAbsorbing())).append(System.lineSeparator())
                    .append(String.format("Modules: %d", reactor.getModuleCount()));
        }

        if (this.modules.containsKey(id)) {
            Module module = this.modules.get(id);
            sb.append(module.toString());
        }
        return sb.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        StringBuilder builder = new StringBuilder();
        long totalEnergy = 0;
        long totalAbsorb = 0;
        int cryoCount = 0;
        int heatCount = 0;
        for (Reactor reactor : reactors.values()) {
            totalEnergy += reactor.getTotalEnergyOutput();
            totalAbsorb += reactor.getTotalHeatAbsorbing();

            if (reactor.getClass().getSimpleName().startsWith("Cryo")) {
                cryoCount++;
            } else {
                heatCount++;
            }
        }
        int energyCount = 0;
        int absorbCount = 0;
        for (Module module : modules.values()) {
            if (module.getClass().getSimpleName().startsWith("Cryo")) {
                energyCount++;
            } else {
                absorbCount++;
            }
        }

        builder.append(String.format("Cryo Reactors: %d", cryoCount)).append(System.lineSeparator())
                .append(String.format("Heat Reactors: %d", heatCount)).append(System.lineSeparator())
                .append(String.format("Energy Modules: %d", energyCount)).append(System.lineSeparator())
                .append(String.format("Absorbing Modules: %d", absorbCount)).append(System.lineSeparator())
                .append(String.format("Total Energy Output: %d", totalEnergy)).append(System.lineSeparator())
                .append(String.format("Total Heat Absorbing: %d", totalAbsorb)).append(System.lineSeparator());
        return builder.toString();
    }
}
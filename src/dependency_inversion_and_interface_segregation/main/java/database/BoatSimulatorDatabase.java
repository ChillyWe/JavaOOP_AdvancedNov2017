package dependency_inversion_and_interface_segregation.main.java.database;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.Modelable;
import contracts.Repository;

public class BoatSimulatorDatabase {
    Repository<Boat> boats;
    Repository<BoatEngine> engines;

    public BoatSimulatorDatabase()
    {
        this.setBoats(new RepositoryImpl<Boat>());
        this.setEngines(new RepositoryImpl<Modelable>());
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    private void setBoats(Repository<Boat> boats) {
        this.boats = boats;
    }

    public Repository<BoatEngine> getEngines() {
        return this.engines;
    }

    private void setEngines(Repository<BoatEngine> engines) {
        this.engines = engines;
    }
}

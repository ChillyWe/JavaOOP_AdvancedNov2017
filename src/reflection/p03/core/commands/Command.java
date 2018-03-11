package reflection.p03.core.commands;

import p03.annotations.Inject;
import p03.contracts.Executable;
import p03.contracts.Repository;
import p03.contracts.UnitFactory;

/**
 * Created by Chilly on 04.12.2017 г..
 */
public abstract class Command implements Executable{
    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}
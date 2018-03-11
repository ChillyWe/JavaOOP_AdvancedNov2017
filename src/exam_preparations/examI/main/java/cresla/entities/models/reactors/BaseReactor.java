package exam_preparations.examI.main.java.cresla.entities.models.reactors;

import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.LinkedList;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public abstract class BaseReactor implements Reactor {
    private static final String CLASS_PATH = "cresla.entities.containers.ModuleContainer";

    private int id;
    private Container container;

    protected BaseReactor(int id, Container container) {
        this.id = id;
        this.container = container;
    }

    protected Container getContainer() {
        return this.container;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public int getModuleCount() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> moduleContainerClass = Class.forName(CLASS_PATH);
        Field field = moduleContainerClass.getDeclaredFields()[1];
        field.setAccessible(true);
        return ((LinkedList<Module>) field.get(this.container)).size();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }
}
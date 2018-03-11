package exam_preparations.examI.main.java.cresla.factories;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.Container;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public final class ContainerFactory {
    private ContainerFactory() {}

    public static Container createContainer(int capacity) {
        return new ModuleContainer(capacity);
    }
}
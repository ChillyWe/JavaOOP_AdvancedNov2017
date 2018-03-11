package exam_preparations.examI.main.java.cresla.entities.models.modules;

import cresla.interfaces.Module;

/**
 * Created by Chilly on 16.12.2017 г..
 */
public abstract class BaseModule implements Module{
    private int id;

    protected BaseModule(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
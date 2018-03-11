package reflection.p03.core.commands;

import p03.contracts.Unit;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Chilly on 04.12.2017 г..
 */
public class AddCommand extends Command {

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
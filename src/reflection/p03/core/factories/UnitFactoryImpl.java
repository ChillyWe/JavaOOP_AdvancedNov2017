package reflection.p03.core.factories;

import p03.contracts.Unit;
import p03.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "p03.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<?> unitConstructor = unitClass.getDeclaredConstructor();
        Unit unit = (Unit) unitConstructor.newInstance();
        return unit;
	}
}
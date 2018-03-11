package reflection.p03;

import p03.contracts.CommandInterpreter;
import p03.contracts.Repository;
import p03.contracts.Runnable;
import p03.contracts.UnitFactory;
import p03.core.Engine;
import p03.core.factories.UnitFactoryImpl;
import p03.data.UnitRepository;
import p03.interpreters.CommandInterpreterImpl;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter interpreter = new CommandInterpreterImpl();
		Runnable engine = new Engine(repository, unitFactory, interpreter);
		engine.run();
	}
}


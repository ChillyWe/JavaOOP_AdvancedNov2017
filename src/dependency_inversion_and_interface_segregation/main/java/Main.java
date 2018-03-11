package dependency_inversion_and_interface_segregation.main.java;

import contracts.BoatSimulatorController;
import controllers.BoatSimulatorControllerImpl;
import core.CommandHandlerImpl;
import database.BoatSimulatorDatabase;
import engines.Engine;
import contracts.CommandHandler;
import contracts.InputReader;
import contracts.OutputWriter;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        BoatSimulatorDatabase database = new BoatSimulatorDatabase();
        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);

        Engine engine = new Engine(commandHandler, reader, writer);
        engine.run();
    }
}

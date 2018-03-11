package dependency_inversion_and_interface_segregation.main.java.engines;

import contracts.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Engine {
    private CommandHandler commandHandler;
    private InputReader reader;
    private OutputWriter writer;

    public Engine(CommandHandler commandHandler, InputReader reader, OutputWriter writer) {
        this.commandHandler = commandHandler;
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        String line = reader.readLine();
        while (true) {
            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            String name = tokens.get(0);
            List<String> parameters = tokens.subList(1, tokens.size());

            try {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                writer.writeLine(commandResult);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            line = reader.readLine();
        }
    }
}
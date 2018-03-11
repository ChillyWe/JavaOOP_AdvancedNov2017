package exam_preparations.examI.main.java.cresla;

import cresla.core.ManagerImpl;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputWriter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Manager manager = new ManagerImpl();

        whileLoop:
        while (true) {
            List<String> input = Arrays.asList(reader.readLine().split("\\s+"));
            String command = input.get(0).toLowerCase();
            input = input.subList(1, input.size());
            switch (command) {
                case "reactor":
                    writer.writeLine(manager.reactorCommand(input));
                    break;
                case "module":
                    writer.writeLine(manager.moduleCommand(input));
                    break;
                case "report":
                    writer.writeLine(manager.reportCommand(input));
                    break;
                default:
                    writer.writeLine(manager.exitCommand(input));
                    break whileLoop;
            }
        }
    }
}
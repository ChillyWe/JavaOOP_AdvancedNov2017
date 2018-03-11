package exam_preparations.examII.main.java.hell;

import hell.core.Manager;
import hell.core.ManagerImpl;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, ClassNotFoundException {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Manager manager = new ManagerImpl();

        whileLoop:
        while (true) {
            List<String> input = Arrays.asList(reader.readLine().split("\\s+"));
            String command = input.get(0).toLowerCase();
            input = input.subList(1, input.size());
            switch (command) {
                case "hero":
                    writer.writeLine(manager.heroCommand(input));
                    break;
                case "item":
                    writer.writeLine(manager.itemCommand(input));
                    break;
                case "recipe":
                    writer.writeLine(manager.recipeCommand(input));
                    break;
                case "inspect":
                    writer.writeLine(manager.inspectCommand(input));
                    break;
                default:
                    writer.writeLine(manager.exitCommand(input));
                    break whileLoop;
            }
        }
    }
}
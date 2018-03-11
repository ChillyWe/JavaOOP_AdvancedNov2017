package dependency_inversion_and_interface_segregation.main.java.io;

import contracts.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    public void writeLine(String output) {
        System.out.println(output);
    }

    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
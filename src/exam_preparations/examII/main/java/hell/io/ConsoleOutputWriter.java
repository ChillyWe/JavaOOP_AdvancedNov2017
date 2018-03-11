package exam_preparations.examII.main.java.hell.io;

import hell.interfaces.OutputWriter;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
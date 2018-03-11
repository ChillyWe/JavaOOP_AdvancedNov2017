package exam_preparations.examIII.main.java.app.waste_disposal.io;


import exam_preparations.examIII.main.java.app.waste_disposal.contracts.OutputWriter;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output.replace(",", "."));
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
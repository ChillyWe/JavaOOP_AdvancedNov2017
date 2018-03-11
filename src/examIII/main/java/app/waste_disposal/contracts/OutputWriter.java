package exam_preparations.examIII.main.java.app.waste_disposal.contracts;

/**
 * Created by Chilly on 21.12.2017 г..
 */
public interface OutputWriter {
    void writeLine(String output);

    void writeLine(String format, Object... params);
}
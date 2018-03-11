package dependency_inversion_and_interface_segregation.main.java.contracts;

/**
 * Created by Chilly on 15.12.2017 г..
 */
public interface OutputWriter {
    void writeLine(String output);

    void writeLine(String format, Object... params);
}
package exam_preparations.examI.main.java.cresla.interfaces;

import java.util.List;

public interface Manager {
    String reactorCommand(List<String> arguments);

    String moduleCommand(List<String> arguments);

    String reportCommand(List<String> arguments) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException;

    String exitCommand(List<String> arguments);
}

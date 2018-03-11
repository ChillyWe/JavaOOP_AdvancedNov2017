package exam_preparations.examII.main.java.hell.core;

import java.util.List;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public interface Manager {
    String heroCommand(List<String> arguments);

    String itemCommand(List<String> arguments);

    String recipeCommand(List<String> arguments);

    String inspectCommand(List<String> arguments) throws NoSuchMethodException, IllegalAccessException, ClassNotFoundException;

    String exitCommand(List<String> arguments);
}
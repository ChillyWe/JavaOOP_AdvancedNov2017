package reflection.p03.core.commands;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Chilly on 04.12.2017 г..
 */
public class ReportCommand extends Command{

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String output = super.getRepository().getStatistics();
        return output;
    }
}
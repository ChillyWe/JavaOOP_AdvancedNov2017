package reflection.p03.interpreters;

import p03.contracts.CommandInterpreter;
import p03.contracts.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * Created by Chilly on 04.12.2017 г..
 */

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME =
            "p03.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    @Override
    public Executable interpretCommand(String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String correctCommandName = String.valueOf(commandName.charAt(0)).toUpperCase() + commandName.substring(1);
        Class<?> commandClass;
        try {
            commandClass = Class.forName(COMMANDS_PACKAGE_NAME + correctCommandName + COMMAND_SUFFIX);
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Invalid command!");
        }

        Constructor<?> constructor = commandClass.getDeclaredConstructor();
        Executable command = (Executable) constructor.newInstance();
        return command;
    }
}
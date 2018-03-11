package dependency_inversion_and_interface_segregation.main.java.core;

import annotation.Inject;
import contracts.BoatSimulatorController;
import contracts.CommandHandler;
import contracts.Executable;
import exeptions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    private static final String COMMAND_CLASS_PATH = "core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    private BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    public String executeCommand(String commandName, List<String> params) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        this.params = params;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + commandName + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor();
        Executable command = constructor.newInstance();
        injectDependencies(command);
       // String result = command.execute();
       // return result;
        return null;
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fieldsBaseCommand = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldsCommand = executable.getClass().getDeclaredFields();
        Field[] allFields = null;
        if (fieldsCommand.length > 0) {
            allFields = new Field[fieldsBaseCommand.length + fieldsCommand.length];
            System.arraycopy(fieldsBaseCommand, 0, allFields, 0, fieldsBaseCommand.length);
            System.arraycopy(fieldsCommand, 0, allFields, fieldsBaseCommand.length, fieldsCommand.length);
        }

        for (Field field : fieldsCommand.length > 0 ? allFields : fieldsBaseCommand) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }

    public String ExecuteCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        return null;
    }


    //   public String ExecuteCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
 //       switch (name) {
 //           case "CreateBoatEngine":
 //               EngineType engineType;
 //               if (parameters.get(3).equals("Jet")) {
 //                   return this.getController().CreateBoatEngine(
 //                           parameters.get(0),
 //                           Integer.parseInt(parameters.get(1)),
 //                           Integer.parseInt(parameters.get(2)),
 //                           "Jet");
 //               } else if (parameters.get(3).equals("Sterndrive")) {
 //                   return this.getController().CreateBoatEngine(
 //                           parameters.get(0),
 //                           Integer.parseInt(parameters.get(1)),
 //                           Integer.parseInt(parameters.get(2)),
 //                           "Sterndrive");
 //               }
//
 //               throw new IllegalArgumentException(Constants.IncorrectEngineTypeMessage);
//
 //           case "CreateRowBoat":
 //               return this.getController().CreateRowBoat(
 //                       parameters.get(0),
 //                       Integer.parseInt(parameters.get(1)),
 //                       Integer.parseInt(parameters.get(2)));
 //           case "CreateSailBoat":
 //               return this.getController().CreateSailBoat(
 //                       parameters.get(0),
 //                       Integer.parseInt(parameters.get(1)),
 //                       Integer.parseInt(parameters.get(2)));
 //           case "CreatePowerBoat":
 //               return this.getController().CreatePowerBoat(
 //                       parameters.get(0),
 //                       Integer.parseInt(parameters.get(1)),
 //                       parameters.get(2),
 //                       parameters.get(3));
 //           case "CreateYacht":
 //               return this.getController().CreateYacht(
 //                       parameters.get(0),
 //                       Integer.parseInt(parameters.get(1)),
 //                       parameters.get(2),
 //                       Integer.parseInt(parameters.get(3)));
 //           case "OpenRace":
 //               return this.getController().OpenRace(
 //                       Integer.parseInt(parameters.get(0)),
 //                       Integer.parseInt(parameters.get(1)),
 //                       Integer.parseInt(parameters.get(2)),
 //                       Boolean.parseBoolean(parameters.get(3)));
 //           case "SignUpBoat":
 //               return this.getController().SignUpBoat(parameters.get(0));
 //           case "StartRace":
 //               return this.getController().StartRace();
 //           case "GetStatistic":
 //               return this.getController().GetStatistic();
 //           default:
 //               throw new IllegalArgumentException();
 //       }
 //   }
}

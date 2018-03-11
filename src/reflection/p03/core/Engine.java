package reflection.p03.core;

import p03.annotations.Inject;
import p03.contracts.*;
import p03.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private String[] data;
	private Repository repository;
	private UnitFactory unitFactory;
	private CommandInterpreter interpreter;

	public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter interpreter) {
		this.repository = repository;
		this.unitFactory = unitFactory;
		this.interpreter = interpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				if (input.equals("fight")) {
					break;
				}
				String[] data = input.split("\\s+");
				String commandName = data[0];
				Executable command = this.interpreter.interpretCommand(commandName);

				this.data = data;
				injectDependencies(command);

				String result = command.execute();
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void injectDependencies(Executable command) throws IllegalAccessException {
		Field[] commandFields = command.getClass().getSuperclass().getDeclaredFields();
		Field[] engineFields = this.getClass().getDeclaredFields();

		for (Field commandField : commandFields) {
			if (commandField.isAnnotationPresent(Inject.class)) {
				for (Field engineField : engineFields) {
					if (commandField.getType().equals(engineField.getType()) && commandField.getName().equals(engineField.getName())) {
						commandField.setAccessible(true);
						engineField.setAccessible(true);
						commandField.set(command, engineField.get(this));
					}
				}
			}
		}
	}
}
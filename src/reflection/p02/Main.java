package reflection.p02;

import javafx.scene.effect.Reflection;
import p02.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Class<?> theClass = Class.forName("p02.com.peshoslav.BlackBoxInt");
		Constructor<?> theClassConstructor = theClass.getDeclaredConstructor();
		theClassConstructor.setAccessible(true);

		BlackBoxInt theClassInstance = (BlackBoxInt) theClassConstructor.newInstance();


		while (true) {
			String line = reader.readLine();
			if ("end".equalsIgnoreCase(line)) {
				break;
			}
			String[] tokens = line.split("_");

			Method theMethod = theClass.getDeclaredMethod(tokens[0], int.class);
			theMethod.setAccessible(true);
			theMethod.invoke(theClassInstance, Integer.parseInt(tokens[1]));

			Field innerValue = theClass.getDeclaredField("innerValue");
			innerValue.setAccessible(true);
			Object value = innerValue.get(theClassInstance);
			System.out.println(String.format("%s", value));
		}
	}
}
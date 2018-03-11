package reflection.p01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class<?> theClass = Class.forName("p01.RichSoilLand");
        Field[] allFields = theClass.getDeclaredFields();


        while (true) {
            String line = reader.readLine();
            if ("HARVEST".equalsIgnoreCase(line)) {
                break;
            }
            if ("all".equalsIgnoreCase(line)) {
                Arrays.stream(allFields).forEach(f -> System.out.println(String.format("%s %s %s", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName())));
            } else {
                Arrays.stream(allFields).filter(f -> line.equalsIgnoreCase(Modifier.toString(f.getModifiers())))
                        .forEach(f -> System.out.println(String.format("%s %s %s", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName())));
            }
        }
    }
}
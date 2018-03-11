package interfaces_and_abstraction.Problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Main {

    public static final String DEMON_DEFAULT = "Demon";
    public static final String ARCHANGEL_DEFAULT = "Archangel";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" \\| ");

        GameObject gameObject = null;
        if (DEMON_DEFAULT.equalsIgnoreCase(tokens[1])) {
            gameObject = new Demon(tokens[0], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]));
        } else if (ARCHANGEL_DEFAULT.equalsIgnoreCase(tokens[1])) {
            gameObject = new Archangel(tokens[0], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        }

        System.out.printf("\"%s\" | \"%s\" -> %s", gameObject.getName(), gameObject.getHeshPass(), gameObject.getClass().getSimpleName()).println();
        System.out.println(gameObject.toString());
    }
}
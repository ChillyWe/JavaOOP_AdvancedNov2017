package generics.Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 23.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split("\\s+");
        Threeuple<String, String, String> threeuple1 = new Threeuple<>(line1[0] + " " + line1[1], line1[2], line1[3]);
        String[] line2 = reader.readLine().split("\\s+");
        Boolean isDrunk = false;
        if ("drunk".equalsIgnoreCase(line2[2])) {
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(line2[0], Integer.parseInt(line2[1]), isDrunk);
        String[] line3 = reader.readLine().split("\\s+");
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(line3[0], Double.parseDouble(line3[1]), line3[2]);

        System.out.println(threeuple1.toString());
        System.out.println(threeuple2.toString());
        System.out.println(threeuple3.toString());
    }
}
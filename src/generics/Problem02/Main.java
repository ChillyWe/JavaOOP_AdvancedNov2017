package generics.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 17.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStrings = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStrings; i++) {
            Integer boxData = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box<>(boxData);
            System.out.println(box.toString());
        }
    }
}
package generics.Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chilly on 17.11.2017 г..
 */
public class Main {
    private static List<Box> bBoxData = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStrings = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStrings; i++) {
            String boxData = reader.readLine();
            Box<String> box = new Box<>(boxData);
            bBoxData.add(box);
        }
        Box<String> element = new Box<>(reader.readLine());

        System.out.println(returnIntegerCount(element));
    }

    private static <T extends Comparable> int returnIntegerCount(Box element) {
        int count = 0;
        if (bBoxData.size() == 0) throw new IllegalArgumentException();
        for (Box bBoxDatum : bBoxData) {
            if (element.compareTo(bBoxDatum) < 0) {
                count++;
            }
        }
        return count;
    }

    private static <T> void swapTwoElements(int index1, int index2) {
        Box temp = bBoxData.get(index1);
        bBoxData.set(index1, bBoxData.get(index2));
        bBoxData.set(index2, temp);
    }
}
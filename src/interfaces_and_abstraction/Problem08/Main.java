package interfaces_and_abstraction.Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, ISolder> myArmy= new HashMap<>();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] solderTokens = line.split("\\s+");
            switch (solderTokens[0]) {
                case "Private":
                    myArmy.putIfAbsent(Integer.parseInt(solderTokens[1]), new Private(Integer.parseInt(solderTokens[1]), solderTokens[2], solderTokens[3], Double.parseDouble(solderTokens[4])));
                case "LeutenantGeneral":
                    myArmy.putIfAbsent(Integer.parseInt(solderTokens[1]), new LeutenantGeneral(Integer.parseInt(solderTokens[1]), solderTokens[2], solderTokens[3], Double.parseDouble(solderTokens[4])));
                    if (line.length() > 5);
            }
        }
    }
}
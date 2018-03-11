package interfaces_and_abstraction.Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Buyer> residents = new HashMap<>();

        int numbersOfCitizens_Rebels = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numbersOfCitizens_Rebels; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            Buyer currResident = null;
            if (tokens.length == 4) {
                currResident = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            } else if(tokens.length == 3) {
                currResident = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }
            residents.putIfAbsent(currResident.getName(), currResident);
        }

        while (true) {
            String potentialBuyer = reader.readLine();
            if ("end".equalsIgnoreCase(potentialBuyer)) {
                break;
            }
            if (residents.containsKey(potentialBuyer)) {
                residents.get(potentialBuyer).buyFood();
            }
        }
        int food = 0;
        for (Buyer buyer : residents.values()) {
            food += buyer.getFoodCount();
        }
        System.out.println(food);
    }
}
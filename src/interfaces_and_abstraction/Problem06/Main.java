package interfaces_and_abstraction.Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> kingdomStuff = new ArrayList<>();
        List<Birthdayable> kingdomStuffWithBirthDay = new ArrayList<>();

        String line;
        while (true) {
            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split("\\s+");
            Identifiable resident = null;
            Birthdayable residentWithBirthDay = null;
            switch (tokens[0]) {
                case "Citizen":
                    residentWithBirthDay = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    kingdomStuffWithBirthDay.add(residentWithBirthDay);
                    break;
                case "Pet":
                    residentWithBirthDay = new Pet(tokens[1], tokens[2]);
                    kingdomStuffWithBirthDay.add(residentWithBirthDay);
                    break;
                case "Robot":
                    resident = new Robot(tokens[1], tokens[2]);
                    kingdomStuff.add(resident);
            }
        }
        String showMeResidentEndsWithThisYear = reader.readLine();
        kingdomStuffWithBirthDay.stream()
                .filter(r -> r.getBirthDay().endsWith(showMeResidentEndsWithThisYear))
                .forEach(r -> System.out.println(r.getBirthDay()));
    }
}
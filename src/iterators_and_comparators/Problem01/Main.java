package iterators_and_comparators.Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Chilly on 21.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator<String> listyIterator = null;
        String line;
        while (true) {
            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] commandTokens = line.split("\\s+");
            String command = commandTokens[0];

            try {
                switch (command) {
                    case "Create":
                        listyIterator = new ListyIterator(commandTokens = Arrays.copyOfRange(commandTokens, 1, commandTokens.length));
                        break;
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "Print":
                        listyIterator.Print();
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.iterator().hasNext());
                        break;
                    default:
                        break;
                }
            }
            catch (UnsupportedOperationException uoe) {
                System.out.println(uoe.getMessage());
            }
        }
    }
}
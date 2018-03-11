package enums_and_attributes.p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 24.11.2017 г..
 */
public class Main {
    private static final String ENUM_PATH_PACKAGE = "p06.";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String token = reader.readLine();

        Deck<Card> deck = new Deck<>();
        deck.printDeck();
    }
}
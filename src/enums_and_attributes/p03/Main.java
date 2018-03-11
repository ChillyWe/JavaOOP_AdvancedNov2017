package enums_and_attributes.p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 24.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = reader.readLine();
        String cardSuit = reader.readLine();
        Card card = new Card(Suit.valueOf(cardSuit), Rank.valueOf(cardRank));

        System.out.printf("Card name: %s of %s; Card power: %d", card.getRank(), card.getSuit(), card.getPower());
    }
}
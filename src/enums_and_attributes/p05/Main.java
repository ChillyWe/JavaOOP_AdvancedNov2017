package enums_and_attributes.p05;

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

        String cardRank2 = reader.readLine();
        String cardSuit2 = reader.readLine();
        Card card2 = new Card(Suit.valueOf(cardSuit2), Rank.valueOf(cardRank2));

        if (card.compareTo(card2) >= 0) {
            System.out.printf("Card name: %s of %s; Card power: %d", card.getRank(), card.getSuit(), card.getPower());
        } else {
            System.out.printf("Card name: %s of %s; Card power: %d", card2.getRank(), card2.getSuit(), card2.getPower());
        }
    }
}
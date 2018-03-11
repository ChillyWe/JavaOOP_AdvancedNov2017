package enums_and_attributes.p01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 24.11.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Suits> cardsSuits = new ArrayList<>();
        cardsSuits.add(Suits.CLUBS);
        cardsSuits.add(Suits.DIAMONDS);
        cardsSuits.add(Suits.HEARTS);
        cardsSuits.add(Suits.SPADES);

        System.out.println("Card Suit:");
        for (Suits cardsSuit : cardsSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", cardsSuit.ordinal(), cardsSuit.name());
        }
    }
}
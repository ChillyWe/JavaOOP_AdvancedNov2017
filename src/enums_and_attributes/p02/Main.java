package enums_and_attributes.p02;

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

        List<Ranks> cardsRanks = new ArrayList<>();
        cardsRanks.add(Ranks.ACE);
        cardsRanks.add(Ranks.TWO);
        cardsRanks.add(Ranks.THREE);
        cardsRanks.add(Ranks.FOUR);
        cardsRanks.add(Ranks.FIVE);
        cardsRanks.add(Ranks.SIX);
        cardsRanks.add(Ranks.SEVEN);
        cardsRanks.add(Ranks.EIGHT);
        cardsRanks.add(Ranks.NINE);
        cardsRanks.add(Ranks.TEN);
        cardsRanks.add(Ranks.JACK);
        cardsRanks.add(Ranks.QUEEN);
        cardsRanks.add(Ranks.KING);

        System.out.println("Card Rank:");
        for (Ranks cardsRank : cardsRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", cardsRank.ordinal(), cardsRank.name());
        }
    }
}
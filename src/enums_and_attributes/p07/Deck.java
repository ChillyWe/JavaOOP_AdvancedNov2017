package enums_and_attributes.p07;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chilly on 01.12.2017 г..
 */
public class Deck<Card> {

    public void printDeck() {
        cardGenerator();
    }

    private void cardGenerator() {
        List<Suit> suits = Arrays.asList(Suit.values());
        List<Rank> ranks = Arrays.asList(Rank.values());

        for (int i = 0; i < suits.size(); i++) {
            for (int j = 0; j < ranks.size(); j++) {
                Suit suit = suits.get(i);
                Rank rank = ranks.get(j);
                this.printCard(suit.name(), rank.name());
            }
        }
    }

    private void printCard(String suit, String rank) {
        System.out.println(String.format("%s of %s", rank, suit));
    }
}
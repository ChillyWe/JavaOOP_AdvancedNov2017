package enums_and_attributes.p08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chilly on 01.12.2017 г..
 */
public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public void cardGenerator() {
        List<Suit> suits = Arrays.asList(Suit.values());
        List<Rank> ranks = Arrays.asList(Rank.values());

        for (int i = 0; i < suits.size(); i++) {
            for (int j = 0; j < ranks.size(); j++) {
                Suit suit = suits.get(i);
                Rank rank = ranks.get(j);
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
    }

    public int getDecksize() {
        return this.deck.size();
    }

    public int containCard(Card card) {
        for (Card cardFromDeck : this.deck) {
            if (cardFromDeck.getSuit().name().equalsIgnoreCase(card.getSuit().name()) &&
                    cardFromDeck.getRank().name().equalsIgnoreCase(card.getRank().name())) {
                return this.deck.indexOf(cardFromDeck);
            }
        }
        return - 1;
    }

    public void removeFromDeck(Card card) {
        if (this.containCard(card) > 0) {
            int index = this.containCard(card);
            this.deck.remove(index);
        }
    }

    private void printCard(String suit, String rank) {
        System.out.println(String.format("%s of %s", rank, suit));
    }
}
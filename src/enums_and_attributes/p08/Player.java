package enums_and_attributes.p08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Chilly on 01.12.2017 г..
 */
public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>(5);
    }

    public String getName() {
        return this.name;
    }

    public void addCardInHand(Card card) {
        this.hand.add(card);
    }

    public boolean isReady() {
        return this.hand.size() == 5;
    }

    public Card highestPoweredCard() {
        hand.sort(Comparator.comparingInt(a -> a.getRank().getPower() + a.getSuit().getPower()));
        return this.hand.get(4);
    }
}
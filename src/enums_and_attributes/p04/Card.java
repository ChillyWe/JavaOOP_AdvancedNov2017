package enums_and_attributes.p04;

/**
 * Created by Chilly on 24.11.2017 г..
 */
public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getPower() {
        return this.rank.getPower() + this.suit.getPower();
    }
}
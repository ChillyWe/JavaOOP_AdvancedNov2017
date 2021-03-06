package enums_and_attributes.p06;

/**
 * Created by Chilly on 24.11.2017 г..
 */
@CustomAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum Suit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    Suit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
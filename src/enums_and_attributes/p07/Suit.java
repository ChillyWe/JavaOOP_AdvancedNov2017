package enums_and_attributes.p07;

/**
 * Created by Chilly on 24.11.2017 г..
 */
@CustomAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    @Override
    public String toString() {
        return super.toString();
    }
}
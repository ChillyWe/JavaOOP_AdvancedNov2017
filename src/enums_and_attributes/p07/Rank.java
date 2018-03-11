package enums_and_attributes.p07;

/**
 * Created by Chilly on 24.11.2017 г..
 */
@CustomAnnotation(category = "Rank", description = "Provides rank constants for a Card class.")
public enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    @Override
    public String toString() {
        return super.toString();
    }
}
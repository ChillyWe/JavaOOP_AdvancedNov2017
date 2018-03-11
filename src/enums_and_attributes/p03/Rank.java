package enums_and_attributes.p03;

/**
 * Created by Chilly on 24.11.2017 г..
 */
public enum Rank {
    ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int power;

    Rank(int power) {
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
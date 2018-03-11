package enums_and_attributes.p03;

/**
 * Created by Chilly on 24.11.2017 г..
 */
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
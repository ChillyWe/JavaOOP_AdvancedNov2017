package interfaces_and_abstraction.Problem08;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public abstract class SpecialisedSoldier extends Private implements ISolder, ISpecialisedSoldier {
    private String corps;

    protected SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append(String.format("Corps: %s", this.corps)).append(System.lineSeparator());
        return sb.toString();
    }
}
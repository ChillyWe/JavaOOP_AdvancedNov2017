package interfaces_and_abstraction.Problem08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public class Engineer extends SpecialisedSoldier implements ISolder, ISpecialisedSoldier,IEngineer {
    private Set<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps, Repair... repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs.addAll(Arrays.asList(repairs)) ;
    }

    @Override
    public Set<Repair> getRepairs() {
        return Collections.unmodifiableSet(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append("Repairs:").append(System.lineSeparator());
        repairs.forEach(repair -> sb.append("  ").append(repair.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
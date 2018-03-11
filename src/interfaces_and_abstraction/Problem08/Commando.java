package interfaces_and_abstraction.Problem08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public class Commando extends SpecialisedSoldier implements ISolder, ISpecialisedSoldier, ICommando {
    private Set<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps, Mission... missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions.addAll(Arrays.asList(missions));
    }

    @Override
    public Set<Mission> getMissins() {
        return Collections.unmodifiableSet(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append("Mission:").append(System.lineSeparator());
        missions.forEach(mission -> sb.append("  ").append(mission.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
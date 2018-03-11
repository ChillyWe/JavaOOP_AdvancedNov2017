package interfaces_and_abstraction.Problem08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Chilly on 20.11.2017 г..
 */
public class LeutenantGeneral extends Private implements ISolder,ILeutenantGeneral {
    private Set<Private> mySquad;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary, Private... solders) {
        super(id, firstName, lastName, salary);
        this.mySquad.addAll(Arrays.asList(solders));
    }

    @Override
    public Set<Private> getMySquad() {
        return Collections.unmodifiableSet(this.mySquad);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Privates:").append(System.lineSeparator());
            mySquad.forEach(sol -> sb.append("  ").append(sol.toString()).append(System.lineSeparator()));
                return sb.toString();
    }
}
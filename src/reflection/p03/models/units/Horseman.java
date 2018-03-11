package reflection.p03.models.units;

/**
 * Created by Chilly on 04.12.2017 г..
 */
public class Horseman extends AbstractUnit {

    private static final int HORSEMAN_ATTACK_DAMAGE = 10;
    private static final int HORSEMAN_HEALTH = 50;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_ATTACK_DAMAGE);
    }
}
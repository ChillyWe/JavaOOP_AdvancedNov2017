package reflection.p03.models.units;

/**
 * Created by Chilly on 04.12.2017 г..
 */
public class Gunner extends AbstractUnit{

    private static final int GUNNER_ATTACK_DAMAGE = 20;
    private static final int GUNNER_HEALTH = 20;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_ATTACK_DAMAGE);
    }
}
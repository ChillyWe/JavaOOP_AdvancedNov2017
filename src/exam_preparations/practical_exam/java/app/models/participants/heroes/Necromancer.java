package exam_preparations.practical_exam.java.app.models.participants.heroes;

import app.models.Config;

/**
 * Created by Chilly on 22.12.2017 г..
 */
public class Necromancer extends BaseHero {

    public Necromancer(String name) {
        super(name, Config.NECROMANCER_BASE_STRENGTH, Config.NECROMANCER_BASE_DEXTERITY, Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 2) + (super.getStrength() * 2) + (super.getDexterity() * 2);
    }
}

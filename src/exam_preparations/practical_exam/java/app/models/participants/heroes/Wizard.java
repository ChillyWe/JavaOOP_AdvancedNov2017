package exam_preparations.practical_exam.java.app.models.participants.heroes;

import app.models.Config;

/**
 * Created by Chilly on 22.12.2017 г..
 */
public class Wizard extends BaseHero {

    public Wizard(String name) {
        super(name, Config.WIZARD_BASE_STRENGTH, Config.WIZARD_BASE_DEXTERITY, Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 5) + super.getDexterity();
    }
}

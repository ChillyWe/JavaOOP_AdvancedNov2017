package exam_preparations.practical_exam.java.app.models.participants.heroes;

import app.models.Config;

public class Warrior extends BaseHero{

    public Warrior(String name) {
        super(name, Config.WARRIOR_BASE_STRENGTH, Config.WARRIOR_BASE_DEXTERITY, Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getStrength() * 2) + super.getDexterity();
    }
}

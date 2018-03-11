package exam_preparations.examII.main.java.hell.entities.heroes;

import hell.interfaces.Inventory;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public class Wizard extends BaseHero {
    private static final int DEFAULT_WIZARD_STRENGTH = 25;
    private static final int DEFAULT_WIZARD_AGILITY = 25;
    private static final int DEFAULT_WIZARD_INTELLIGENCE = 100;
    private static final int DEFAULT_WIZARD_HIT_POINTS = 100;
    private static final int DEFAULT_WIZARD_DAMAGE = 250;

    public Wizard(String name, Inventory inventory) {
        super(name, DEFAULT_WIZARD_STRENGTH, DEFAULT_WIZARD_AGILITY, DEFAULT_WIZARD_INTELLIGENCE, DEFAULT_WIZARD_HIT_POINTS, DEFAULT_WIZARD_DAMAGE, inventory);
    }
}
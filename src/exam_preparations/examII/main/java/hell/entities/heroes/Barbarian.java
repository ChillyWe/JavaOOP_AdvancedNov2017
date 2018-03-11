package exam_preparations.examII.main.java.hell.entities.heroes;

import hell.interfaces.Inventory;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public class Barbarian extends BaseHero {
    private static final int DEFAULT_BARBARIAN_STRENGTH = 90;
    private static final int DEFAULT_BARBARIAN_AGILITY = 25;
    private static final int DEFAULT_BARBARIAN_INTELLIGENCE = 10;
    private static final int DEFAULT_BARBARIAN_HIT_POINTS = 350;
    private static final int DEFAULT_BARBARIAN_DAMAGE = 150;

    public Barbarian(String name, Inventory inventory) {
        super(name, DEFAULT_BARBARIAN_STRENGTH, DEFAULT_BARBARIAN_AGILITY, DEFAULT_BARBARIAN_INTELLIGENCE, DEFAULT_BARBARIAN_HIT_POINTS, DEFAULT_BARBARIAN_DAMAGE, inventory);
    }
}
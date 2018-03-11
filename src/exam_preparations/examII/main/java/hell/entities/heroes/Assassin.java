package exam_preparations.examII.main.java.hell.entities.heroes;

import hell.interfaces.Inventory;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public class Assassin extends BaseHero {
    private static final int DEFAULT_ASSASSIN_STRENGTH = 25;
    private static final int DEFAULT_ASSASSIN_AGILITY = 100;
    private static final int DEFAULT_ASSASSIN_INTELLIGENCE = 15;
    private static final int DEFAULT_ASSASSIN_HIT_POINTS = 150;
    private static final int DEFAULT_ASSASSIN_DAMAGE = 300;

    public Assassin(String name, Inventory inventory) {
        super(name, DEFAULT_ASSASSIN_STRENGTH, DEFAULT_ASSASSIN_AGILITY, DEFAULT_ASSASSIN_INTELLIGENCE, DEFAULT_ASSASSIN_HIT_POINTS, DEFAULT_ASSASSIN_DAMAGE, inventory);
    }
}
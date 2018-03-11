package exam_preparations.examII.main.java.hell.comparators;

import hell.interfaces.Hero;

import java.util.Comparator;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public class CompareHeroesByRequestedStats implements Comparator<Hero> {

    @Override
    public int compare(Hero hero1, Hero hero2) {
        long hero1Stats = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();
        long hero2Stats = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();

        int compare = Long.compare(hero2Stats, hero1Stats);
        if (compare == 0) {
            hero1Stats = hero1.getDamage() + hero1.getHitPoints();
            hero2Stats = hero2.getDamage() + hero2.getHitPoints();

            compare = Long.compare(hero2Stats, hero1Stats);
        }
        return compare;
    }
}
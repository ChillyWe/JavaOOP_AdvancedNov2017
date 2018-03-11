package exam_preparations.examII.main.java.hell.factories;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public final class HeroesFactory {
    private HeroesFactory() {}

    public static Hero createBarbarian(String name) {
        return new Barbarian(name, InventoryFactory.createInventory());
    }

    public static Hero createAssassin(String name) {
        return new Assassin(name, InventoryFactory.createInventory());
    }

    public static Hero createWizard(String name) {
        return new Wizard(name, InventoryFactory.createInventory());
    }
}
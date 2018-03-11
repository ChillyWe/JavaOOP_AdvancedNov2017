package exam_preparations.examII.main.java.hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public final class InventoryFactory {
    private InventoryFactory() {}

    public static Inventory createInventory() {
        return new HeroInventory();
    }
}
package exam_preparations.examII.main.java.hell.entities.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public abstract class BaseHero implements Hero {
    private static final String INVENTORY_PATH = "hell.entities.miscellaneous.HeroInventory";

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Collection<Item> getItems() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        Map<String, Item> items = null;
        Class<?> inventoryClass = Class.forName(INVENTORY_PATH);
        Field[] declaredField = inventoryClass.getDeclaredFields();

        for (Field field : declaredField) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (Map<String, Item>) field.get(this.inventory);
            }
        }

        return items != null ? items.values() : null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb
                    .append(String.format("%s: %s", this.getClass().getSimpleName(), this.name))
                    .append(System.lineSeparator())
                    .append(String.format("###HitPoints: %d", this.getHitPoints()))
                    .append(System.lineSeparator())
                    .append(String.format("###Damage: %d", this.getDamage()))
                    .append(System.lineSeparator())
                    .append(String.format("###Strength: %d", this.getStrength()))
                    .append(System.lineSeparator())
                    .append(String.format("###Agility: %d", this.getAgility()))
                    .append(System.lineSeparator())
                    .append(String.format("###Intelligence: %d", this.getIntelligence()))
                    .append(System.lineSeparator())
                    .append(String.format("###Items: %s", this.getItems().size() == 0 ? "None" : this.getItems().stream().map(Item::getName).collect(Collectors.joining(", "))))
                    .append(System.lineSeparator());
        } catch (IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sb.toString().trim();
    }
}
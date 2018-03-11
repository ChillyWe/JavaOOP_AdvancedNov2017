package exam_preparations.examII.main.java.hell.core;

import hell.comparators.CompareHeroesByRequestedStats;
import hell.factories.HeroesFactory;
import hell.factories.ItemFactory;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;

/**
 * Created by Chilly on 17.12.2017 г..
 */
public class ManagerImpl implements Manager {
    private Map<String, Hero> heroes;

    public ManagerImpl() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String heroCommand(List<String> arguments) {
        String name = arguments.get(0);
        String type = arguments.get(1);

        switch (type) {
            case "Barbarian":
                Hero barbarian = HeroesFactory.createBarbarian(name);
                this.heroes.put(name, barbarian);
                break;
            case "Assassin":
                Hero assassin = HeroesFactory.createAssassin(name);
                this.heroes.put(name, assassin);
                break;
            case "Wizard":
                Hero wizard = HeroesFactory.createWizard(name);
                this.heroes.put(name, wizard);
                break;
        }
        return String.format("Created %s - %s", type, name);
    }

    @Override
    public String itemCommand(List<String> arguments) {
        String name = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitPointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));

        if (this.heroes.containsKey(heroName)) {
            Item commonItem = ItemFactory.createCommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
            this.heroes.get(heroName).addItem(commonItem);
        }
        return String.format("Added item - %s to Hero - %s", name, heroName);
    }

    @Override
    public String recipeCommand(List<String> arguments) {
        String name = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitPointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));
        List<String> requiredItems = new ArrayList<>(arguments.subList(7, arguments.size()));

        if (this.heroes.containsKey(heroName)) {
            Recipe recipeItem = ItemFactory.createRecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
            this.heroes.get(heroName).addRecipe(recipeItem);
        }
        return String.format("Added recipe - %s to Hero - %s", name, heroName);
    }

    @Override
    public String inspectCommand(List<String> arguments) throws NoSuchMethodException, IllegalAccessException, ClassNotFoundException {
        String heroName = arguments.get(0);
        Hero hero = this.heroes.get(heroName);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Class: %s", heroName, hero.getClass().getSimpleName())).append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d", hero.getHitPoints(), hero.getDamage())).append(System.lineSeparator())
                .append(String.format("Strength: %d", hero.getStrength())).append(System.lineSeparator())
                .append(String.format("Agility: %d", hero.getAgility())).append(System.lineSeparator())
                .append(String.format("Intelligence: %d", hero.getIntelligence())).append(System.lineSeparator())
                .append(String.format("Items:%s", hero.getItems().size() == 0 ? " None" : ""))
                .append(System.lineSeparator());
        for (Item item : hero.getItems()) {
            sb.append(item.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        int counter = 1;
        StringBuilder sb = new StringBuilder();

        List<Hero> heroes = new ArrayList<>(this.heroes.values());
        heroes.sort(new CompareHeroesByRequestedStats());

        for (Hero hero : heroes) {
            sb
                    .append(String.format("%d. %s", counter++, hero))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
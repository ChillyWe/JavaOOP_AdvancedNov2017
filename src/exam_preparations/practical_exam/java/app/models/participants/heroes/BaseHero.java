package exam_preparations.practical_exam.java.app.models.participants.heroes;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

import static app.models.Config.HERO_HEALTH_MULTIPLIER;

/**
 * Created by Chilly on 22.12.2017 г..
 */
public abstract class BaseHero implements Hero{
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private double gold;
    private boolean isAlive;

    protected BaseHero(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.setStrength(strength);
        this.setDexterity(dexterity);
        this.setIntelligence(intelligence);
        this.level = 1;
        this.gold = Config.HERO_START_GOLD;
        this.isAlive = true;
    }

    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    public double getReward(){
        return this.gold;
    }

    public void receiveReward(double reward){
        this.gold += reward;
    }

    public void takeDamage(double damage) {
        this.health -= damage;

        if (this.health <= 0) {
            this.isAlive = false;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
        this.setHealth(strength * HERO_HEALTH_MULTIPLIER);
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.getGold());
        this.gold = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGold() {
        return this.gold;
    }

    public boolean isAlive() {
        if (this.health <= 0) {
            this.isAlive = false;
        }
        return this.isAlive;
    }

    public abstract double getDamage();

    public void levelUp() {
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getStrength() * HERO_HEALTH_MULTIPLIER);
        this.level += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }
}
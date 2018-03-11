package exam_preparations.practical_exam.java.app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss implements Targetable {
    private String name;
    private double health;
    private double damage;
    private double gold;
    private double individualReward;
    private boolean isAlive;

    public Boss(String name) {
        this.setName(name);
        this.health = Config.BOSS_HEALTH;
        this.damage = Config.BOSS_DAMAGE;
        this.gold = Config.BOSS_GOLD;
        this.individualReward = Config.BOSS_INDIVIDUAL_REWARD;
        this.isAlive = true;
    }

    @Override
    public String attack(Targetable target) {
        return null;
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;

        if (this.health <= 0) {
            this.isAlive = false;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.individualReward);
    }

    @Override
    public void receiveReward(double reward) {

    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}

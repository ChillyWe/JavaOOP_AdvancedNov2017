package exam_preparations.practical_exam.java.app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Boss;
import app.models.participants.heroes.Necromancer;
import app.models.participants.heroes.Warrior;
import app.models.participants.heroes.Wizard;

/**
 * Created by Chilly on 22.12.2017 г..
 */
public class TargetableFactoryImpl implements TargetableFactory {

    @Override
    public Targetable create(String name, String className) {
        String createdName = name;

        switch (className) {
            case "Warrior":
                return new Warrior(createdName);
            case "Wizard":
                return new Wizard(createdName);
            case "Necromancer":
                return new Necromancer(createdName);
            case "Boss":
                return new Boss(createdName);
                default:
                    return null;

        }
    }
}
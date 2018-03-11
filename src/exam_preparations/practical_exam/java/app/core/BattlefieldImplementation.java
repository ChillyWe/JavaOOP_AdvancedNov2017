package exam_preparations.practical_exam.java.app.core;

import app.contracts.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BattlefieldImplementation implements Battlefield {
    private List<Targetable> bosses;
    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;

    public BattlefieldImplementation(Writer writer, TargetableFactory targetableFactory, ActionFactory actionFactory) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.targetableFactory = targetableFactory;
        this.actionFactory = actionFactory;
        this.bosses = new ArrayList<>();
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            Action action = null;
            switch (actionName) {
                case "OneVsOne":
                    action = actionFactory.create(actionName, participantNames);
                    break;
                case "BossFight":
                    action = actionFactory.create(actionName, participantNames);
            }

            List<Targetable> actionParticipants = new ArrayList<>();
            if (action.getClass().getSimpleName().equals("BossFight")) {
                actionParticipants.add(this.bosses.get(0));
                this.bosses.remove(0);
            }
            for (String name : participantNames){
                if (this.participants.containsKey(name)){
                    if (!this.participants.get(name).getClass().getSimpleName().equals("Boss")) {
                        actionParticipants.add(this.participants.get(name));
                    }
                } else {
                    writer.writeLine(String.format("%s is not on the battlefield. %s failed.", name, actionName));
                    break;
                }
            }
// Look HERE dude
            writer.writeLine(action.executeAction(actionParticipants));

            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            writer.writeLine("Action does not exist.");
        }
    }

    @Override
    public void createParticipant(String name, String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        if (this.participants.containsKey(name)){
            writer.writeLine("Participant with that name already exists.");
            return;
        }

        switch (className) {
            case "Warrior":
                Targetable warrior = targetableFactory.create(name, className);
                this.participants.put(warrior.getName(), warrior);
                writer.writeLine(
                        String.format("%s %s entered the battlefield.", warrior.getClass().getSimpleName(), warrior.getName()));
                break;
            case "Wizard":
                Targetable wizard = targetableFactory.create(name, className);
                this.participants.put(wizard.getName(), wizard);
                writer.writeLine(
                        String.format("%s %s entered the battlefield.", wizard.getClass().getSimpleName(), wizard.getName()));
                break;
            case "Necromancer":
                Targetable necro = targetableFactory.create(name, className);
                this.participants.put(necro.getName(), necro);
                writer.writeLine(
                        String.format("%s %s entered the battlefield.", necro.getClass().getSimpleName(), necro.getName()));
                break;
            case "Boss":
                Targetable boss = targetableFactory.create(name, className);
                this.participants.put(boss.getName(), boss);
                this.bosses.add(boss);
                writer.writeLine(
                        String.format("%s %s entered the battlefield.", boss.getClass().getSimpleName(), boss.getName()));
                break;
            default:
                writer.writeLine("Participant class does not exist.");
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants(){
        if (this.participants.size() < 1) {
            writer.writeLine("There are no participants on the battlefield.");
            return;
        }

        for (String name : this.participants.keySet()) {
            writer.writeLine(this.participants.get(name).toString());
            writer.writeLine("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions(){
        if (this.executedActions.size() < 1) {
            writer.writeLine("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : this.executedActions) {
            writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants(){
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()){
                writer.writeLine(String.format("%s has been removed from the battlefield.", name));
            }else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}

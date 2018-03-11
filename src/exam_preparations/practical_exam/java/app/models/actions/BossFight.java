package exam_preparations.practical_exam.java.app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.*;

public class BossFight implements Action {
    private List<Targetable> participants;
    private Targetable boss;

    public String executeAction(List<Targetable> participants) {
        this.participants = participants;

        if (this.participants.size() < 1) {
            return "There should be at least 1 participant for boss fight!";
        }

        StringBuilder sb = new StringBuilder();

        this.boss = participants.get(0);
        this.participants = participants.subList(1, participants.size());

        while (this.participants.size() > 0) {
            for (Targetable participant : this.participants) {
                if (participant.getHealth() > 0) {
                    participant.attack(this.boss);
                }
                if (this.boss.isAlive()) {
                    this.boss.attack(participant);
                } else {
                    break;
                }
            }
        }

        this.participants.sort(Comparator.comparing(Targetable::getName));
        sb.append("Boss has been slain by:").append(System.lineSeparator());
        for (Targetable participant : this.participants) {
            if (!participant.isAlive()) {
                this.boss.giveReward(participant);
                sb.append(participant.toString()).append(System.lineSeparator());
            } else {
                this.participants.remove(participant);
            }
        }

        if (this.participants.size() < 1) {
            return ("Boss has slain them all!");
        }

        return sb.toString();
    }
}
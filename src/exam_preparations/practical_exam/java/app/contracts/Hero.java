package exam_preparations.practical_exam.java.app.contracts;

public interface Hero extends Targetable {

    int getStrength();

    void setStrength(int strength);

    int getDexterity();

    void setDexterity(int dexterity);

    int getIntelligence();

    void setIntelligence(int intelligence);
}
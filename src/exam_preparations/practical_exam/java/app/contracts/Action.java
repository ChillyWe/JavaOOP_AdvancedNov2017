package exam_preparations.practical_exam.java.app.contracts;

import java.util.List;

public interface Action {
    String executeAction(List<Targetable> participants);
}
